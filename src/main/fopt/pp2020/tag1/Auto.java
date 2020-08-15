package fopt.pp2020.tag1;

public class Auto extends Thread
{
    private Ampel[] ampelFeld;

    public Auto(Ampel[] ampelFeld)
    {
        if (ampelFeld == null)
        {
            throw new IllegalArgumentException("feld ampel is null");
        }
        this.ampelFeld = ampelFeld;

        // Start theThread directly
        this.start();
    }

    @Override
    public void run()
    {
        // Jades Auto versucht der Ampel nur 1 mal
        for (Ampel ampel : this.ampelFeld)
        {
            ampel.passieren();

        }

    }

}
