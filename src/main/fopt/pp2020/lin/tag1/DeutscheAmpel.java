package fopt.pp2020.lin.tag1;

import java.util.LinkedList;
import java.util.List;

public class DeutscheAmpel implements Ampel {

    private boolean isRot;
    private List<Thread> wartende;

    public DeutscheAmpel() {
        isRot = true;
        wartende = new LinkedList<>();
    }

    @Override
    public synchronized void schaltRot() {
        isRot =true;
    }

    @Override
    public synchronized void schaltGruen() {
        isRot =false;
        notifyAll();
    }

    @Override
    public synchronized void passieren() {
        wartende.add(Thread.currentThread());
        while(isRot || wartende.get(0)!=Thread.currentThread()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // !isRot && wartende.get(0) == Thread.currentThread()
        wartende.remove(Thread.currentThread());
        // kann sein, dass ein zweites Auto die While bedingung überprüft und in wait bleibt
        // gleichzeitig wird das erst Auto in der warteList durch While schleife durchgehen. hier kann sein, dass noch
        // Thread noch am schlafen ist, die bedingung nach verlassen das erste Auto erfüllt wird.
        notifyAll();
    }

    @Override
    public synchronized Integer wartendeFahrzeuge() {
        return wartende.size();
    }
}
