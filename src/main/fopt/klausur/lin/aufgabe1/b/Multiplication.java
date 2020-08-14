package fopt.klausur.lin.aufgabe1.b;

import java.util.concurrent.atomic.AtomicInteger;

public class Multiplication {
    private AtomicInteger result;

    public int multiply(int[] args){
        int temp = 1;
        result = new AtomicInteger(1);
        for(int arg: args){
            temp *= arg;
            result.set(temp);
            System.out.println(Thread.currentThread().getName() + "===" + result.get());
        }
        return result.get();
    }
}
