a. die Lösung funktioniert. ??????


b. Lösung
``` java

public class LogicalTime {

    public synchronized void tick(){
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
            tickes--;
        }
    }
}
```

c. notifyAll ist besser als notify.
die Bedingung für notifyAll --> 1. es gibt mehrere Wartebedingungen (verschiedene Thread mit unterschiedlich waitTickValue)
                            --> 2. kann durch die Änderung des Werts können mehr als ein Thread ihre while-wait-schleife verlassen.
