package fopt.klausur.lin.aufgabe1b;

public class ThreadsUnsafeTest {
    public static void main(String[] args) {
        Multiplication multiplication = new Multiplication();
        int[] intArr = new int[]{1,2,3,4};

        new Thread(()-> {
            multiplication.multiply(intArr);
        }).start();

        new Thread(()-> {
            multiplication.multiply(intArr);
        }).start();
    }
}
