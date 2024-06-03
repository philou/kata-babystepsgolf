import { convert, convertH, convertHW } from '../src/Hole3LCD';

describe('Hole3LCD', () => {
    test('acceptance test', () => {
        const expected =
            "    _  _     _  _  _  _  _  _ \n" +
            "  | _| _||_||_ |_   ||_||_|| |\n" +
            "  ||_  _|  | _||_|  ||_| _||_|";
        expect(convert(1234567890)).toBe(expected);
    });

    test.skip("acceptance test with scaling", () => {
        const expected =
            "     __  __      __  __  __  __  __  __ \n" +
            "   |   |   ||  ||   |      ||  ||  ||  |\n" +
            "   |   |   ||  ||   |      ||  ||  ||  |\n" +
            "   | __| __||__||__ |__    ||__||__||  |\n" +
            "   ||      |   |   ||  |   ||  |   ||  |\n" +
            "   ||      |   |   ||  |   ||  |   ||  |\n" +
            "   ||__  __|   | __||__|   ||__| __||__|";
        expect(convertHW(1234567890, 3, 2)).toBe(expected);
    });
    
    test('can convert 0 to lcd', () => {
        const expected =
            " _ \n" +
            "| |\n" +
            "|_|";
        expect(convert(0)).toBe(expected);
    });

    test('can convert 1 to lcd', () => {
        const expected =
            "   \n" +
            "  |\n" +
            "  |";
        expect(convert(1)).toBe(expected);
    });

    test('can convert 2 to lcd', () => {
        const expected =
            " _ \n" +
            " _|\n" +
            "|_ ";
        expect(convert(2)).toBe(expected);
    });

    test('can convert 12 to lcd', () => {
        const expected =
            "    _ \n" +
            "  | _|\n" +
            "  ||_ ";
        expect(convert(12)).toBe(expected);
    });

    test('can convert 21 to lcd', () => {
        const expected =
            " _    \n" +
            " _|  |\n" +
            "|_   |";
        expect(convert(21)).toBe(expected);
    });

    test('can convert 120 to lcd', () => {
        const expected =
            "    _  _ \n" +
            "  | _|| |\n" +
            "  ||_ |_|";
        expect(convert(120)).toBe(expected);
    });

    test.skip('can scale 1 to lcd with height 2', () => {
        const expected =
            "   \n" +
            "  |\n" +
            "  |\n" +
            "  |\n" +
            "  |";
        expect(convertH(1, 2)).toBe(expected);
    });
    
    test.skip('can_scale_8_to_lcd_with_height_2', () => {
        const expected =
            " _ \n" +
            "| |\n" +
            "|_|\n" +
            "| |\n" +
            "|_|";
        expect(convertH(8, 2)).toBe(expected);
    });
    
    test.skip('can_scale_1_to_lcd_with_height_3', () => {
        const expected =
            "   \n" +
            "  |\n" +
            "  |\n" +
            "  |\n" +
            "  |\n" +
            "  |\n" +
            "  |";
        expect(convertH(1, 3)).toBe(expected);
    });
    
    test.skip('can_scale_18_to_lcd_with_height_2', () => {
        const expected =
            "    _ \n" +
            "  || |\n" +
            "  ||_|\n" +
            "  || |\n" +
            "  ||_|";
        expect(convertH(18, 2)).toBe(expected);
    });
    
    test.skip('can_scale_18_to_lcd_with_height_4', () => {
        const expected =
            "    _ \n" +
            "  || |\n" +
            "  || |\n" +
            "  || |\n" +
            "  ||_|\n" +
            "  || |\n" +
            "  || |\n" +
            "  || |\n" +
            "  ||_|";
        expect(convertH(18, 4)).toBe(expected);
    });
    
    test.skip('can_scale_1_to_lcd_with_width_2', () => {
        const expected =
            "    \n" +
            "   |\n" +
            "   |";
        expect(convertHW(1, 1, 2)).toBe(expected);
    });
    
    test.skip('can_scale_4_to_lcd_with_width_2', () => {
        const expected =
            "    \n" +
            "|__|\n" +
            "   |";
        expect(convertHW(4, 1, 2)).toBe(expected);
    });
});
