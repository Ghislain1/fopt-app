package fopt.klausur.ghis.ss2019;

import java.util.Random;

public class Multiplication
{
    private int result;

    private void sleepRandom()
    {
        int timeToSleep = (int) (new Random().nextDouble() * 1000);

        try
        {
            Thread.sleep(timeToSleep);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public int multiply(int[] args)
    {
        this.result = 1;
        for (int arg : args)
        {
            result *= arg;
            this.sleepRandom();
        }

        System.out.println(">> " + Thread.currentThread().getName() + ": " + result);
        return result;
    }

}
