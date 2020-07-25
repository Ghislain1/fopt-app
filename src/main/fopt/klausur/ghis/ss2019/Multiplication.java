package fopt.klausur.ghis.ss2019;

public class Multiplication
{
    private int result;

    public int multiply(int[] args)
    {
        this.result = 1;
        for (int arg : args)
        {
            result *= arg;

        }
        // System.out.println(">> " + result);
        return result;
    }

}
