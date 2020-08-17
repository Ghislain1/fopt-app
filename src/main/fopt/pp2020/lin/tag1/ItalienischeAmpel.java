package fopt.pp2020.lin.tag1;

public class ItalienischeAmpel implements Ampel {
    private boolean isRot;
    private boolean isGruen;
    private Integer wartendeFahrzeuge;

    @Override
    public synchronized void schaltRot() {
        isRot = true;
        isGruen = false;
    }

    @Override
    public synchronized void schaltGruen() {
        isGruen=true;
        isRot = false;
        notifyAll();
    }

    @Override
    public synchronized void passieren() {
        wartendeFahrzeuge++;
        while(isRot && !isGruen){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        wartendeFahrzeuge--;
    }

    @Override
    public Integer wartendeFahrzeuge() {
        return wartendeFahrzeuge;
    }
}
