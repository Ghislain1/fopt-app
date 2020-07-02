package fopt.klausur.ws2013;

public class Zahlenschloss
{
    private int[] zahlenschloss;

    private int[] geheim =
    { 1, 2, 3, 4, 5 };

    public Zahlenschloss(int[] zahlenschloss)
    {
        this.zahlenschloss = zahlenschloss;
    }

    public synchronized void drehen(int radnummer, int zahl)
    {
        // Sicherstellen dass die Zahl zwischen 0 und 9 liegen soll.
        if (zahl < 0 || zahl > 9)
        {
            throw new IllegalArgumentException(" zahl in [0..9]");
        }

        try
        {
            Thread.sleep(10);
        }
        catch (InterruptedException e)
        {

            e.printStackTrace();
        }
        // Nachahmen einen Drehvorgang
        this.zahlenschloss[radnummer] = zahl;
    }

    private boolean istGeoeffnet()
    {
        boolean result = true;
        for (int i = 0; i < zahlenschloss.length; i++)
        {
            // Check Zahlenkombination !!
            if (this.zahlenschloss[i] != this.geheim[i])
            {
                result = false;
                // Raus aus der Schleife wenn etwas nicht passt
                break;
            }
        }
        return result;
    }

    public synchronized void warten()
    {
        boolean janein = this.istGeoeffnet();

        // Check Wartebediengung -->Falls der Schloss sich öffnet
        while (!janein)
        {
            try
            {
                this.wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public synchronized int lesen(int radnummer)
    {
        int result = this.zahlenschloss[radnummer];

        // Siehe Abschnitt 2.6.2
        this.notifyAll();
        return result;
    }

    // Kein synchronized weil der Zustandwert geheim wird nur gelesen in dieser
    // Klasse
    public int anzahlRädchen()
    {
        return this.geheim.length;
    }
}
