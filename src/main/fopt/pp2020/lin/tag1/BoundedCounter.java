package fopt.pp2020.lin.tag1;

public class BoundedCounter {

    private int counter;
    private int min, max;

    public BoundedCounter(int min, int max) {
        if(max<=min){
            throw new IllegalArgumentException("Wrong paramters Angaben");
        }
        this.min = min;
        this.max = max;
        this.counter = min;
    }

    public synchronized void down(){
        while (counter<=min){
            try {
                System.out.println(Thread.currentThread().getName() + " WAITING... in down()");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter--;
        notifyAll();
    }

    public synchronized void up(){
        while (counter>=max){
            try {
                System.out.println(Thread.currentThread().getName() + " WAITING... in up()");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter++;
        notifyAll();
    }

    public synchronized int getCounter() {
        return counter;
    }
}

