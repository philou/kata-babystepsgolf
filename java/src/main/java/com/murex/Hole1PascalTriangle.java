/*
Copyright (c) 2023 Murex

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

package com.murex;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Hole1PascalTriangle {

    public static void main(String[] args) {
        int lastLine = Integer.parseInt(args[0]);
        System.out.println(draw(lastLine));
    }

    public static String draw(int lastLine) {
        List<List<Integer>> matrix = computeMatrix(lastLine);
        return convertMatrix(matrix);
    }

    static String convertMatrix(List<List<Integer>> matrix){
        List<String> stringLines = toStringLines(matrix);
        int width = textWidth(stringLines);
        return justifyAndJoinLines(stringLines, width);
    }

    private static List<String> toStringLines(List<List<Integer>> matrix) {
        return matrix.stream()
                .map(Hole1PascalTriangle::convertLine)
                .toList();
    }
    static String convertLine(List<Integer> integers) {
        return integers.stream().map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    private static int textWidth(List<String> stringLines) {
        return stringLines.get(stringLines.size() - 1).length();
    }

    private static String justifyAndJoinLines(List<String> stringLines, int width) {
        return stringLines.stream()
                .map(line -> justify(line, width))
                .map(line -> line + "\n")
                .collect(Collectors.joining(""));
    }

    private static String justify(String line, int width) {
        int missingSpaces = width - line.length();
        int frontMissingSpaces = missingSpaces/2;
        int backMissingSpaces = missingSpaces - frontMissingSpaces;
        return " ".repeat(frontMissingSpaces) + line + " ".repeat(backMissingSpaces);
    }

    static List<List<Integer>> computeMatrix(int size) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(List.of(1));
        for(int i = 0; i < size; i++){
            matrix.add(computeNext(matrix.get(i)));
        }
        return matrix;
    }
    static List<Integer> computeNext(List<Integer> currentLine) {
        var result = new ArrayList<Integer>();
        result.add(1);

        for (int i = 0; i < currentLine.size() - 1; i++) {
            result.add(currentLine.get(i) + currentLine.get(i + 1));
        }

        result.add(1);
        return result;
    }
}
