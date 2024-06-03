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
// Hole3LCD.ts

const digits: string[][] = [
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
];

export function convert(number: number): string {
    return joinLines(generateLines(number));
}
export function convertH(number: number, height: number): string {
    throw new Error("not implemented");
}
export function convertHW(number: number, height: number, width: number): string {
    throw new Error("not implemented");
}

function generateLines(number: number): string[] {
    let lines: string[] = [];

    do {
        const units = number % 10;
        lines = joinDigits(digits[units], lines);
        number = Math.floor(number / 10);
    } while (number > 0);

    return lines;
}

function joinDigits(firstDigit: string[], secondDigit: string[]): string[] {
    if (secondDigit.length === 0) {
        return firstDigit;
    }

    return firstDigit.map((line, i) => line + secondDigit[i]);
}

function joinLines(lines: string[]): string {
    return lines.join("\n");
}

// Command-line interface
if (require.main === module) {
    const number = parseInt(process.argv[2]);
    console.log(convert(number));
}
