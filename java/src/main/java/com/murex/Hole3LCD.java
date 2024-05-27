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
import java.util.stream.IntStream;

import static java.util.Collections.nCopies;

public class Hole3LCD {

    private final static int digitTopLine = 0;
    private final static int digitMidLine = 1;
    private final static int digitBottomLine = 2;

    private final static int digitStartChar = 0;
    private final static int digitMidChar = 1;
    private final static int digitEndChar = 2;

    private final static List<List<String>> digits =
            List.of(
                    List.of(
                            " _ ",
                            "| |",
                            "|_|"
                    ),
                    List.of(
                            "   ",
                            "  |",
                            "  |"
                    ),
                    List.of(
                            " _ ",
                            " _|",
                            "|_ "
                    ),
                    List.of(
                            " _ ",
                            " _|",
                            " _|"
                    ),
                    List.of(
                            "   ",
                            "|_|",
                            "  |"
                    ),
                    List.of(
                            " _ ",
                            "|_ ",
                            " _|"
                    ),
                    List.of(
                            " _ ",
                            "|_ ",
                            "|_|"
                    ),
                    List.of(
                            " _ ",
                            "  |",
                            "  |"
                    ),
                    List.of(
                            " _ ",
                            "|_|",
                            "|_|"
                    ),
                    List.of(
                            " _ ",
                            "|_|",
                            " _|"
                    )
            );

    private final int height;
    private final int width;

    static String convert(int number, int height, int width) {
        return new Hole3LCD(height, width).invoke(number);
    }

    static String convert(int number, int height) {
        return convert(number, height, 1);
    }

    static String convert(int number) {
        return convert(number, 1);
    }


    private Hole3LCD(int height, int width) {
        this.height = height;
        this.width = width;
    }

    private String invoke(int number) {
        return joinLines(generateLines(number));
    }

    private List<String> generateLines(int number) {
        List<String> lines = new ArrayList<>();

        do {
            final int units = number % 10;
            lines = joinDigits(scale(digits.get(units)),
                    lines);
            number /= 10;
        } while (number > 0);

        return lines;
    }

    private static List<String> joinDigits(List<String> firstDigit,
                                           List<String> secondDigit) {
        if (secondDigit.size() == 0) {
            return firstDigit;
        }

        return IntStream.range(0, firstDigit.size())
                .mapToObj(i -> firstDigit.get(i) + secondDigit.get(i))
                .collect(Collectors.toList());
    }

    private List<String> scale(List<String> digit) {
        ArrayList<String> lines = new ArrayList<>();

        lines.add(scaleWidth(digit.get(digitTopLine)));
        lines.addAll(scaleHeight(
                scaleWidth(digit.get(digitMidLine))
        ));
        lines.addAll(scaleHeight(
                scaleWidth(digit.get(digitBottomLine))
        ));

        return lines;
    }

    private List<String> scaleHeight(String baseDigitLine) {
        ArrayList<String> lines = new ArrayList<>(nCopies(height - 1,
                lineWithoutUnderscore(baseDigitLine)));
        lines.add(baseDigitLine);

        return lines;
    }

    private String scaleWidth(String digitLine) {
        return digitLine.substring(digitStartChar, digitMidChar) +
                digitLine.substring(digitMidChar, digitEndChar).repeat(width) +
                digitLine.substring(digitEndChar);
    }


    private static String lineWithoutUnderscore(String digitLine) {
        return digitLine.replaceAll("_", " ");
    }

    private static String joinLines(List<String> lines) {
        return String.join("\n", lines);
    }
}
