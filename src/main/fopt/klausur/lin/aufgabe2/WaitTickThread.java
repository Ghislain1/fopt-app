package fopt.klausur.lin.aufgabe2;

public class WaitTickThread implements Runnable {
    private LogicalTime logicalTime;
    private int waitTicks;


    public WaitTickThread(LogicalTime logicalTime, int waitTicks) {
        this.logicalTime = logicalTime;
        this.waitTicks = waitTicks;
    }

    @Override
    public void run() {
        while (true ){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logicalTime.waitTicks(waitTicks);
        }
    }
}
