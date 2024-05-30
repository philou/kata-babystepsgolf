package com.murex;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Hole0BowlingGameTest {

    @Test
    void acceptance_test() {
        assertEquals(133, Hole0BowlingGame.score(1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6));
    }

    @Test
    void gutter_game() {
        assertEquals(0, Hole0BowlingGame.score(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    @Test
    void one_pin_game() {
        assertEquals(1, Hole0BowlingGame.score(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    @Test
    void multiple_pins_game() {
        assertEquals(5, Hole0BowlingGame.score(1, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    @Test
    void one_strike() {
        assertEquals(24, Hole0BowlingGame.score(10, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    @Test
    void one_strike_then_gutter() {
        assertEquals(10, Hole0BowlingGame.score(10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    @Test
    void one_strike_at_the_second_frame() {
        assertEquals(20, Hole0BowlingGame.score(0, 0, 10, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    @Test
    void two_consecutive_strikes() {
        assertEquals(43, Hole0BowlingGame.score(0, 0, 10, 10, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    @Test
    void one_strike_in_last_frame_should_add_two_extra_rolls() {
        assertEquals(19, Hole0BowlingGame.score(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 6, 3));
    }

    @Test
    void all_strikes() {
        assertEquals(300, Hole0BowlingGame.score(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10));
    }

    @Test
    void one_spare() {
        assertEquals(18, Hole0BowlingGame.score(2, 8, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    @Test
    void one_spare_then_gutter() {
        assertEquals(10, Hole0BowlingGame.score(2, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    @Test
    void one_spare_at_second_frame() {
        assertEquals(16, Hole0BowlingGame.score(0, 0, 4, 6, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    @Test
    void it_should_not_be_considered_a_spare_if_in_different_frames() {
        assertEquals(13, Hole0BowlingGame.score(0, 0, 0, 4, 6, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
    }

    @Test
    void one_spare_in_last_frame_should_add_extra_roll() {
        assertEquals(13, Hole0BowlingGame.score(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 6, 3));
    }

    @Test
    void all_fives() {
        assertEquals(150, Hole0BowlingGame.score(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5));
    }
}
