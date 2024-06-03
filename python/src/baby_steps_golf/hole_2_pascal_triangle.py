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

from typing import List

def compute_next(current_line: List[int]) -> List[int]:
    result = [1]
    for i in range(len(current_line) - 1):
        result.append(current_line[i] + current_line[i + 1])
    result.append(1)
    return result

def compute_matrix(size: int) -> List[List[int]]:
    matrix = [[1]]
    for _ in range(size):
        matrix.append(compute_next(matrix[-1]))
    return matrix

def convert_line(integers: List[int]) -> str:
    return ' '.join(map(str, integers))

def convert_matrix(matrix: List[List[int]]) -> str:
    return '\n'.join(convert_line(line) for line in matrix) + '\n'

# deprecated
def legacy_convert_matrix(matrix: List[List[int]]) -> str:
    return '\n'.join(' '.join(map(str, line)) for line in matrix) + '\n'

def draw(last_line: int) -> str:
    matrix = compute_matrix(last_line)
    return convert_matrix(matrix)

# deprecated
def legacy_draw(last_line: int) -> str:
    matrix = compute_matrix(last_line)
    return legacy_convert_matrix(matrix)

if __name__ == "__main__":
    import sys
    last_line = int(sys.argv[1])
    print(draw(last_line))
