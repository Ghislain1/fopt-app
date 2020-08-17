package fopt.pp2020.lin.tag1;

import java.util.ArrayList;
import java.util.List;

public class EventSet {
    private List<Boolean> myList;

    public EventSet(int size) {
        this.myList = new ArrayList<>(size);
    }

    public synchronized void set(int index, Boolean isTrue){
        myList.set(index, isTrue);
        notifyAll();
    }

    private boolean sindAllElementsTrue(){
        boolean isTrue = true;
        synchronized (myList){
            for (Boolean b:myList) {
                    if(!b){
                        isTrue = false;
                        return isTrue;
                    }
                }
            }
        return  isTrue;
    }

    private boolean isEinElementTrue(){
        boolean isTrue = false;
        synchronized (myList){
            if(myList.contains(true)){
                isTrue = true;
            }
        }
        return  isTrue;
    }

    public void waitAND(){
        while(!sindAllElementsTrue()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
    }

    public void waitOr(){
        while(!isEinElementTrue()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
    }

}
