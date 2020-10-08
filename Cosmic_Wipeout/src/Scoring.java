import java.util.Collections;
import java.util.PriorityQueue;

public class Scoring
{
    int numOnes;
    int numTwos;
    int numThrees;
    int numFours;
    int numFives;
    int numSixes;
    int numTens;

    public Scoring()
    {
        numOnes = 0;
        numTwos = 0;
        numThrees = 0;
        numFours = 0;
        numFives = 0;
        numSixes= 0;
        numTens= 0;
    }

    private void countValues(int[] roll)
    {
        for (int value : roll)
        {
            if (value == 1)                 //Count number of 1's
                numOnes++;
            if (value == 2)                 //Count number of 2's
                numTwos++;
            if (value == 3)                 //Count number of 3's
                numThrees++;
            if (value == 4)                 //Count number of 4's
                numFours++;
            if (value == 5)                 //Count number of 5's
                numFives++;
            if (value == 6)                 //Count number of 6's
                numSixes++;
            if (value == 10)                //Count number of 10's
                numTens++;
        }
    }

    private int produceScore()
    {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        queue.add(isFive());
        //System.out.println("isFive is equal to: " + isFive());
        queue.add(isTen());
        //System.out.println("isTen is equal to: " + isTen());
        queue.add(isFlash());
        //System.out.println("isFlash is equal to: " + isFlash());
        queue.add(isFreightTrain());
        //System.out.println("isFreightTrain is equal to: " + isFreightTrain());

        int score = queue.peek().intValue();
        return score;

    }

    private void resetVariables()
    {
        this.numOnes = 0;
        this.numTwos = 0;
        this.numThrees = 0;
        this.numFours = 0;
        this.numFives = 0;
        this.numSixes = 0;
        this.numTens = 0;
    }


    //Per rule 2c
    private Integer isFreightTrain()
    {
        Integer result = 0;

        if(this.numTwos == 5)
            result = 2*100;
        if(this.numFours == 5)
            result = 4*100;
        if(this.numFives == 5)
            result = 5*100;
        if(this.numSixes == 5)
            result = 6*100;

        return result;
    }

    //Per rule 2b
    private Integer isFlash()
    {
        Integer result = 0;

        if(this.numTwos >= 3 || (this.numTwos == 2 && this.numOnes == 1))
            result = 2*10;
        if(this.numThrees >= 3 || (this.numThrees == 2 && this.numOnes == 1))
            result = 3*10;
        if(this.numFours >= 3 || (this.numFours == 2 && this.numOnes == 1))
            result = 4*10;
        if(this.numFives >= 3 || (this.numFives == 2 && this.numOnes == 1))
            result = 5*10;
        if(this.numSixes >= 3 || (this.numSixes == 2 && this.numOnes == 1))
            result = 6*10;
        if(this.numTens >= 3 || (this.numTens == 2 && this.numOnes == 1))
            result = 10*10;

        return result;
    }

    //Per rule 2a
    private Integer isFive()
    {
        Integer result = 0;

        if(numFives > 0)
            result = numFives * 5; //5 times 10 = 50

        return result;
    }
    //Per rule 2a
    private Integer isTen()
    {
        Integer result = 0;

        if(numTens > 0)
            result = numTens * 10;

        return result;
    }

    protected int produceScore(int[] roll)
    {
        countValues(roll);
        int score = this.produceScore();
        resetVariables();
        return score;
    }

    private void displayVars()
    {
        System.out.println("Ones: " + this.numOnes);
        System.out.println("Twos: " + this.numTwos);
        System.out.println("Threes:" + this.numThrees);
        System.out.println("Fours: " + this.numFours);
        System.out.println("Fives: " + this.numFives);
        System.out.println("Sixes: " + this.numSixes);
        System.out.println("Tens: " + this.numTens);
    }

    public static void main(String[] Args)
    {
          Scoring test = new Scoring();
//        int[] roll = {1,2,3,4,5,6};
//        test.countValues(roll);
//        test.displayVars();
//        test.resetVariables();
//        System.out.println(test.produceScore(roll));

        int[] noScore = new int[]{1,2,3,4,6};       //No 5's or 10's present
        int[] score5 = new int[]{1,2,3,4,5};        //One 5 is present
        int[] score10a = new int[]{1,2,3,5,10};     //One 5 and 10, shows precedence of 10 over 5
        int[] score10b = new int[]{2,2,3,5,5};      //Two 5's
        int[] score20 = new int[]{2,5,5,10,10};     //Two 10's
        int[] score50a = new int[]{10,10,5,5,5};    //Three 5's - a flash, 5*10=50
        int[] score50b = new int[]{10,5,5,5,5};
        int[] score50c = new int[]{5,5,5,5,5};
        int[] score100a = new int[]{5,5,10,10,10};  //Three 10's - a flash, 10*10=100
        int[] score100b = new int[]{5,10,10,10,10};
        int[] score100c = new int[]{10,10,10,10,10};

        int[] freight1 = new int[]{1,1,1,1,1};
        int[] freight2 = new int[]{2,2,2,2,2};
        int[] freight3 = new int[]{3,3,3,3,3};
        int[] freight4 = new int[]{4,4,4,4,4};
        int[] freight5 = new int[]{5,5,5,5,5};
        int[] freight6 = new int[]{6,6,6,6,6};
        int[] freight10 = new int[]{10,10,10,10,10};

//        System.out.println("----Test isFive()----");
//        test.countValues(score5);
//        System.out.println(test.isFive() + " Expect 5");
        System.out.println("----Test produceScore()----");
        System.out.println(test.produceScore(noScore) + " Expect 0");
        System.out.println(test.produceScore(score5) + " Expect 5");
        System.out.println(test.produceScore(score10a) + " Expect 10");
        System.out.println(test.produceScore(score10b) + " Expect 10");
        System.out.println(test.produceScore(score20) + " Expect 20");
        System.out.println(test.produceScore(score50a) + " Expect 50");
        System.out.println(test.produceScore(score50b) + " Expect 50");
        System.out.println(test.produceScore(score50c) + " Expect 50");
        System.out.println(test.produceScore(score100a) + " Expect 100");
        System.out.println(test.produceScore(score100b) + " Expect 100");
        System.out.println(test.produceScore(score100c) + " Expect 100");

        System.out.println("Test Freight Trains - Only 2,4,5,6 should produce scores");
        System.out.println(test.produceScore(freight1) + " Expect 0");    //Cant roll three ones
        System.out.println(test.produceScore(freight2) + " Expect 200");
        System.out.println(test.produceScore(freight3) + " Expect 30");   //Three 3s results in a flash
        System.out.println(test.produceScore(freight4) + " Expect 400");
        System.out.println(test.produceScore(freight5) + " Expect 500");
        System.out.println(test.produceScore(freight6) + " Expect 600");
        System.out.println(test.produceScore(freight10) + " Expect 100"); //Three 10s results in a flash
    }

}


