import pytest

from baby_steps_golf.baby_steps_golf import do_something


class TestBabyStepsGolf:

    @pytest.mark.skip(reason="test currently disabled") # Comment or remove this line to enable this test case
    def test_acceptance_test(self) -> None:
        assert(42 == do_something())
