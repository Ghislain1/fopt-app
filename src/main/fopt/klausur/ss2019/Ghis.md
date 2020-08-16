# Aufgabe 1
* a) Welche Probleme gibt es bei Zuriff auf gemeinsam genutzte Objekt ?
    * Es entsteht ein Inkonsistenzproblem (Ref: Abschnitt 2.2)
    * Die Ergebnisse sind hin und wieder fehlerbehaftet.
    * Ein Thread A möchte eine Multiplikation durchführen: Er ruft die Methode mutiply() mit Argument [1,2,3,4,5]. Aber vor der letzten Zahl (hier 4) wird Thread B eingeschaltet und er ruft mit Argument [0,0] auf. Das Ergebnis lautet hier Zero statt 120.
    * Hier ist ähnlich wie verlorene Buchung.
     
* b) Problem lösen ohne Benutzung der Synchronisation
     * Man kann hier die Schlusswort volatile auf der Attribut wert verwendet
     * Für das Lesen und Schreiben von  primitive Datentypen außer Double und long scheint dass kein Synchronization notwendig ist: (Ref: Abschnitt 2.3.5)
     
# Aufgabe 2 : wait /notify (Abschnitt 2.5) /notifyAll (Abschnitt 2.6)

*  a) Die angebene Lösung funktioniert NICHT wie vorgesehen: Der Wert von ticks kann geändert werden, obwohl die tick()-Method nicht aufgerufen ist: Angenommen ein Thread t die Methode-waitTicks mit 5, dann wartet er in der While-Wait-schleife und ein andere Thread s ruft waitTickts mit 0, Nach Aufrufende der tick() wird alle Threads geweckt und muss  die methode waitTicks verlassen, was den Aufgabenstellung nicht eintspricht.

* b) Lösung

```java
package fopt.klausur.ghis.ss2019;

public class LogicalTime
{
    public static int MAX_NUMBER_OF_TICKS_LONG = 10;

    public static int MAX_NUMBER_OF_TICKS_SMALL = 5;

    private int nextWaitingNumber;

    private int nextPassingNumber;

    private int ticks;

    public LogicalTime()
    {
        this.nextWaitingNumber = 0;
        this.nextPassingNumber = 0;
        this.ticks = 1; // NOT Zero , because the first enter thread should wait
    }

    public synchronized void tick()
    {

        if (this.ticks == 0)
        {

            this.notifyAll();

        }
        else
        {
            this.ticks--;
        }

    }

    public synchronized void waitTicks(int waitingTicks)
    {
        // Nummber ziehen
        int myNumber = this.nextWaitingNumber;

        // Wartenummer bereitstellen
        this.nextWaitingNumber++;

        while (this.ticks > 0 || myNumber != this.nextPassingNumber)
        {
            try
            {
                
                this.wait();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        this.ticks = waitingTicks;
        this.nextPassingNumber++;
        this.notifyAll();
  
    }

}
```
* c) notifyAll()-Methode ist sehr n�tig: Durch Veänderung des Zustands kann mehrere Thread Ihre While-Wait-Schleife verlassen und wir haben sogar mehrere Warte-bedinungen.

# Aufgabe 3

* a) UML-Klassendiagramm - Assoziation 
   A ______> I : A und I in einem Rechteck und I mit Schlüsselwort <<Interface>> gekenntzeichen (Absch.1.1 Zusatz-Skript)
 
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
  * b) Benutzt-Beziehung  
   Die Benutzt-Beziehung kann verwendet werden, wenn ein Interface J als Argument einer Methode von Interface I verwenden ist oder als Ruckgabewert (Absch.1.1 Zusatz-Skript)
   I -----> J : I, J in einem Rechtteck und mit Schlüsselwort <<Interface>> gekenntzeichen mit ausgeüllte Dreieckfür den Pfeil
   
   ```Java
   interface J{
   }
   interface I{
   public void doSome(J j);
   }
   ```
   
   * c) Die Vererbungsbeziehung zwischen 2 Interface (Abschnitt 1.1.3 Zusatzt-Skript)
   
   Es gibt unterschied zwischen Vererbungsbeziehung und Implementierungszeiheung
   
   I _____> J : I, Der Pfeil ist **NICHT** ausgefüllt.
   
   ```java
   interface J{
   public void m();
   }
   interface I extends J{
   }
   ```
   
# Aufgabe 4 : On working
   **MVP-Prinzip**  steht für Model- View-Presenter, ist eine Design-Pattern für die Implementierung einer Anwendung, Die Grundidee ist die Trennung von Geschäftlogik, Presentionslogik und den Anzeige-Komponenten
   * Model: Kapselt die  Geschäftlogik und deren Daten
   * Presenter: Verknüft Model und View, steuern den Ablauf der Anwendung e.g beim Ereignis
   * Views: Steht im Pinzip was der User sieht, aber auch die Container-Element, die für die Anordnung der Komponent dient.
   
# Aufgabe 5: On working
**CheckBox** - hat ein Property isSelected vom Typ boolean

```java
CheckBox checkBox = new CheckBox("I love FOPT");
   checkBox.selectedProperty().addListener((a, b, c) ->
        {
            if (a.getValue())
            {
                System.out.println("hurra");
            }
            else
            {
                System.out.println("schade");
            }

        });
        wobei:
        * a: vom Typ ObservableValue<? extends Boolean> 
        * b: referenzieren  den neuen Wert der property selected of type Boolean
        * c: referenzieren  den alten Wert der property selected of CheckBox
        ** checkoBox.isSelected Nict mehr vorhand**
```

# Aufgabe 6: - Grafikprogrammierung
```Java
 private void mouseDragged(double x, double y)
    {
        this.c.setCenterX(x);
        this.c.setCenterY(y);
    }

    private void mouseReleased(double x, double y)
    {
        this.c.setFill(Color.RED);
    }

    private void mousePressed(double x, double y)
    {
        this.c = new Circle(x, y, RADIUS);
        this.c.setFill(null); // NICHT ausfuellen--> Wichtig sonst Dunkel
        this.c.setStroke(Color.RED); // Farbe der Begrenzunglinie
        this.graphicsPane.getChildren().add(this.c);
    }
```

# Aufagbe 7: TCP
* Abschnitt 5.5 soll noch wiederholen werden
* Abschnitt 5.5 Kommunikation ueber TCP mit Java-Sockets

# Aufagbe 8: RMI - noch mal lesen
   
   
   
   
