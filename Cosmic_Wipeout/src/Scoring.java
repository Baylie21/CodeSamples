import java.util.Collections;
import java.util.PriorityQueue;

public abstract class Scoring
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

        queue.add(oneFlamingSun());

        queue.add(isFive());
        //System.out.println("isFive is equal to: " + isFive());
        queue.add(isTen());
        //System.out.println("isTen is equal to: " + isTen());
        queue.add(isFlash());
        //System.out.println("isFlash is equal to: " + isFlash());
        queue.add(isFreightTrain());
        //System.out.println("isFreightTrain is equal to: " + isFreightTrain());

        int score = queue.peek();

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

    //Per rule 2(d)
    private Integer oneFlamingSun()
    {
        int result = 0;

        if(numOnes == 1)
            result = 5;

        return result;
    }
    //Per rule 2c
    abstract Integer isFreightTrain();

    //Per rule 2b
    abstract Integer isFlash();

    //Per rule 2a
    private Integer isFive()
    {
        int result = 0;

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
}


