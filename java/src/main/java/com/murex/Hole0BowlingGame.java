package com.murex;

public class Hole0BowlingGame {
    private static final int TOTAL_PINS = 10;
    private static final int FRAMES = 10;

    static int score(int... rolls) {
        int score = 0;

        int iRoll = 0;
        for (int iFrame = 0; iFrame < FRAMES; iFrame++) {
            if (isStrike(rolls, iRoll)) {
                score += TOTAL_PINS + strikeBonus(rolls, iRoll);
                iRoll++;
            } else if(isSpare(iRoll, rolls)) {
                score += TOTAL_PINS + spareBonus(iRoll, rolls);
                iRoll += 2;
            } else {
                score += rolls[iRoll] + rolls[iRoll + 1];
                iRoll += 2;
            }
        }
        return score;
    }

    private static int spareBonus(int iRoll, int[] rolls) {
        return rolls[iRoll + 2];
    }

    private static boolean isSpare(int iRoll, int[] rolls) {
        return rolls[iRoll] + rolls[iRoll + 1] == TOTAL_PINS;
    }

    private static int strikeBonus(int[] rolls, int iRoll) {
        return rolls[iRoll + 1] + rolls[iRoll + 2];
    }

    private static boolean isStrike(int[] rolls, int iRoll) {
        return rolls[iRoll] == TOTAL_PINS;
    }
}
