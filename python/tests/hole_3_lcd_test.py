import pytest
from baby_steps_golf.hole_3_lcd import convert

def test_acceptance_test():
    expected = (
        "    _  _     _  _  _  _  _  _ \n"
        "  | _| _||_||_ |_   ||_||_|| |\n"
        "  ||_  _|  | _||_|  ||_| _||_|"
    )
    assert convert(1234567890) == expected

def test_can_convert_0_to_lcd():
    expected = (
        " _ \n"
        "| |\n"
        "|_|"
    )
    assert convert(0) == expected

def test_can_convert_1_to_lcd():
    expected = (
        "   \n"
        "  |\n"
        "  |"
    )
    assert convert(1) == expected

def test_can_convert_2_to_lcd():
    expected = (
        " _ \n"
        " _|\n"
        "|_ "
    )
    assert convert(2) == expected

def test_can_convert_12_to_lcd():
    expected = (
        "    _ \n"
        "  | _|\n"
        "  ||_ "
    )
    assert convert(12) == expected

def test_can_convert_21_to_lcd():
    expected = (
        " _    \n"
        " _|  |\n"
        "|_   |"
    )
    assert convert(21) == expected

def test_can_convert_120_to_lcd():
    expected = (
        "    _  _ \n"
        "  | _|| |\n"
        "  ||_ |_|"
    )
    assert convert(120) == expected

if __name__ == "__main__":
    pytest.main()
