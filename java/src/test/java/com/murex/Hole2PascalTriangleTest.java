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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

class Hole2PascalTriangleTest {

    @Test
    @Deprecated
    public void legacy_acceptance_test() {
        int lastLine = 7;
        String expected = """
                1
                1 1
                1 2 1
                1 3 3 1
                1 4 6 4 1
                1 5 10 10 5 1
                1 6 15 20 15 6 1
                1 7 21 35 35 21 7 1
                """;
        assertEquals(expected, Hole2PascalTriangle.legacyDraw(lastLine));
    }


    @Test
    @Disabled
    public void acceptance_test() {
        int lastLine = 7;
        String expected =
                "         1         \n"+
                "        1 1        \n"+
                "       1 2 1       \n"+
                "      1 3 3 1      \n"+
                "     1 4 6 4 1     \n"+
                "   1 5 10 10 5 1   \n"+
                " 1 6 15 20 15 6 1  \n"+
                "1 7 21 35 35 21 7 1\n";
        assertEquals(expected, Hole2PascalTriangle.draw(lastLine));
    }

    @Test
    public void compute_next_line_for_1(){
        List<Integer> expected = List.of(1, 1);
        assertEquals(expected, Hole2PascalTriangle.computeNext(List.of(1)));
    }

    @Test
    public void compute_next_line_for_1_1(){
        List<Integer> expected = List.of(1, 2, 1);
        assertEquals(expected, Hole2PascalTriangle.computeNext(List.of(1, 1)));
    }
    @Test
    public void compute_next_line_for_1_3_3_1(){
        List<Integer> expected = List.of(1, 4, 6, 4, 1);
        assertEquals(expected, Hole2PascalTriangle.computeNext(List.of(1,3, 3, 1)));
    }

    @Test
    public void compute_next_line_for_1_2_1(){
        List<Integer> expected = List.of(1, 3, 3, 1);
        assertEquals(expected, Hole2PascalTriangle.computeNext(List.of(1, 2, 1)));
    }

    @Test
    public void convert_line_to_string_representation_1_1() {
        assertEquals("1 1", Hole2PascalTriangle.convertLine(List.of(1,1)));
    }

    @Test
    @Deprecated
    void legacy_convert_matrix_of_size_1() {
        var matrix = List.of(List.of(1));
        assertEquals("1\n", Hole2PascalTriangle.legacyConvertMatrix(matrix));
    }

    @Test
    @Deprecated
    void legacy_convert_matrix_of_size_2() {
        var matrix = List.of(
                List.of(1),
                List.of(1, 1)
        );
        String expected = """
                1
                1 1
                """;
        assertEquals(expected, Hole2PascalTriangle.legacyConvertMatrix(matrix));
    }

    @Test
    @Deprecated
    void legacy_convert_matrix_of_size_3() {
        var matrix = List.of(
                List.of(1),
                List.of(1, 1),
                List.of(1, 2, 1)
        );
        String expected = """
                1
                1 1
                1 2 1
                """;
        assertEquals(expected, Hole2PascalTriangle.legacyConvertMatrix(matrix));
    }

    @Test
    @Disabled
    void convert_matrix_of_size_1() {
        var matrix = List.of(List.of(1));
        assertEquals("1\n", Hole2PascalTriangle.convertMatrix(matrix));
    }

    @Test
    @Disabled
    void convert_matrix_of_size_2() {
        var matrix = List.of(
                List.of(1),
                List.of(1, 1)
        );
        String expected =
                " 1 \n"+
                "1 1\n";
        assertEquals(expected, Hole2PascalTriangle.convertMatrix(matrix));
    }

    @Test
    @Disabled
    void convert_matrix_of_size_3() {
        var matrix = List.of(
                List.of(1),
                List.of(1, 1),
                List.of(1, 2, 1)
        );
        String expected =
                "  1  \n"+
                " 1 1 \n"+
                "1 2 1\n";
        assertEquals(expected, Hole2PascalTriangle.convertMatrix(matrix));
    }

}
