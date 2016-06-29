package thesoulforged.net.multidice;

import java.util.Random;


public class DiceUtil {

    //Dice types
    public static int d4Type = 0;
    public static int d6Type = 1;
    public static int d8Type = 2;
    public static int d10Type = 3;
    public static int d10bType = 4;
    public static int d12Type = 5;
    public static int d20Type = 6;


    public static int specialStartIndex = 1000;
    public static int dNACType = specialStartIndex+1;



    //For the standard dices we define the minimum and the maximum value appearing on them
    /*Stardard dices are those that have correlative values in their sides, starting at min and
    finishing at max, the number of sides is implictly defined by max-min+1
     */

    public static int d4Min = 1;
    public static int d6Min = 1;
    public static int d8Min = 1;
    public static int d10Min = 1;
    public static int d10bMin = 1;
    public static int d12Min = 1;
    public static int d20Min = 1;


    public static int d4Max = 4;
    public static int d6Max = 6;
    public static int d8Max = 8;
    public static int d10Max = 10;
    public static int d10bMax = 10;
    public static int d12Max = 12;
    public static int d20Max = 20;


    public static int[] diceMin = new int[]{d4Min, d6Min, d8Min, d10Min, d10bMin, d12Min, d20Min};
    public static int[] diceMax = new int[]{d4Max, d6Max, d8Max, d10Max, d10bMax, d12Max, d20Max};

    /*For the special dices we define an array with the possible values and a second array for the
    probability of each value.
    Special dices are those thar either hace special values in their sides, that have different
    probabilities for each value or both
    */

    /* To calculate the probability of each side we add up all the probabilities in the array and
    then the side probais divided by that total. The sum of all the probabilities is considered 100%
     */

    public static int[] dNACValues = new int[] {2,3,4,5};
    public static int[] dNACProb = new int[] {1, 2, 2, 1};

    public static int[][] diceValues = new int[][] {dNACValues};
    public static int[][] diceProbs = new int[][] {dNACProb};


    public static int[] throwDice(int diceType, int numDices){
        if (diceType <= specialStartIndex){
            return throwStandardDice(diceType,numDices);
        }else{
            return throwSpecialDice(diceType,numDices);
        }
    }

    public static int[] throwStandardDice(int diceType, int numDices) {
        int[] values = new int[numDices];
        Random randomizer = new Random();
        for (int i = 0; i < numDices; i++) {
            values[i] = randomizer.nextInt(DiceUtil.diceMax[diceType] - DiceUtil.diceMin[diceType] + 1) + DiceUtil.diceMin[diceType];
        }
        return values;
    }

    public static int[] throwSpecialDice(int diceType, int numDices) {
        int[] values = new int[numDices];
        Random randomizer = new Random();

        int sum = 0;
        for (int i = 0; i < diceProbs[diceType - specialStartIndex].length; i++) {
            sum = sum + diceProbs[diceType - specialStartIndex][i];
        }
        for (int i = 0; i < numDices; i++) {
            int intermediateValue = randomizer.nextInt(sum + 1);
            sum = 0;
            boolean found = false;
            int j = 0;
            while (!found){
                sum = sum + diceProbs[diceType - specialStartIndex][j];
                if (sum >= intermediateValue) found = true;
                values[i] = diceValues[diceType-specialStartIndex][j];
                j++;
            }
        }
        return values;
    }


}
