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
            logicalTime.waitTicks(waitTicks);
        }
    }
}
