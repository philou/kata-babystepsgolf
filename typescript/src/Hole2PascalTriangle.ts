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

export function computeNext(currentLine: number[]): number[] {
    const result = [1];
    for (let i = 0; i < currentLine.length - 1; i++) {
        result.push(currentLine[i] + currentLine[i + 1]);
    }
    result.push(1);
    return result;
}

export function computeMatrix(size: number): number[][] {
    const matrix = [[1]];
    for (let i = 0; i < size; i++) {
        matrix.push(computeNext(matrix[matrix.length - 1]));
    }
    return matrix;
}

export function convertLine(integers: number[]): string {
    return integers.join(' ');
}

export function convertMatrix(matrix: number[][]): string {
    return matrix.map(convertLine).join('\n') + '\n';
}

/**
 * @deprecated Use `convertMatrix(...)` instead.
 */
export function legacyConvertMatrix(matrix: number[][]): string {
    return matrix.map(line => line.join(' ')).join('\n') + '\n';
}

export function draw(lastLine: number): string {
    const matrix = computeMatrix(lastLine);
    return convertMatrix(matrix);
}

/**
 * @deprecated Use `draw(...)` instead.
 */
export function legacyDraw(lastLine: number): string {
    const matrix = computeMatrix(lastLine);
    return legacyConvertMatrix(matrix);
}
