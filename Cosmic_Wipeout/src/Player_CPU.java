public class Player_CPU extends Player
{
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
