import pytest
from baby_steps_golf.hole_3_lcd import convert

def test_acceptance_test():
    expected = (
        "    _  _     _  _  _  _  _  _ \n"
        "  | _| _||_||_ |_   ||_||_|| |\n"
        "  ||_  _|  | _||_|  ||_| _||_|"
    )
    assert convert(1234567890) == expected

@pytest.mark.skip(reason="Disabled test")
def test_acceptance_test_with_scaling():
    expected = (
        "     __  __      __  __  __  __  __  __ \n"
        "   |   |   ||  ||   |      ||  ||  ||  |\n"
        "   |   |   ||  ||   |      ||  ||  ||  |\n"
        "   | __| __||__||__ |__    ||__||__||  |\n"
        "   ||      |   |   ||  |   ||  |   ||  |\n"
        "   ||      |   |   ||  |   ||  |   ||  |\n"
        "   ||__  __|   | __||__|   ||__| __||__|"
    )
    assert convert(1234567890, 3, 2) == expected

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

@pytest.mark.skip(reason="Disabled test")
def test_can_scale_1_to_lcd_with_height_2():
    expected = (
        "   \n"
        "  |\n"
        "  |\n"
        "  |\n"
        "  |"
    )
    assert convert(1, 2) == expected

@pytest.mark.skip(reason="Disabled test")
def test_can_scale_8_to_lcd_with_height_2():
    expected = (
        " _ \n"
        "| |\n"
        "|_|\n"
        "| |\n"
        "|_|"
    )
    assert convert(8, 2) == expected

@pytest.mark.skip(reason="Disabled test")
def test_can_scale_1_to_lcd_with_height_3():
    expected = (
        "   \n"
        "  |\n"
        "  |\n"
        "  |\n"
        "  |\n"
        "  |\n"
        "  |"
    )
    assert convert(1, 3) == expected

@pytest.mark.skip(reason="Disabled test")
def test_can_scale_18_to_lcd_with_height_2():
    expected = (
        "    _ \n"
        "  || |\n"
        "  ||_|\n"
        "  || |\n"
        "  ||_|"
    )
    assert convert(18, 2) == expected

@pytest.mark.skip(reason="Disabled test")
def test_can_scale_18_to_lcd_with_height_4():
    expected = (
        "    _ \n"
        "  || |\n"
        "  || |\n"
        "  || |\n"
        "  ||_|\n"
        "  || |\n"
        "  || |\n"
        "  || |\n"
        "  ||_|"
    )
    assert convert(18, 4) == expected

@pytest.mark.skip(reason="Disabled test")
def test_can_scale_1_to_lcd_with_width_2():
    expected = (
        "    \n"
        "   |\n"
        "   |"
    )
    assert convert(1, 1, 2) == expected

@pytest.mark.skip(reason="Disabled test")
def test_can_scale_4_to_lcd_with_width_2():
    expected = (
        "    \n"
        "|__|\n"
        "   |"
    )
    assert convert(4, 1, 2) == expected

if __name__ == "__main__":
    pytest.main()
