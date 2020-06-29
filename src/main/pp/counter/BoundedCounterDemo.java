package pp.counter;

public class BoundedCounterDemo
{
    public static void main(String[] args) throws InterruptedException
    {
        int n = 1;

        BoundedCounter boundedCounter = new BoundedCounter(5, 100);

        UpThread upThread1 = new UpThread(boundedCounter, n);
        UpThread upThread2 = new UpThread(boundedCounter, n);
        UpThread upThread3 = new UpThread(boundedCounter, n);

        DownThread downThread1 = new DownThread(boundedCounter, n);
        DownThread downThread2 = new DownThread(boundedCounter, n);
        DownThread downThread3 = new DownThread(boundedCounter, n);

        // Start it!!
        upThread1.start();
        upThread2.start();
        upThread3.start();
        downThread1.start();
        downThread2.start();
        downThread3.start();

        upThread1.join();
        upThread2.join();
        upThread3.join();
        downThread1.join();
        downThread2.join();
        downThread3.join();

        System.out.println("BoundedCounter: " + boundedCounter.get());

    }

}
