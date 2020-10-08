public class Player_CPU extends Player
{
//    protected boolean isTurn;  //Instance variable for tracking whether it is the players turn or not
//    protected String name;     //Instance variable for storing players name
//    protected int score;       //Instance variable for storing players score

    public Player_CPU()
    {
        this.name = "Baylie";
    }

    //Test Cases
    public static void main(String[] args)
    {
        //Create player object
        Player test = new Player_CPU();

        //Test getName()
        System.out.println("The player's name is: " + test.getName() + " Expect Baylie");
    }
}
