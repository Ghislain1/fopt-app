package fopt.klausur.lin.aufgabe2;

public class LogicalTime {

    private int count=0;

    public synchronized void tick(){
        count++;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " in tick() " + count);
    }

    public synchronized void waitTicks(int waitingTicks){
        int ticks = waitingTicks;
        while (ticks > 0){
            try {
                wait();
                ticks--;
                System.out.println(Thread.currentThread().getName() + "---" + ticks);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
