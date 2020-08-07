# Aufgabe 1
* a) Welche Probleme gibt es bei Zuriff auf gemeinsam genutzte Objekt ?
    * Es entsteht ein Inkosistenzproblem (Ref: Abschnitt 2.2)
    * Ein Thread A möchte eine Multiplikation durchführen: Er ruft die Methode mutiply() mit Argument [1,2,3,4,5]. Aber vor der letzten Zahl (hier 4) wird Thread B eingeschaltet und er ruft mit Argument [0,0] auf. Das Ergebnis lautet hier Zero statt 120.
    * Hier ist ähnlich wie verlore Buchung.
     
* b) Problem lösen ohne Benutzung der Synchronisation
     * Man kann hier die Schlusswort volatile auf der Attribut wert verwendet
     * Für das Lesen und Schreiben von  primitive Datentypen außer Double und long scheint dass kein Synchronization notwendig ist: (Ref: Abschnitt 2.3.5)
     
# Aufgabe 2 : wait /notify (Abschnitt 2.5) /notifyAll (Abschnitt 2.6)

*  a) Die angebene Lösung funktioniert NICHT wie vorgesehen: Der Wert von ticks kann geändert werden, obwohl die tick()-Method nicht aufgerufen ist: Angenommen ein Thread t die Methode-waitTicks mit 5, dann wartet er in der While-Wait-schleife und ein andere Thread s ruft waitTickts mit 0, Nach Aufrufende der tick() wird alle Threads geweckt und muss  die methode waitTicks verlassen, was den Aufgabenstellung nicht eintspricht.

* b) Lösung

```java
Public class LogicalTime{
 private int ticks;
 private boolean canSetTicks;
 public synchronized void tick()
 {
   this.tick--;
   this.notify();
 }
 public synchronized void waitTicks( int waitingTicks)
 {
 // Fragen!!!
 if(!canSetTicks)
 {
   return;
 }
 this.tick = waitingTicks;
 while(tick>0)
 {
  try
  {
  this.wait();
  }
  catch( InterruptedException ex)
  {
  }
 }
 canSetTicks= true;
 }
}
```
* c) notifyAll()-Methode ist NICHT nötig: Durch Veänderung des Zustands kann nur ein Thread Ihre While-Wait-Schleife verlassen und wir haben nur eine Warte-bedinung.

# Aufgabe 3: Absch.1.1 Zusatz-Skript

* a) UML-Klassendiagramm - Assoziation 
   A ______> I : A und I in einem Rechteck und I mit Schlüsselwort <<Interface>> gekenntzeichen
 
 ```java
  interface I{
  }
  class A
  {
   I i;
   A (I i){
   this.i = i;
   }
  }
  ```
  * b) Benutzt-Beziehung (Abschn 1.1.2 Zusatzt-Skript)
   Die Benutzt-Beziehung kann verwendet werden, wenn ein Interface J als Argument einer Methode von Interface I verwenden ist oder als Ruckgabewert
   I -----> J : I, J in einem Rechtteck und mit Schlüsselwort <<Interface>> gekenntzeichen mit ausgeüllte Dreieckfür den Pfeil
   
   ```Java
   interface J{
   }
   interface I{
   public void doSome(J j);
   }
   ```
   
   * c) Die Vererbungsbeziehung zwischen 2 Interface (Abschnitt 1.1.3 Zusatzt-Skript)
   - Es gibt unterschied zwischen Vererbungsbeziehung und Implementierungszeiheung
   
   I _____> J : I, Der Pfeil ist **NICHT** ausgefüllt.
   
   ```java
   interface J{
   public void m();
   }
   interface I extends J{
   }
   ```
   
   