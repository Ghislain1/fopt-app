package fopt.pp2020.lin.tag1;

import java.util.ArrayList;

public class Keller {
    ArrayList elements;
    int length;

    public Keller() {
        this.elements = new ArrayList();
        this.length = 0;
    }

    /**
     * pop a element(type T) from the stack
     */
    public synchronized Object pop() {
        while (length==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object temp = elements.get(length-1);
        elements.remove(length-1);
        length--;
        notifyAll();
        return temp;
    }

    /**
     * push a element(type T) to the stack
     * @param element
     */
    public synchronized void push(Object element) {
        length++;
        elements.add(element);
        notifyAll();
    }
}
