package fopt.klausur.ghis.ss2019;

public class MarttinLogicalTimeDemo
{
    public static void main(String[] args)
    {
        LogicalTime logicalTime = new LogicalTime();
        for (int i = 0; i < 3; i++)
        {
            System.out.println(i);
            Thread t1 = new Thread(() ->
            {
                logicalTime.waitTicks(3);
            });
            t1.setName("waitTicks()-Thread " + i);
            t1.start();
        }

        try
        {
            Thread.sleep(10000);
        }
        catch (Exception e)
        {
        }

        new Thread(() ->
        {
            for (int i = 0; i < 9; i++)
            {
                System.out.println("tick() " + i + " in main-Thread");
                logicalTime.tick();
                try
                {
                    Thread.sleep((int) Math.random());
                }
                catch (Exception e)
                {
                }
            }
        }).start();
    }

}
