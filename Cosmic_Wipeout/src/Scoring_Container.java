import java.util.LinkedList;

public class Scoring_Container implements Comparable<Scoring_Container>
{

    int result;
    boolean numOnesFlag;
    boolean numTwosFlag;
    boolean numThreesFlag;
    boolean numFoursFlag;
    boolean numFivesFlag;
    boolean numSixesFlag;
    boolean numTensFlag;
    LinkedList<Integer> scoringCubes;

    public Scoring_Container()
    {
        scoringCubes = new LinkedList<>();
    }

    @Override
    public int compareTo(Scoring_Container other) {
        if(this.result > other.result)
            return 1;
        else if(this.result < other.result)
            return -1;
        else
            return 0;

    }

}
