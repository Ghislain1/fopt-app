package fopt.buch.abschn263;

import java.util.Random;

public class Auto extends Thread
{
    private ParkingGarageFair parkingGarageFair;

    public Auto(ParkingGarageFair parkingGarageFair, String autoName)
    {
        this.parkingGarageFair = parkingGarageFair;
        this.setName(autoName);

        // start it !!
        this.start();

    }

    @Override
    public void run()
    {
        // Einfahrrende und Ausfahrende Autonachbilden
        int einaus = 0;
        while (einaus < 1)
        {
            einaus++;
            this.parkingGarageFair.enter();
            System.out.println(Thread.currentThread().getName() + " ENTER");
            // Fake shoppin
            this.sleepRandom();

            this.parkingGarageFair.leave();
            System.out.println(Thread.currentThread().getName() + " LEAVE");

        }

    }

    private void sleepRandom()
    {
        int timeToSleep = 5000 + (int) (new Random().nextDouble() * 5000);

        try
        {
            Thread.sleep(timeToSleep);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
