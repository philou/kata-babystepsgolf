import {fizzBuzz} from "../src/Hole1FizzBuzz";

describe('FizzBuzz', () => {
    test.each([
        [1, "1"],
        [2, "2"],
        [3, "Fizz"],
        [4, "4"],
        [5, "Buzz"],
        [6, "Fizz"],
        [10, "Buzz"],
        [15, "FizzBuzz"],
        [30, "FizzBuzz"],
        [33, "Fizz"],
        [50, "Buzz"],
        [75, "FizzBuzz"],
        [100, "Buzz"],
    ])('returns %s for input %i', (input, expected) => {
        expect(fizzBuzz(input)).toBe(expected);
    });

    test.each([
        // [105, "FizzBuzzBazz"],
        // [35, "BuzzBazz"],
        // [21, "FizzBazz"],
        // [14, "Bazz"],
        // [7, "Bazz"],
        [1, "1"],
    ])('returns %s for special input %i', (input, expected) => {
        expect(fizzBuzz(input)).toBe(expected);
    });
});
