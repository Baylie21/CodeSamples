import java.util.Collections;
import java.util.LinkedList;
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
    int cubeBValue;
    LinkedList<Integer> scoringCubes;

    public Scoring()
    {
        numOnes = 0;
        numTwos = 0;
        numThrees = 0;
        numFours = 0;
        numFives = 0;
        numSixes= 0;
        numTens= 0;
        scoringCubes = new LinkedList<>();
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

    private void setCubeBValue(int[] roll)
    {
        cubeBValue = roll[4];
    }

    private Scoring_Container produceScore()
    {
        PriorityQueue<Scoring_Container> queue = new PriorityQueue<>(Collections.reverseOrder());



        queue.add(isFive());
        //System.out.println("isFive is equal to: " + isFive());

        queue.add(isTen());
        //System.out.println("isTen is equal to: " + isTen());
        queue.add(oneFlamingSun());
        queue.add(isFlash());
        //System.out.println("isFlash is equal to: " + isFlash());
        queue.add(isFreightTrain());
        //System.out.println("isFreightTrain is equal to: " + isFreightTrain());

        Scoring_Container score = queue.poll();
        updateScoringCubes(score);
        score.scoringCubes = this.scoringCubes;

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
        this.scoringCubes.clear();
    }

    //Per rule 2(d)
    protected Scoring_Container oneFlamingSun()
    {
        Scoring_Container flamingSun = new Scoring_Container();

        if(numOnes == 1)
        {
            flamingSun.result = 5;
            flamingSun.numOnesFlag = true;
        }
        return flamingSun;
    }
    //Per rule 2c
    protected Scoring_Container isFreightTrain()
    {
        Scoring_Container freight = new Scoring_Container();

        if(this.numTwos == 5)
        {
            freight.result = 2 * 100;
            freight.numTwosFlag = true;
        }
        if(this.numFours == 5)
        {
            freight.result = 4*100;
            freight.numFoursFlag = true;
        }
        if(this.numFives == 5)
        {
            freight.result = 5*100;
            freight.numFivesFlag = true;
        }
        if(this.numSixes == 5)
        {
            freight.result = 6 * 100;
            freight.numSixesFlag = true;
        }
        return freight;
    }

    //Per rule 2b
    protected Scoring_Container isFlash()
    {
        Scoring_Container flash = new Scoring_Container();

        if(this.numTwos >= 3 || (this.numTwos == 2 && this.numOnes == 1))
        {
            flash.result = (2*10);
            flash.numTwosFlag = true;
            flash.numOnesFlag = true;
        }
        if(this.numThrees >= 3 || (this.numThrees == 2 && this.numOnes == 1))
        {
            flash.result = 3 * 10;
            flash.numThreesFlag = true;
            flash.numOnesFlag = true;
        }
        if(this.numFours >= 3 || (this.numFours == 2 && this.numOnes == 1))
        {
            flash.result = 4 * 10;
            flash.numOnesFlag = true;
            flash.numFoursFlag = true;
        }
        if(this.numFives >= 3 || (this.numFives == 2 && this.numOnes == 1))
        {
            flash.result = 5*10;
            flash.numOnesFlag = true;
            flash.numFivesFlag = true;
        }
        if(this.numSixes >= 3 || (this.numSixes == 2 && this.numOnes == 1))
        {
            flash.result = 6*10;
            flash.numOnesFlag = true;
            flash.numSixesFlag = true;
        }
        if(this.numTens >= 3 || (this.numTens == 2 && this.numOnes == 1))
        {
            flash.result = 10 * 10;
            flash.numOnesFlag = true;
            flash.numTensFlag = true;
        }
        return flash;
    }

    //Per rule 2a
    private Scoring_Container isFive()
    {
        Scoring_Container five = new Scoring_Container();

        if(numFives > 0)
            five.result = numFives * 5; //5 times 10 = 50
            five.numFivesFlag = true;

        return five;
    }
    //Per rule 2a
    private Scoring_Container isTen()
    {
        Scoring_Container ten = new Scoring_Container();

        if(numTens > 0)
            ten.result = numTens * 10;
            ten.numTensFlag = true;

        return ten;
    }

    private void updateScoringCubes(Scoring_Container sc)
    {

        if(sc.numOnesFlag)
        {
            for(int i = 0; i < numOnes; i++)
            {
                scoringCubes.add(1);
            }
        }
        if(sc.numTwosFlag)
        {
            for(int i = 0; i < numTwos; i++){
                scoringCubes.add(2);}
        }
        if(sc.numThreesFlag)
        {
            for(int i = 0; i < numThrees; i++){
                scoringCubes.add(3);}
        }
        if(sc.numFoursFlag)
        {
            for(int i = 0; i < numFours; i++){
                scoringCubes.add(4);}
        }
        if(sc.numFivesFlag)
        {
            for(int i = 0; i < numFives; i++){
                scoringCubes.add(5);}
        }
        if(sc.numSixesFlag)
        {
            for(int i = 0; i < numSixes; i++){
                scoringCubes.add(6);}
        }
        if(sc.numTensFlag)
        {
            for(int i = 0; i < numTens; i++){
                scoringCubes.add(10);}
        }

    }

    protected Scoring_Container produceScore(int[] roll)
    {
        countValues(roll);
        setCubeBValue(roll);
        Scoring_Container score = this.produceScore();
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


