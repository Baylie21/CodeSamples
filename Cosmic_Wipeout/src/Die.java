/*
A class to represent a die

die numbers
------------
flaming sun - side 1
swirls - side 2
triangular glyphs - side 3
lightning blots - side 4
stars - side 6

Scoring combos
--------------
flash - 3 of a kind
freight train - 5 of a kind
 */
import java.util.Random;

public abstract class Die
{
    protected int[] cube;        //Array representing the sides of the cube
    private int numSides = 6;    //Integer representing the number of sides of the cube

    //Constructor
    public Die()
    {
    }

    //Pre: None
    //Inputs: None
    //Assumptions: Die object has been created
    //Post: A roll has been simulated and a value is returned
    protected int getRoll()
    {
        Random rnd = new Random();
        int side = rnd.nextInt(numSides);

        return cube[side];
    }

    //Pre: None
    //Inputs: array - an array of values
    //Assumptions - None
    //Post: the contents of the array have been displayed
    protected void printArray(int[] array)
    {
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }
}
