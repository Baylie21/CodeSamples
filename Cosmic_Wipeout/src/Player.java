import java.util.Scanner;

public class Player
{
    private boolean isTurn;  //Instance variable for tracking whether it is the players turn or not
    private String name;     //Instance variable for storing players name
    private int score;       //Instance variable for storing players score

    //Constructor
    public Player()
    {
        score = 0;
    }

    //Constructor for testing purposes
    public Player(String name)
    {
        score = 0;
        this.name = name;
    }

    //Pre: None
    //Inputs: None
    //Assumptions: Player object has been created
    //Post: value of isTurn has been returned
    protected boolean getTurn()
    {
        return this.isTurn;
    }

    //Pre: None
    //Inputs: turn - a boolean determining if it is the players turn or not
    //Assumptions: Player object has been created
    //Post: value of turn has been set
    protected void setTurn(boolean turn)
    {
        this.isTurn = turn;
    }

    //Pre: None
    //Inputs: None
    //Assumptions: Player object has been created
    //Post: value of score has been returned
    protected int getScore()
    {
        return this.score;
    }

    //Pre: None
    //Inputs: score - an int determining the amount to increment the users score by
    //Assumptions: Player object has been created
    //Post: value of score has been updated
    protected void setScore(int val)
    {
        this.score += val;
    }

    //Pre: None
    //Inputs: None
    //Assumptions: Player object has been created
    //Post: True is returned if the players score is greater than or equal to 500, false otherwise
    protected boolean isWinner()
    {
        boolean winner = false;

        int win = 500;
        if(this.score >= win)
            winner = true;

        return winner;
    }

    //Pre: None
    //Inputs: None
    //Assumptions: Player object has been created
    //Post: value of name has been returned
    protected String getName() {
        return name;
    }

    //Pre: None
    //Inputs: None
    //Assumptions: Player object has been created
    //Post: Player name is set by the user
    protected void setName()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your name");
        this.name = scan.nextLine();
    }

    //Pre: None
    //Inputs: Name - a string representing a players name
    //Assumptions: Player object has been created
    //Post: Players name has been set
    protected void setName(String name)
    {
        this.name = name;
    }

    //Test Cases
    public static void main(String[] args)
    {
        //Create player object
        Player test = new Player();

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
        test.setName();
        System.out.println("The player's name is: " + test.getName() + " Expect previous line input");
    }
}
