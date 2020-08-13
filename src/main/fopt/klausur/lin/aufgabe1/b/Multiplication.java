package fopt.klausur.lin.aufgabe1.b;

public class Multiplication {
    private volatile Integer result;
    public int multiply(int[] args){
        result = 1;
        for(int arg: args){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result *= arg;
            System.out.println(Thread.currentThread().getName() + "--" + result);
        }
        return result;
    }
}
