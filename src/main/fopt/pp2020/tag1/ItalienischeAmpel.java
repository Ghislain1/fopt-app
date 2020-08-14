package fopt.pp2020.tag1;

public class ItalienischeAmpel implements Ampel
{
    // Gruen oder Rot
    private String ampel;

    private int numberOfWaitingCars;

    public ItalienischeAmpel()
    {
        this.ampel = Ampel.Gruen;
        this.numberOfWaitingCars = 0;
    }

    @Override
    public synchronized void schalteRot()
    {
        this.ampel = Ampel.Rot;

    }

    @Override
    public synchronized void schalteGruen()
    {
        this.ampel = Ampel.Gruen;

        // Denn mehrere Threads duerfen Ihre While-Wait-Schleife verlassen
        this.notify();
    }

    @Override
    public synchronized void passieren()
    {
        while (this.ampel.equals(Ampel.Rot))
        {
            try
            {

                this.numberOfWaitingCars++;
                this.wait();
                this.numberOfWaitingCars--;
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }

    // sync weil? -- schreibende
    @Override
    public synchronized int wartendeFahrzeuge()
    {
        return this.numberOfWaitingCars;
    }

}
