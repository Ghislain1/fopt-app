package fopt.klausur.ghis.ss2019;

import java.util.Random;

public class MultiplicationThread2 extends Thread
{
    private Multiplication multiplication;

    private Random random = new Random();

    public MultiplicationThread2(Multiplication multiplication, String name)
    {
        this.multiplication = multiplication;
        this.setName(name);
        this.start();
    }

    @Override
    public void run()
    {
        int[] args =
        { 1, 1, 1, 1, 2 };

        long result = this.multiplication.multiply(args);
        System.out.println(">> " + Thread.currentThread().getName() + ": " + result);
    }
}
