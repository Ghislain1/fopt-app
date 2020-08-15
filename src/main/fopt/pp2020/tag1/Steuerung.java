package fopt.pp2020.tag1;

import java.util.Random;

public class Steuerung extends Thread
{
    private Ampel[] ampelFeld;

    public Steuerung(Ampel[] ampelFeld)
    {
        this.ampelFeld = ampelFeld;
        this.setName("Steuerung");
        this.start();
    }

    @Override
    public void run()
    {
        this.sleepRandom();
        boolean schalter = true;
        while (true)
        {
            // Alternierende Steuerung
            schalter = !schalter;
            for (Ampel ampel : ampelFeld)
            {
                // Langsam umschalten
                // this.sleepRandom();
                try
                {
                    // Zwei SekundenTakt umschalten
                    Thread.sleep(2000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                if (schalter)
                {
                    ampel.schalteGruen();

                }
                else
                {
                    ampel.schalteRot();

                }

            }

        }
    }

    // Just for a test
    private void sleepRandom()
    {
        // [0,5000] secondes
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
