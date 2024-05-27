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

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Hole3LCDTest {

    @Test
    void acceptance_test() {
        final String expected
                = "    _  _     _  _  _  _  _  _ \n"
                + "  | _| _||_||_ |_   ||_||_|| |\n"
                + "  ||_  _|  | _||_|  ||_| _||_|";
        assertEquals(expected, Hole3LCD.convert(1234567890));
    }

    @Test
    void acceptance_test_with_scaling() {
        final String expected
                = "     __  __      __  __  __  __  __  __ \n"
                + "   |   |   ||  ||   |      ||  ||  ||  |\n"
                + "   |   |   ||  ||   |      ||  ||  ||  |\n"
                + "   | __| __||__||__ |__    ||__||__||  |\n"
                + "   ||      |   |   ||  |   ||  |   ||  |\n"
                + "   ||      |   |   ||  |   ||  |   ||  |\n"
                + "   ||__  __|   | __||__|   ||__| __||__|";
        assertEquals(expected, Hole3LCD.convert(1234567890, 3, 2));
    }

    @Test
    void can_convert_0_to_lcd() {
        final String expected
                = " _ \n"
                + "| |\n"
                + "|_|";
        assertEquals(expected, Hole3LCD.convert(0));
    }

    @Test
    void can_convert_1_to_lcd() {
        final String expected
                = "   \n"
                + "  |\n"
                + "  |";
        assertEquals(expected, Hole3LCD.convert(1));
    }

    @Test
    void can_convert_2_to_lcd() {
        final String expected
                = " _ \n"
                + " _|\n"
                + "|_ ";
        assertEquals(expected, Hole3LCD.convert(2));
    }

    @Test
    void can_convert_12_to_lcd() {
        final String expected
                = "    _ \n"
                + "  | _|\n"
                + "  ||_ ";
        assertEquals(expected, Hole3LCD.convert(12));
    }

    @Test
    void can_convert_21_to_lcd() {
        final String expected
                = " _    \n"
                + " _|  |\n"
                + "|_   |";
        assertEquals(expected, Hole3LCD.convert(21));
    }

    @Test
    void can_convert_120_to_lcd() {
        final String expected
                = "    _  _ \n"
                + "  | _|| |\n"
                + "  ||_ |_|";
        assertEquals(expected, Hole3LCD.convert(120));
    }

    @Test
    void can_scale_1_to_lcd_with_height_2() {
        final String expected
                = "   \n"
                + "  |\n"
                + "  |\n"
                + "  |\n"
                + "  |";
        assertEquals(expected, Hole3LCD.convert(1, 2));
    }

    @Test
    void can_scale_8_to_lcd_with_height_2() {
        final String expected
                = " _ \n"
                + "| |\n"
                + "|_|\n"
                + "| |\n"
                + "|_|";
        assertEquals(expected, Hole3LCD.convert(8, 2));
    }

    @Test
    void can_scale_1_to_lcd_with_height_3() {
        final String expected
                = "   \n"
                + "  |\n"
                + "  |\n"
                + "  |\n"
                + "  |\n"
                + "  |\n"
                + "  |";
        assertEquals(expected, Hole3LCD.convert(1, 3));
    }

    @Test
    void can_scale_18_to_lcd_with_height_2() {
        final String expected
                = "    _ \n"
                + "  || |\n"
                + "  ||_|\n"
                + "  || |\n"
                + "  ||_|";
        assertEquals(expected, Hole3LCD.convert(18, 2));
    }

    @Test
    void can_scale_18_to_lcd_with_height_4() {
        final String expected
                = "    _ \n"
                + "  || |\n"
                + "  || |\n"
                + "  || |\n"
                + "  ||_|\n"
                + "  || |\n"
                + "  || |\n"
                + "  || |\n"
                + "  ||_|";
        assertEquals(expected, Hole3LCD.convert(18, 4));
    }

    @Test
    void can_scale_1_to_lcd_with_width_2() {
        final String expected
                = "    \n"
                + "   |\n"
                + "   |";
        assertEquals(expected, Hole3LCD.convert(1, 1, 2));
    }

    @Test
    void can_scale_4_to_lcd_with_width_2() {
        final String expected
                = "    \n"
                + "|__|\n"
                + "   |";
        assertEquals(expected, Hole3LCD.convert(4, 1, 2));
    }
}
