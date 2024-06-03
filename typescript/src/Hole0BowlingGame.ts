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

const TOTAL_PINS = 10;
const FRAMES = 10;

export function score(...rolls: number[]): number {
    let score = 0;
    let iRoll = 0;
    for (let iFrame = 0; iFrame < FRAMES; iFrame++) {
        if (isStrike(rolls, iRoll)) {
            score += TOTAL_PINS + strikeBonus(rolls, iRoll);
            iRoll++;
        } else {
            score += rolls[iRoll] + rolls[iRoll + 1];
            iRoll += 2;
        }
    }
    return score;
}

function strikeBonus(rolls: number[], iRoll: number): number {
    return rolls[iRoll + 1] + rolls[iRoll + 2];
}

function isStrike(rolls: number[], iRoll: number): boolean {
    return rolls[iRoll] === TOTAL_PINS;
}
