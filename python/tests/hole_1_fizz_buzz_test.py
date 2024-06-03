import pytest
from baby_steps_golf.hole_1_fizz_buzz import fizz_buzz

@pytest.mark.parametrize("input, expected", [
    (1, "1"),
    (2, "2"),
    (3, "Fizz"),
    (4, "4"),
    (5, "Buzz"),
    (6, "Fizz"),
    (10, "Buzz"),
    (15, "FizzBuzz"),
    (30, "FizzBuzz"),
    (33, "Fizz"),
    (50, "Buzz"),
    (75, "FizzBuzz"),
    (100, "Buzz"),
])
def test_fizz_buzz(input, expected):
    assert fizz_buzz(input) == expected

@pytest.mark.parametrize("input, expected", [
    # (105, "FizzBuzzBazz"),
    # (35, "BuzzBazz"),
    # (21, "FizzBazz"),
    # (14, "Bazz"),
    # (7, "Bazz"),
    (1, "1"),
])
def test_fizz_buzz_bazz(input, expected):
    assert fizz_buzz(input) == expected
