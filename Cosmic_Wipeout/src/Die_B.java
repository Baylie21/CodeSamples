public class Die_B extends Die
{
    //Constructor, a die with sides 1, 2, 4, 5, 6 and 10
    public Die_B()
    {
        cube = new int[]{1,2,4,5,6,10};
    }

    public static void main(String[] Args)
    {
        //Construct Die object
        Die_B test = new Die_B();

        //Test constructor and printArray()
        System.out.print("The sides of Die B are ");
        test.printArray(test.cube);
        System.out.print("Expect 1 2 4 5 6 10");

        //Test getRoll Method
        int result = test.getRoll();
        System.out.println();
        System.out.println("The result of one roll is " + result);
    }


}
