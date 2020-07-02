package fopt.klausur.ws2013;

import java.util.Random;

public class ZahlenschlossThread extends Thread
{
    private Zahlenschloss zahlenschloss;

    private Random random = new Random();

    public ZahlenschlossThread(Zahlenschloss zahlenschloss, String threadName)
    {
        this.zahlenschloss = zahlenschloss;
        this.setName(threadName);
        this.start();
        System.out.println(threadName + " is starting!!");

    }

    @Override
    public void run()
    {

        // int leng = this.zahlenschloss.anzahlRaedchen();

        // Zahlen zwischen 0 und 9 erzeugen
        int zahl = (int) (this.random.nextDouble() * 10);

        int radnummer = 0;
        while (true)
        {
            if (radnummer == 5)
            {
                radnummer = 0;
            }
            this.zahlenschloss.drehen(radnummer, zahl);
            radnummer++;
        }

    }
}
