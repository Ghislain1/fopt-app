package fopt.klausur.ghis.ss2019;

public class MultiplicationDemo
{

    public static void main(String[] args)
    {
        // GgO
        Multiplication multiplication = new Multiplication();

        Thread t1 = new MultiplicationThread1(multiplication, "OtherThread  -- ");
        Thread t2 = new MultiplicationThread2(multiplication, " THREAD_REsult_0 ---");
        try
        {
            t1.join();
            t2.join();
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }

    }

}
