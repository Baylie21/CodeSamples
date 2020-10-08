import java.util.Scanner;

public class Turn
{
    protected RollWizard roll;
    protected boolean discontinue;

    public Turn()
    {
        roll = new RollWizard();
    }


    //Pre: A player is ready to begin their turn
    //Inputs: player - the player object whose turn it is
    //Assumptions: None
    //Post: player has executed entire turn
    void takeATurn(Player player)
    {
        boolean keepGoing = true;                                      //Boolean representing loop condition
        View.beginTurnMsg(player);                                     //Display name of player whose turn it is
        while(keepGoing)                                               //While its still the players turn
        {
            keepGoing = roll.takeOneRoll(player);                           //Take one turn
            if(discontinue(player))
                break;
        }

        if(!player.isWinner)                                         //if player is not a winner, display turn being
            View.endTurnMsg(player); //over
    }

    boolean discontinue(Player player)
    {
        View.discontinueMsg(player);
        int answer = View.scan.nextInt();
        if (answer == 1)
            discontinue = false;
        else if (answer == 2)
        {
            restartGame(player);
            System.exit(0);
        }
        else if(answer == 3)
            discontinue = true;
        else
        {
            View.reDiscontinueMsg(player);
            discontinue(player);
        }
        return discontinue;
    }

    private void restartGame(Player player)
    {
        Driver driver = new Driver(player.getName());
        driver.playGame();
    }
}
