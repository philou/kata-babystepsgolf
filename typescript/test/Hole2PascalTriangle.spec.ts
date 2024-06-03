import {
    computeNext, computeMatrix, convertLine, convertMatrix,
    legacyConvertMatrix, draw, legacyDraw
} from "../src/Hole2PascalTriangle";

describe('Pascal Triangle', () => {

    test('compute next line for [1]', () => {
        expect(computeNext([1])).toEqual([1, 1]);
    });

    test('compute next line for [1, 1]', () => {
        expect(computeNext([1, 1])).toEqual([1, 2, 1]);
    });

    test('compute next line for [1, 3, 3, 1]', () => {
        expect(computeNext([1, 3, 3, 1])).toEqual([1, 4, 6, 4, 1]);
    });

    test('compute next line for [1, 2, 1]', () => {
        expect(computeNext([1, 2, 1])).toEqual([1, 3, 3, 1]);
    });

    test('convert line to string representation [1, 1]', () => {
        expect(convertLine([1, 1])).toBe("1 1");
    });

    /**
     * @deprecated
     */
    test('legacy convert matrix of size 1', () => {
        const matrix = [[1]];
        expect(legacyConvertMatrix(matrix)).toBe("1\n");
    });

    /**
     * @deprecated
     */
    test('legacy convert matrix of size 2', () => {
        const matrix = [
            [1],
            [1, 1]
        ];
        const expected = 
            "1\n"+
            "1 1\n";
        expect(legacyConvertMatrix(matrix)).toBe(expected);
    });

    /**
     * @deprecated
     */
    test('legacy convert matrix of size 3', () => {
        const matrix = [
            [1],
            [1, 1],
            [1, 2, 1]
        ];
        const expected = 
            "1\n"+
            "1 1\n"+
            "1 2 1\n";
        expect(legacyConvertMatrix(matrix)).toBe(expected);
    });

    test.skip('convert matrix of size 1', () => {
        const matrix = [[1]];
        expect(convertMatrix(matrix)).toBe("1\n");
    });

    test.skip('convert matrix of size 2', () => {
        const matrix = [
            [1],
            [1, 1]
        ];
        const expected = 
            " 1 \n" +
            "1 1\n";
        expect(convertMatrix(matrix)).toBe(expected);
    });

    test.skip('convert matrix of size 3', () => {
        const matrix = [
            [1],
            [1, 1],
            [1, 2, 1]
        ];
        const expected = 
            "  1  \n"+
            " 1 1 \n"+
            "1 2 1\n";
        expect(convertMatrix(matrix)).toBe(expected);
    });

    /**
     * @deprecated
     */
    test('legacy acceptance test', () => {
        const lastLine = 7;
        const expected =
            "1\n" +
            "1 1\n" +
            "1 2 1\n" +
            "1 3 3 1\n" +
            "1 4 6 4 1\n" +
            "1 5 10 10 5 1\n" +
            "1 6 15 20 15 6 1\n" +
            "1 7 21 35 35 21 7 1\n";
        expect(legacyDraw(lastLine)).toBe(expected);
    });

    test.skip('acceptance test', () => {
        const lastLine = 7;
        const expected =
            "         1         \n" +
            "        1 1        \n" +
            "       1 2 1       \n" +
            "      1 3 3 1      \n" +
            "     1 4 6 4 1     \n" +
            "   1 5 10 10 5 1   \n" +
            " 1 6 15 20 15 6 1  \n" +
            "1 7 21 35 35 21 7 1\n";
        expect(draw(lastLine)).toBe(expected);
    });
});