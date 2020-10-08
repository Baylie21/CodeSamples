public class Mock_Driver
{

    private Player user;
    private Player cpu;
    private Die cube_A;
    private Die cube_B;

    //Constructor
    public Mock_Driver()
    {
        user = new Player();   //Create Human player object
        cpu = new Player();    //Create cpu player object
        cube_A = new Die_A();  //Create Cube A Die A object
        cube_B = new Die_B();  //Create Cube B Die B object
    }

    //Pre: There is one human and one computer player
    //Inputs: None
    //Assumptions: None
    //Post: The game has been played
    protected void playGame()
    {
        user.setName();                            //Get users name
        user.setTurn(true);                        //Allow user to go first
        cpu.setName("Prometheus");                 //Cpu name is always prometheus

        while(!user.isWinner() && !cpu.isWinner()) //while there are no winners
        {
            if (user.getTurn())                    //if its the users turn
                cpu.setTurn(takeATurn(user));      //roll dice until turn is over, then set cpu.isTurn to true
            else
                user.setTurn(takeATurn(cpu));      //if not users turn, cpu rolls dice until turn is over,
        }                                          //then sets user.turn to true

        if(user.isWinner())                        //if user is winner, display message
            displayWinner(user);
        else                                       //if cpu is winner, display message
            displayWinner(cpu);
    }

    //Pre: A player is ready to begin their turn
    //Inputs: player - the player object whose turn it is
    //Assumptions: None
    //Post: player has executed entire turn
    private boolean takeATurn(Player player)
    {
        boolean keepGoing = true;                                      //Boolean representing loop condition
        System.out.println("It's " + player.getName() + "'s turn.");   //Display name of player whose turn it is
        while(keepGoing)                                               //While its still the players turn
        {
            keepGoing = takeOneRoll(player);                           //Take one turn
        }
        player.setTurn(false);                                         //Set turn to false if a non scoring roll occurs

        if(!player.isWinner())                                         //if player is not a winner, display turn being
            System.out.println(player.getName() + "'s turn is over."); //over

        return true;                                                   //Always returns true to set turn of other player
    }

    //Pre: It is a players turn to roll
    //Inputs: player - player object whose rolling the dice
    //Assumptions: None
    //Post: true is returned if a scoring roll occurs, false otherwise
    private boolean takeOneRoll(Player player)
    {
        boolean flag = false;                            //flag representing a scoring(true) or non-scoring(false) roll
        if(!player.isWinner())                           //roll dice if the players score is not >= 500
        {
            int[] roll = rollDice();                     //Roll the dice
            int score = calcScore(roll);                 //Calculate value of roll
            if (score > 0)                               //if a scoring roll occurs
            {
                player.setScore(score);                  //update players score
                flag = true;                             //update flag to reflect scoring roll
            }                                            //display players score
            System.out.println(player.getName() + "'s score is " + player.getScore());
        }
        return flag;                                     //return scoring or non-scoring flag
    }

    //Pre: It is a players turn to roll
    //Inputs: player - player object whose rolling the dice
    //        dieRoll - predetermined value of die for testing purposes
    //Assumptions: None
    //Post: true is returned if a scoring roll occurs, false otherwise
    private boolean takeOneRoll(Player player, int[] dieRoll)
    {
        boolean flag = false;                            //flag representing a scoring(true) or non-scoring(false) roll
        if(!player.isWinner())                           //roll dice if the players score is not >= 500
        {
            int[] roll = dieRoll;                        //Predetermined value of dice for testing purposes
            int score = calcScore(roll);                 //Calculate value of roll
            if (score > 0)                               //if a scoring roll occurs
            {
                player.setScore(score);                  //update players score
                flag = true;                             //update flag to reflect scoring roll
            }                                            //display players score
            System.out.println(player.getName() + "'s score is " + player.getScore());
        }
        return flag;                                     //return scoring or non-scoring flag
    }

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
        cube_A.printArray(results);               //Display result of rolling the dice
        return results;                           //Return result of rolling the dice
    }

    //Pre: It is a players turn who has less than 500 points
    //Inputs: None
    //Assumptions: None
    //Post: The score from rolling dice has been calculated
    private int calcScore(int[] roll)
    {
        int[] results = roll;  //The results of one roll have been passed in
        int numFives = 0;
        int numTens = 0;

        //Current increment allows scoring only through 5's and 10's
        for (int result : results) {
            if (result == 5)                 //Count number of 5's
                numFives++;
            if (result == 10)                //Count number of 10's
                numTens++;
        }
        //Structure of if statements will return the highest score possible from roll
        if(numTens >= 3) //Flash involving three 10's
            return 100; //10 times 10 = 100

        if(numFives >= 3)
            return 50; //5 times 10 = 50

        if(numTens == 2)
            return 20;

        if(numTens == 1 || numFives == 2)
            return 10;

        if(numFives == 1)
            return 5;

        return 0;
    }

    //Pre: None
    //Inputs: player - player object
    //Assumptions: player has scored 500 or more points
    //Post: players name and score have been displayed, as well as victory message
    private void displayWinner(Player player)
    {
        System.out.println(player.getName() + " has " + player.getScore() + " points. ");
        System.out.println(player.getName() + " is victorious!");
    }

    //Test Cases
    public static void main(String[] Args)
    {
        //Constructor
        Mock_Driver TEST = new Mock_Driver();

        //Create test player object
        Player test = new Player("test");

        System.out.println("-----Test displayWinner()-----");
        TEST.displayWinner(test);
        System.out.println("Expect: test has 0 points.");
        System.out.println("Expect: test is victorious!");

        System.out.println("----Test rollDice()----");
        TEST.rollDice();
        System.out.println("Expect: 5 randomly generated numbers"); //Range of Values for 5 numbers valid by Die_A/B test
        TEST.rollDice();
        System.out.println("Expect: 5 randomly generated numbers"); //of getRoll() function

        System.out.println("----Test takeOneRoll()----");
        int[] noScore = new int[]{1,2,3,4,6};       //No 5's or 10's present
        int[] score5 = new int[]{1,2,3,4,5};        //One 5 is present
        int[] score10a = new int[]{1,2,3,5,10};     //One 5 and 10, shows precedence of 10 over 5
        int[] score10b = new int[]{1,2,3,5,5};      //Two 5's
        int[] score20 = new int[]{1,5,5,10,10};     //Two 10's
        int[] score50a = new int[]{10,10,5,5,5};    //Three 5's - a flash, 5*10=50
        int[] score50b = new int[]{10,5,5,5,5};
        int[] score50c = new int[]{5,5,5,5,5};
        int[] score100a = new int[]{5,5,10,10,10};  //Three 10's - a flash, 10*10=100
        int[] score100b = new int[]{5,10,10,10,10};
        int[] score100c = new int[]{10,10,10,10,10};
        test.setScore(500);  //test Player is winner
        System.out.println(TEST.takeOneRoll(test, noScore) + " Expect false");
        System.out.println(TEST.takeOneRoll(test, score5) + " Expect false");
        test.setScore(-500);   //test Player is not a winner
        System.out.println(TEST.takeOneRoll(test, noScore) + " Expect false");
        System.out.println(TEST.takeOneRoll(test, score5) + " Expect true");

        System.out.println("----Test calcScore()----");
        System.out.println(TEST.calcScore(noScore) + " Expect 0");
        System.out.println(TEST.calcScore(score5) + " Expect 5");
        System.out.println(TEST.calcScore(score10a) + " Expect 10");
        System.out.println(TEST.calcScore(score10b) + " Expect 10");
        System.out.println(TEST.calcScore(score20) + " Expect 20");
        System.out.println(TEST.calcScore(score50a) + " Expect 50");
        System.out.println(TEST.calcScore(score50b) + " Expect 50");
        System.out.println(TEST.calcScore(score50c) + " Expect 50");
        System.out.println(TEST.calcScore(score100a) + " Expect 100");
        System.out.println(TEST.calcScore(score100b) + " Expect 100");
        System.out.println(TEST.calcScore(score100c) + " Expect 100");

    }
}
