public class Player_Human extends Player
{
//    protected boolean isTurn;  //Instance variable for tracking whether it is the players turn or not
//    protected String name;     //Instance variable for storing players name
//    protected int score;       //Instance variable for storing players score

    public Player_Human()
    {

    }

    //Constructor for testing purposes
    public Player_Human(String name)
    {
        //score = 0;
        this.name = name;
    }

    //Test Cases
    public static void main(String[] args)
    {
        //Create player object
        Player test = new Player_Human();

        //Test getTurn() and setTurn()
        System.out.println("The player's turn is " + test.getTurn() + " Expect false");
        test.setTurn(true);
        System.out.println("The player's turn is " + test.getTurn() + " Expect true");
        test.setTurn(false);
        System.out.println("The player's turn is " + test.getTurn() + " Expect false");

        //Test getScore() and setScore()
        System.out.println("The player's score is " + test.getScore() + " Expect 0");
        test.setScore(5);
        System.out.println("The player's score is " + test.getScore() + " Expect 5");

        //Test isWinner()
        System.out.println("The player is a winner: " + test.isWinner() + " Expect false");
        test.setScore(495);
        System.out.println("The player's score is " + test.getScore());
        System.out.println("The player is a winner: " + test.isWinner() + " Expect true");
        test.setScore(25);
        System.out.println("The player's score is " + test.getScore());
        System.out.println("The player is a winner: " + test.isWinner() + " Expect true");

        //Test setName() and getName()
        test.setName("pizza");
        System.out.println("The player's name is: " + test.getName() + " Expect pizza");
        test.setName("Baylie"); //Expect to be reasked until valid data is input
        test.setName();
        System.out.println("The player's name is: " + test.getName() + " Expect previous line input");
    }
}
