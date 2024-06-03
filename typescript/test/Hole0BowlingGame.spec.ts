import {score} from "../src/Hole0BowlingGame";

describe('Bowling Game', () => {
    test.skip('acceptance_test', () => {
        expect(score(1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6)).toBe(133);
    });

    test('gutter_game', () => {
        expect(score(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)).toBe(0);
    });

    test('one_pin_game', () => {
        expect(score(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)).toBe(1);
    });

    test('multiple_pins_game', () => {
        expect(score(1, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)).toBe(5);
    });

    test('one_strike', () => {
        expect(score(10, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)).toBe(24);
    });

    test('one_strike_then_gutter', () => {
        expect(score(10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)).toBe(10);
    });

    test('one_strike_at_the_second_frame', () => {
        expect(score(0, 0, 10, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)).toBe(20);
    });

    test('two_consecutive_strikes', () => {
        expect(score(0, 0, 10, 10, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)).toBe(43);
    });

    test('one_strike_in_last_frame_should_add_two_extra_rolls', () => {
        expect(score(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 6, 3)).toBe(19);
    });

    test('all_strikes', () => {
        expect(score(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10)).toBe(300);
    });

    test.skip('one_spare', () => {
        expect(score(2, 8, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)).toBe(18);
    });

    test.skip('one_spare_then_gutter', () => {
        expect(score(2, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)).toBe(10);
    });

    test.skip('one_spare_at_second_frame', () => {
        expect(score(0, 0, 4, 6, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)).toBe(16);
    });

    test.skip('not_a_spare_if_in_different_frames', () => {
        expect(score(0, 0, 0, 4, 6, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)).toBe(13);
    });

    test.skip('one_spare_in_last_frame', () => {
        expect(score(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 6, 3)).toBe(13);
    });

    test.skip('all_fives', () => {
        expect(score(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5)).toBe(150);
    });
});
