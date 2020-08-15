package fopt.klausur.lin.aufgabe2;

public class WaitTickThread implements Runnable {
    private LogicalTime logicalTime;

    public WaitTickThread(LogicalTime logicalTime) {
        this.logicalTime = logicalTime;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < 10 ){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logicalTime.waitTicks(10);
            count++;
        }
    }
}
