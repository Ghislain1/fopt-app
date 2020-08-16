package fopt.klausur.ghis.ss2019;

public class MultiplicationThread2 extends Thread
{
    private Multiplication multiplication;

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
        { 0, 0 };

        long result = this.multiplication.multiply(args);
        // System.out.println(">> " + Thread.currentThread().getName() + ": " +
        // result);
    }
}
