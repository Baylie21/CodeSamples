public class Driver
{
    protected Player_Human user;
    protected Player_CPU cpu;
    protected Turn turn;

    //Constructor
    public Driver()
    {
        user = new Player_Human();                //Create Human player object
        cpu = new Player_CPU();                   //Create cpu player object
        turn = new Turn();
    }

    public Driver(String name)
    {
        user = new Player_Human(name);                //Create Human player object
        cpu = new Player_CPU();                   //Create cpu player object
        turn = new Turn();
    }

    private void initializeGame()
    {
        //choose which game they want to select
    }

    //Pre: There is one human and one computer player
    //Inputs: None
    //Assumptions: None
    //Post: The game has been played
    protected void playGame()
    {
        multiGameProc();
        displayWinnerMulti();
    }

    protected void playSingleGame()
    {
        singleGameProc();
        displayWinnerSingle();
    }

    private void singleGameProc()
    {
        while (!user.isWinner && !turn.discontinue) //while there are no winners and the user wants to continue
        {
            turn.takeATurn(user);
        }
    }

    private void multiGameProc()
    {
        while (!user.isWinner && !cpu.isWinner && !turn.discontinue)  //while there are no winners
        {                                                            //if its the users turn
            while (!user.isWinner && !turn.discontinue) //while there are no winners and the user wants to continue
            {
                turn.takeATurn(user);
            }                                        //roll dice until turn is over, then set cpu.isTurn to true

            while (!cpu.isWinner && !turn.discontinue)
                turn.takeATurn(cpu);
        }
    }

    private void displayWinnerMulti()
    {
        if(!turn.discontinue)
        {
            if (user.isWinner)                         //if user is winner, display message
                View.displayWinnerMsg(user);
            else                                       //if cpu is winner, display message
                View.displayWinnerMsg(cpu);
        }
        else
            View.endGameMsg();
    }

    private void displayWinnerSingle()
    {
        if(turn.discontinue)
            View.endGameMsg();
        else
            View.displayWinnerMsg(user);
    }

    //Test Cases
    public static void main(String[] Args) {
        //Constructor
        Driver TEST = new Driver();

        //Create test player object
        Player test = new Player_Human("test");

        //Test discontinue()
//        System.out.println(TEST.discontinue());
//        System.out.println(TEST.discontinue());
    }
}
