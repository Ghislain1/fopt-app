package fopt.klausur.lin.aufgabe2a;

public class LogicalTime {

    public synchronized void tick(){
        notifyAll();
    }

    public synchronized void waitTicks(int waitingTicks){
        int ticks = waitingTicks;
        while (ticks > 0){
            try {
                wait();
                ticks--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
