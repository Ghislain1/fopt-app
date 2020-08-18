package fopt.pp2020.tag1;

import java.util.LinkedList;

public class DeutscheAmpel implements Ampel
{

    private LinkedList<Thread> threadLinkedList;

    private boolean istRot;

    public DeutscheAmpel()
    {

        this.threadLinkedList = new LinkedList<>();
        this.istRot = true;

    }

    // sync weil Aenderung des Zustands durch unterchiedliche Threads
    @Override
    public synchronized void schalteRot()
    {

        this.istRot = true;

    }

    // sync--> Weil Aenderung des Zustand durch unterchiedliche Threads
    @Override
    public synchronized void schalteGruen()
    {
        this.istRot = false;
        // Denn mehrere Threads koennen While-Wait-Schleife/ verlassen
        this.notifyAll();

    }

    @Override
    public synchronized void passieren()
    {

        Thread currentThread = Thread.currentThread();
        // Append to the list
        this.threadLinkedList.add(currentThread);

        // Frage: Wann soll ein Auto warten?
        // 1. wenn Ampel ist rot oder
        // 2. Wartenummer und Anfahrende Nummer sind nicht identisch

        while (this.istRot || this.threadLinkedList.get(0) != currentThread)
        {
            try
            {
                System.out.println(Thread.currentThread().getName() + " DEUTSCH-WAITING  " + this.wartendeFahrzeuge());
                this.wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " DEUTSCH-ROOLING  ");

        this.threadLinkedList.remove(currentThread);

        // Benachrichtigen andere Autos
        this.notifyAll();

    }

    // sync weil? -- schreibende
    @Override
    public synchronized int wartendeFahrzeuge()
    {
        return this.threadLinkedList.size();
    }

}
