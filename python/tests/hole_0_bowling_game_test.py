import pytest
from baby_steps_golf.hole_0_bowling_game import score

@pytest.mark.parametrize("rolls, expected, test_name", [
    pytest.param((1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6), 133, "acceptance_test", marks=pytest.mark.skip(reason="Disabled test")),
    ((0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 0, "gutter_game"),
    ((1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 1, "one_pin_game"),
    ((1, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 5, "multiple_pins_game"),
    ((10, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 24, "one_strike"),
    ((10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 10, "one_strike_then_gutter"),
    ((0, 0, 10, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 20, "one_strike_at_the_second_frame"),
    ((0, 0, 10, 10, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 43, "two_consecutive_strikes"),
    ((0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 6, 3), 19, "one_strike_in_last_frame_should_add_two_extra_rolls"),
    ((10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10), 300, "all_strikes"),
    pytest.param((2, 8, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 18, "one_spare", marks=pytest.mark.skip(reason="Disabled test")),
    pytest.param((2, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 10, "one_spare_then_gutter", marks=pytest.mark.skip(reason="Disabled test")),
    pytest.param((0, 0, 4, 6, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 16, "one_spare_at_second_frame", marks=pytest.mark.skip(reason="Disabled test")),")),
    pytest.param((0, 0, 0, 4, 6, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 13, "not_a_spare_if_in_different_frames", marks=pytest.mark.skip(reason="Disabled test")),")),
    pytest.param((0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 6, 3), 13, "one_spare_in_last_frame", marks=pytest.mark.skip(reason="Disabled test")),")),
    pytest.param((5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5), 150, "all_fives", marks=pytest.mark.skip(reason="Disabled test")),")),
])
def test_bowling_game(rolls, expected, test_name):
    assert score(*rolls) == expected
