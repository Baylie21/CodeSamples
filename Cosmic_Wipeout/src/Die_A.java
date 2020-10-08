public class Die_A extends Die
{
    //Constructor, a die with sides 2, 3, 4, 5, 6 and 10
    public Die_A()
    {
        cube = new int[]{2,3,4,5,6,10};
    }

    //Test Cases
    public static void main(String[] Args)
    {
        //Construct Die object
        Die_A test = new Die_A();

        //Test constructor and printArray()
        System.out.print("The sides of Die A are ");
        View.printArray(test.cube);
        System.out.print("Expect 2 3 4 5 6 10");

        //Test getRoll Method
        int result = test.getRoll();
        System.out.println();
        System.out.println("The result of one roll is " + result);
    }

}
