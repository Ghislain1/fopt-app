package fopt.klausur.lin.aufgabe2;

public class Demo {

    public static void main(String[] args) {
        LogicalTime logicalTime = new LogicalTime();
        new Thread(new TickThread(logicalTime)).start();

        new Thread(new WaitTickThread(logicalTime, 10)).start();

        new Thread(new WaitTickThread(logicalTime, 5)).start();
    }
}
