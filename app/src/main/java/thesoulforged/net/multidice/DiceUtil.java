package thesoulforged.net.multidice;

import java.util.Random;


public class DiceUtil {
    public static int d4Min = 1;
    public static int d6Min = 1;
    public static int d8Min = 1;
    public static int d10Min = 1;
    public static int d10bMin = 1;
    public static int d12Min = 1;
    public static int d20Min = 1;
    public static int dNACMin = 1;

    public static int d4Max = 4;
    public static int d6Max = 6;
    public static int d8Max = 8;
    public static int d10Max = 10;
    public static int d10bMax = 10;
    public static int d12Max = 12;
    public static int d20Max = 20;
    public static int dNACMax = 6;

    public static int d4Type = 0;
    public static int d6Type = 1;
    public static int d8Type = 2;
    public static int d10Type = 3;
    public static int d10bType = 4;
    public static int d12Type = 5;
    public static int d20Type = 6;
    public static int dNACType = 7;

    public static int[] diceMin = new int[]{d4Min, d6Min, d8Min, d10Min, d10bMin, d12Min, d20Min, dNACMin};
    public static int[] diceMax = new int[]{d4Max, d6Max, d8Max, d10Max, d10bMax, d12Max, d20Max, dNACMax};

    public static int[] throwStandardDice(int diceType, int dices) {
        int[] values = new int[dices];
        Random randomizer = new Random();
        for (int i = 0; i < dices; i++) {
            values[i] = randomizer.nextInt(DiceUtil.diceMax[diceType] - DiceUtil.diceMin[diceType] + 1) + DiceUtil.diceMin[diceType];
        }
        return values;
    }
}
