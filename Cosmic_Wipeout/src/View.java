import java.util.LinkedList;
import java.util.Scanner;

public class View
{
    protected static Scanner scan;

    public View()
    {
        scan = new Scanner(System.in);
    }

//----Methods for displaying output from the Driver class ----//

    protected static void endGameMsg()
    {
        System.out.println("The user has elected to end the game");
    }

    //Pre: None
    //Inputs: player - player object
    //Assumptions: player has scored 500 or more points
    //Post: players name and score have been displayed, as well as victory message
    protected static void displayWinnerMsg(Player player)
    {
        System.out.println(player.getName() + " has " + player.getScore() + " points. ");
        System.out.println(player.getName() + " is victorious!");
    }

//------------------------------------------------------------//

//----Methods for displaying output from the Player class ----//


    protected static void askName()
    {
        System.out.println("Please enter your name");
    }

    protected static String getName()
    {
        return scan.nextLine().toLowerCase().trim();
    }

    protected static void beginTurnMsg(Player player)
    {
        System.out.println("It's " + player.getName() + "'s turn.");
    }

    protected static void endTurnMsg(Player player)
    {
        System.out.println(player.getName() + "'s turn is over.");
    }

    protected static void discontinueMsg(Player player)
    {
        System.out.println(player.getName() + ", would you like to continue (1), restart (2) or exit (3) the game");
    }

    protected static void reDiscontinueMsg(Player player)
    {
        System.out.println(player.getName() + ", please enter 1, 2 or 3");
    }

    protected static void reRollMSG()
    {

        System.out.println("Would you like to reroll non scoring cubes?");
    }

//-------------------- Miscellaneous output-------------------//

    //Pre: None
    //Inputs: array - an array of values
    //Assumptions - None
    //Post: the contents of the array have been displayed
    //For testing purposes
    protected static void printArray(int[] array)
    {
        for ( int value : array) System.out.print(value + " ");
    }

    //Appears in RollWizard
    protected static void displayScore(Player player)
    {
        System.out.println(player.getName() + "'s score is " + player.getScore());
    }

    public static void printLinkedList(LinkedList list) {
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i) + " ");
        }
    }
}
