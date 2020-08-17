package fopt.pp2020.tag1;

public class ItalienischeAmpel implements Ampel
{
    // Gruen oder Rot
    private String ampel;

    private boolean istRot;

    private boolean istGruen;

    private int wartendeFahrzeuge;

    public ItalienischeAmpel()
    {
        this.istGruen = !this.istRot;
        this.wartendeFahrzeuge = 0;
    }

    @Override
    public synchronized void schalteRot()
    {
        this.istGruen = false;
        this.istRot = true;

    }

    @Override
    public synchronized void schalteGruen()
    {
        this.istGruen = true;
        this.istRot = false;

        // Denn mehrere Threads duerfen Ihre While-Wait-Schleife verlassen
        this.notifyAll();
    }

    @Override
    public synchronized void passieren()
    {
        // TODO@GHZe Niemals etwas in the WHILE-WAIT-Schleife schreiben
        // Siehe Schablone in Buch
        this.wartendeFahrzeuge++;
        while (!this.istGruen && this.istRot)
        {
            try
            {

                println(Thread.currentThread().getName() + " Italy-WAITING " + this.wartendeFahrzeuge);
                this.wait();

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        println(Thread.currentThread().getName() + " Italy ROLLING ");

        this.wartendeFahrzeuge--;

    }

    private static void println(String msg)
    {
        System.out.println(msg);
    }

    // sync weil? --
    @Override
    public synchronized int wartendeFahrzeuge()
    {
        return this.wartendeFahrzeuge;
    }

}
