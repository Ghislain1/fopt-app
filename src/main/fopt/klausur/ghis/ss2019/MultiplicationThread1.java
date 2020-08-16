package fopt.klausur.ghis.ss2019;

import java.util.Random;

public class MultiplicationThread1 extends Thread
{
    private Multiplication multiplication;

    private Random random = new Random();

    public MultiplicationThread1(Multiplication multiplication, String name)
    {
        this.multiplication = multiplication;
        this.setName(name);
        this.start();
    }

    @Override
    public void run()
    {
        int[] args =
        { 1, 2, 3, 4, 5 };

        int result = this.multiplication.multiply(args);

    }
}
