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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Hole2FizzBuzzTest {

    @ParameterizedTest
    @MethodSource("provideFizzBuzzCases")
    void testFizzBuzz(int input, String expected) {
        assertEquals(expected, Hole2FizzBuzz.fizzBuzz(input));
    }

    private static Stream<Arguments> provideFizzBuzzCases() {
        return Stream.of(
                Arguments.of(1, "1"),
                Arguments.of(2, "2"),
                Arguments.of(3, "Fizz"),
                Arguments.of(4, "4"),
                Arguments.of(5, "Buzz"),
                Arguments.of(6, "Fizz"),
                Arguments.of(10, "Buzz"),
                Arguments.of(15, "FizzBuzz"),
                Arguments.of(30, "FizzBuzz"),
                Arguments.of(33, "Fizz"),
                Arguments.of(50, "Buzz"),
                Arguments.of(75, "FizzBuzz"),
                Arguments.of(100, "Buzz")
        );
    }

    @ParameterizedTest
    @MethodSource("provideFizzBuzzBazzCases")
    void testFizzBuzzBazz(int input, String expected) {
        assertEquals(expected, Hole2FizzBuzz.fizzBuzz(input));
    }

    private static Stream<Arguments> provideFizzBuzzBazzCases() {
        return Stream.of(
                Arguments.of(105, "FizzBuzzBazz"),
                Arguments.of(35, "BuzzBazz"),
                Arguments.of(21, "FizzBazz"),
                Arguments.of(14, "Bazz"),
                Arguments.of(7, "Bazz"),
                Arguments.of(1, "1")
        );
    }
}

