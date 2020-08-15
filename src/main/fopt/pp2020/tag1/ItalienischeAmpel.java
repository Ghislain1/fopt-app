package fopt.pp2020.tag1;

public class ItalienischeAmpel implements Ampel
{
    // Gruen oder Rot
    private String ampel;

    private int numberOfWaitingCars;

    public ItalienischeAmpel()
    {
        this.ampel = Ampel.Rot;
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
        // TODO@GHZe Niemals etwas in the WHILE-WAIT-Schleife schreiben
        this.numberOfWaitingCars++;
        while (this.ampel.equals(Ampel.Rot))
        {
            try
            {
                System.out.println(Thread.currentThread().getName() + " Italy WAITING " + this.numberOfWaitingCars);
                this.wait();

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " Italy ROLLING ");

        this.numberOfWaitingCars = 0;

    }

    // sync weil? --
    @Override
    public synchronized int wartendeFahrzeuge()
    {
        return this.numberOfWaitingCars;
    }

}
