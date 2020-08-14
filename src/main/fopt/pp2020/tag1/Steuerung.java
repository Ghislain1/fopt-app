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
        boolean schalter = true;
        while (true)
        {
            // Alternierende Steuerung
            schalter = !schalter;
            for (Ampel ampel : ampelFeld)
            {
                // Langsam umschalten
                this.sleepRandom();

                if (schalter)
                {
                    // ampel.schalteGruen();

                }
                else
                {
                    ampel.schalteRot();

                    if (ampel instanceof ItalienischeAmpel)
                    {
                        System.out.println("Waiting Cars(Italy): " + ampel.wartendeFahrzeuge());
                    }
                    else
                    {
                        System.out.println("Waiting Cars(Deutschland): " + ampel.wartendeFahrzeuge());
                    }
                }

            }

        }
    }

    // Just for a test
    private void sleepRandom()
    {
        // [0,5000] secondes
        int timeToSleep = (int) (new Random().nextDouble() * 5000);

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
