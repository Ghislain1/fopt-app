package fopt.klausur.lin.aufgabe2;

public class WaitTickThread implements Runnable {
    private LogicalTime logicalTime;

    public WaitTickThread(LogicalTime logicalTime) {
        this.logicalTime = logicalTime;
    }

    @Override
    public void run() {
        while (true ){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logicalTime.waitTicks(50);
        }
    }
}
