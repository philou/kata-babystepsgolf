# Copyright (c) 2023 Murex
#
# Permission is hereby granted, free of charge, to any person obtaining a copy
# of this software and associated documentation files (the "Software"), to deal
# in the Software without restriction, including without limitation the rights
# to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
# copies of the Software, and to permit persons to whom the Software is
# furnished to do so, subject to the following conditions:
#
# The above copyright notice and this permission notice shall be included in all
# copies or substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
# SOFTWARE.

digits = [
    [" _ ", 
     "| |", 
     "|_|"],
    ["   ", 
     "  |",
     "  |"],
    [" _ ",
     " _|",
     "|_ "],
    [" _ ",
     " _|",
     " _|"],
    ["   ",
     "|_|",
     "  |"],
    [" _ ",
     "|_ ",
     " _|"],
    [" _ ",
     "|_ ",
     "|_|"],
    [" _ ",
     "  |",
     "  |"],
    [" _ ",
     "|_|",
     "|_|"],
    [" _ ",
     "|_|",
     " _|"]
]

def convert(number: int) -> str:
    return join_lines(generate_lines(number))

def generate_lines(number: int) -> list:
    lines = []
    
    while True:
        units = number % 10
        lines = join_digits(digits[units], lines)
        number //= 10

        if number == 0:
            break
    
    return lines

def join_digits(first_digit: list, second_digit: list) -> list:
    if not second_digit:
        return first_digit

    return [first + second for first, second in zip(first_digit, second_digit)]

def join_lines(lines: list) -> str:
    return "\n".join(lines)

if __name__ == "__main__":
    import sys
    number = int(sys.argv[1])
    print(convert(number))
