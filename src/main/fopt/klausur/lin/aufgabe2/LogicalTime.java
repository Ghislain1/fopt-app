package fopt.klausur.lin.aufgabe2;

public class LogicalTime {

    public synchronized void tick(){
        System.out.println(Thread.currentThread().getName() + " in tick()");
        notifyAll();

    }

    public synchronized void waitTicks(int waitingTicks){
        int ticks = waitingTicks;
        while (ticks > 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticks--;
            System.out.println(Thread.currentThread().getName() + "---" + ticks);
        }
    }
}
