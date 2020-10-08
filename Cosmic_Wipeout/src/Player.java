import java.util.Scanner;

public abstract class Player
{
    protected boolean isTurn;  //Instance variable for tracking whether it is the players turn or not
    protected String name;     //Instance variable for storing players name
    protected int score;       //Instance variable for storing players score

    //Constructor
    public Player()
    {
        score = 0;
        //Scoring score = new Scoring();
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
    protected String getName()
    {
        return name;
    }
}
