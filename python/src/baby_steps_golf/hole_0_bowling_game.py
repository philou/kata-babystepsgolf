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

TOTAL_PINS = 10
FRAMES = 10

def score(*rolls: int) -> int:
    score = 0
    i_roll = 0
    for _ in range(FRAMES):
        if is_strike(rolls, i_roll):
            score += TOTAL_PINS + strike_bonus(rolls, i_roll)
            i_roll += 1
        else:
            score += rolls[i_roll] + rolls[i_roll + 1]
            i_roll += 2
    return score

def strike_bonus(rolls: tuple[int, ...], i_roll: int) -> int:
    return rolls[i_roll + 1] + rolls[i_roll + 2]

def is_strike(rolls: tuple[int, ...], i_roll: int) -> bool:
    return rolls[i_roll] == TOTAL_PINS
