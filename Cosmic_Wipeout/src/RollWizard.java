public class RollWizard
{
    private Die_A cube_A;
    private Die_B cube_B;
    private Scoring_Human humanScoreWizard;
    private Scoring_CPU cpuScoreWizard;

    public RollWizard()
    {
        cube_A = new Die_A();                     //Create Cube A Die A object
        cube_B = new Die_B();                     //Create Cube B Die B object
        humanScoreWizard = new Scoring_Human();   //Create a Human scoring object
        cpuScoreWizard = new Scoring_CPU();       //Create a CPU scoring object
    }

    //Pre: It is a players turn to roll
    //Inputs: player - player object whose rolling the dice
    //Assumptions: None
    //Post: true is returned if a scoring roll occurs, false otherwise
    protected boolean takeOneRoll(Player player)
    {
        boolean flag = false;                            //flag representing a scoring(true) or non-scoring(false) roll
        if(!player.isWinner)                             //roll dice if the players score is not >= 500
        {
            int[] roll = rollDice();                     //Roll the dice
            Scoring_Container sc = calcScore(roll, player);         //Calculate value of roll
            int score = sc.result;
            if (score > 0)                               //if a scoring roll occurs
            {
               //flag = wantReroll(player, score, sc);         //update flag to reflect scoring roll
               player.setScore(score);
               flag = true;
            }                                            //display players score
            View.displayScore(player);
        }
        return flag;                                     //return scoring or non-scoring flag
    }

//    private boolean wantReroll(Player player, int score, Scoring_Container sc)
//    {
//        View.reRollMSG();
//        if(View.scan.nextInt() == 1)
//            player.setScore(score);
//        else
//            while( sc.scoringCubes.size() <= 5)
//            {
//                sc.scoringCubes.add(cube_A.getRoll());
//            }
//
//
//            score = calcScore(sc.scoringCubes.toArray(), player);
//
//
//        return score;
//
//
//    }


    //Pre: It is a players turn with less than 500 points
    //Inputs: None
    //Assumptions: None
    //Post: The results of rolling the dice have been displayed and returned
    private int[] rollDice()
    {
        int[] results = new int[5];               //Allocate array to store results of roll

        for(int i = 0; i < results.length; i++)
        {
            if(i < results.length - 1)            //Roll Cube A 4 times
                results[i] = cube_A.getRoll();    //add result to array
            else                                  //Roll Cube B 1 time
                results[i] = cube_B.getRoll();    //add result to array
        }
        View.printArray(results);                 //Display result of rolling the dice
        return results;                           //Return result of rolling the dice
    }



    //Pre: It is a players turn who has less than 500 points
    //Inputs: None
    //Assumptions: None
    //Post: The score from rolling dice has been calculated
    private Scoring_Container calcScore(int[] roll, Player player)
    {
        Scoring_Container sc;

        if(player instanceof Player_Human)
        {
            sc = humanScoreWizard.produceScore(roll);

        }
        else {
            sc = cpuScoreWizard.produceScore(roll);
        }

        return sc;

    }

//    public boolean isReRoll(Player player, Scoring_Container sc)
//    {
//        if(player.getScore() < 35)
//            if()
//
//    }

    public static void main(String[] args) {

        RollWizard TEST = new RollWizard();
        Player_Human test = new Player_Human("Tom");
        //Test rollDice()
        TEST.rollDice();
        System.out.println("Expect: 5 randomly generated numbers"); //Range of Values for 5 numbers valid by Die_A/B test
        TEST.rollDice();
        System.out.println("Expect: 5 randomly generated numbers"); //of getRoll() function
        TEST.takeOneRoll(test);
    }
}
