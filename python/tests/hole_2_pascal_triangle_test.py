import pytest
from baby_steps_golf.hole_2_pascal_triangle import (
    compute_next, compute_matrix, convert_line, convert_matrix,
    legacy_convert_matrix, draw, legacy_draw
)

def test_compute_next_line_for_1():
    assert compute_next([1]) == [1, 1]

def test_compute_next_line_for_1_1():
    assert compute_next([1, 1]) == [1, 2, 1]

def test_compute_next_line_for_1_3_3_1():
    assert compute_next([1, 3, 3, 1]) == [1, 4, 6, 4, 1]

def test_compute_next_line_for_1_2_1():
    assert compute_next([1, 2, 1]) == [1, 3, 3, 1]

def test_convert_line_to_string_representation_1_1():
    assert convert_line([1, 1]) == "1 1"

# deprecated
def test_legacy_convert_matrix_of_size_1():
    matrix = [[1]]
    assert legacy_convert_matrix(matrix) == "1\n"

# deprecated
def test_legacy_convert_matrix_of_size_2():
    matrix = [
        [1],
        [1, 1]
    ]
    expected = (
        "1\n"
        "1 1\n"
    )
    assert legacy_convert_matrix(matrix) == expected

# deprecated
def test_legacy_convert_matrix_of_size_3():
    matrix = [
        [1],
        [1, 1],
        [1, 2, 1]
    ]
    expected = (
        "1\n"
        "1 1\n"
        "1 2 1\n"
    )
    assert legacy_convert_matrix(matrix) == expected

@pytest.mark.skip(reason="Disabled test")
def test_convert_matrix_of_size_1():
    matrix = [[1]]
    assert convert_matrix(matrix) == "1\n"

@pytest.mark.skip(reason="Disabled test")
def test_convert_matrix_of_size_2():
    matrix = [
        [1],
        [1, 1]
    ]
    expected = (
        " 1 \n"
        "1 1\n"
    )
    assert convert_matrix(matrix) == expected

@pytest.mark.skip(reason="Disabled test")
def test_convert_matrix_of_size_3():
    matrix = [
        [1],
        [1, 1],
        [1, 2, 1]
    ]
    expected = (
        "  1  \n"
        " 1 1 \n"
        "1 2 1\n"
    )
    assert convert_matrix(matrix) == expected

# deprecated
def test_legacy_acceptance():
    last_line = 7
    expected = (
        "1\n"
        "1 1\n"
        "1 2 1\n"
        "1 3 3 1\n"
        "1 4 6 4 1\n"
        "1 5 10 10 5 1\n"
        "1 6 15 20 15 6 1\n"
        "1 7 21 35 35 21 7 1\n"
    )
    assert legacy_draw(last_line) == expected

@pytest.mark.skip(reason="Disabled test")
def test_acceptance():
    last_line = 7
    expected = (
        "         1         \n"
        "        1 1        \n"
        "       1 2 1       \n"
        "      1 3 3 1      \n"
        "     1 4 6 4 1     \n"
        "   1 5 10 10 5 1   \n"
        " 1 6 15 20 15 6 1  \n"
        "1 7 21 35 35 21 7 1\n"
    )
    assert draw(last_line) == expected
