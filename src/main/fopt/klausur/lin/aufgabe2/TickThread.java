package fopt.klausur.lin.aufgabe2;

public class TickThread implements Runnable {
    private LogicalTime logicalTime;

    public TickThread(LogicalTime logicalTime) {
        this.logicalTime = logicalTime;
    }

    @Override
    public void run() {
        int count = 0;
        while (true ){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logicalTime.tick();
            count++;
            System.out.println(Thread.currentThread().getName() + " tick " +  count);
        }
    }
}
