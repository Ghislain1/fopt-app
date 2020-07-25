package fopt.klausur.ghis.ss2019;

public class MultiplicationDemo
{

    public static void main(String[] args)
    {
        // GgO
        Multiplication multiplication = new Multiplication();

        for (int i = 1; i <= 5; i++)
        {

            new MultiplicationThread1(multiplication, " MultiThread Nr." + i);

        }
    }

}
