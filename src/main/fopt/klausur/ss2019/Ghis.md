# Aufgabe 1
* a) Welche Probleme gibt es bei Zuriff auf gemeinsam genutzte Objekt ?
    * Es entsteht ein Inkonsistenzproblem (Ref: Abschnitt 2.2)
    * Die Ergebnisse sind hin und wieder fehlerbehaftet.
    * Ein Thread A mÃ¶chte eine Multiplikation durchfÃ¼hren: Er ruft die Methode mutiply() mit Argument [1,2,3,4,5]. Aber vor der letzten Zahl (hier 4) wird Thread B eingeschaltet und er ruft mit Argument [0,0] auf. Das Ergebnis lautet hier Zero statt 120.
    * Hier ist Ã¤hnlich wie verlorene Buchung.
     
* b) Problem lÃ¶sen ohne Benutzung der Synchronisation(Martin Loesung)
     *  Einfach result als local variable setzen
     *   local variable dient dazu dass  jede Thread unabhaengig  berechnet.
     
# Aufgabe 2 : wait /notify (Abschnitt 2.5) /notifyAll (Abschnitt 2.6)

*  a) Die angebene LÃ¶sung funktioniert NICHT wie vorgesehen: Der Wert von ticks kann geÃ¤ndert werden, obwohl die tick()-Method nicht aufgerufen ist: Angenommen ein Thread t die Methode-waitTicks mit 5, dann wartet er in der While-Wait-schleife und ein andere Thread s ruft waitTickts mit 0, Nach Aufrufende der tick() wird alle Threads geweckt und muss  die methode waitTicks verlassen, was den Aufgabenstellung nicht eintspricht.

* b) LogicalTime-Klasse

```java 

 
public class LogicalTime
{
    private int overallTicks;

    private LinkedList<Thread> runningThreadList;

    public LogicalTime()
    {

        this.overallTicks = 0;
        this.runningThreadList = new LinkedList<Thread>();
    }

    public synchronized void tick()
    {
        this.overallTicks++;
        this.notifyAll();
        System.out.println(this.overallTicks);

    }

    public synchronized boolean hasThreadInWaiting()
    {
        return !this.runningThreadList.isEmpty();
    }

    public synchronized void waitTicks(int waitingTicks)
    {
        // Append to list
        this.runningThreadList.add(Thread.currentThread());
        int ticks = this.overallTicks + waitingTicks;

        while (ticks > this.overallTicks )
        {
            try
            {
                System.out.println(Thread.currentThread().getName() + " *** WAITING  ====>  " + waitingTicks);
                this.wait();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        this.runningThreadList.remove(Thread.currentThread());
        System.out.println(Thread.currentThread().getName() + " ****   PASSING   *** ");

    }

}
 
```
* c) notifyAll()-Methode ist sehr nötig: Durch VeÃ¤nderung des Zustands kann mehrere Thread Ihre While-Wait-Schleife verlassen und wir haben sogar mehrere Warte-bedinungen.

# Aufgabe 3

* a) UML-Klassendiagramm - Assoziation 
   A ______> I : A und I in einem Rechteck und I mit SchlÃ¼sselwort <<Interface>> gekenntzeichen (Absch.1.1 Zusatz-Skript)
 
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
   I -----> J : I, J in einem Rechtteck und mit SchlÃ¼sselwort <<Interface>> gekenntzeichen mit ausgeÃ¼llte DreieckfÃ¼r den Pfeil
   
   ```Java
   interface J{
   }
   interface I{
   public void doSome(J j);
   }
   ```
   
   * c) Die Vererbungsbeziehung zwischen 2 Interface (Abschnitt 1.1.3 Zusatzt-Skript)
   
   Es gibt unterschied zwischen Vererbungsbeziehung und Implementierungszeiheung
   
   I _____> J : I, Der Pfeil ist **NICHT** ausgefÃ¼llt.
   
   ```java
   interface J{
   public void m();
   }
   interface I extends J{
   }
   ```
   
# Aufgabe 4 : On working
   **MVP-Prinzip**  steht fÃ¼r Model- View-Presenter, ist eine Design-Pattern fÃ¼r die Implementierung einer Anwendung, Die Grundidee ist die Trennung von GeschÃ¤ftlogik, Presentionslogik und den Anzeige-Komponenten
   * Model: Kapselt die  GeschÃ¤ftlogik und deren Daten
   * Presenter: VerknÃ¼ft Model und View, steuern den Ablauf der Anwendung e.g beim Ereignis
   * Views: Steht im Pinzip was der User sieht, aber auch die Container-Element, die fÃ¼r die Anordnung der Komponent dient.
   
# Aufgabe 5: 
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

    private void mouseReleased( )
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
## 7a)
Bemerkung:  In  dieser Aufgabe soll Folgendes noch betrachted werden:
* Erzeugung  eines **InputStreamReader** Objektes mit Java
* NewLine bei TCP-Segment  mit Java-Klasse erkennen

```java

public class TCPSocketServer
{

    public static void main(String[] args)
    {
        try (ServerSocket socketServer = new ServerSocket(7777))
        {
            while (true)
            {
                System.out.println("************** Server listening **********************");
                try (Socket socket = socketServer.accept())
                {
                    socket.getOutputStream();

                    // Aus Formelsammlung lesen
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    while (true)
                    {
                        // Jeweils Zeile lesen
                        String request = br.readLine();

                        // Check end of line --> request == "EOL" ||
                        if (request == null)
                        {
                            break;
                        }

                        // Append  Zeile
                        sb.append(request + "\n");

                    }
                    // Ausgabe auf  Console
                    System.out.print(sb.toString());
                }
                catch (Exception ewx)
                {
                    ewx.printStackTrace();
                }

            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }

    }
```

## 7b1)
```` Java
ClientX
send            
receive
send
receive
send
receive

ClientY
send            
send
send
receive
receive
receive
```
Die Bearbeitungszeit fuer ClientX und ClientY  ist gleich, denn bei sequenzieller Server Spielt die Reihenfolge keine Rolle bei Abarbeitung von Anfragen bezueglich der Zeit. Somit ist die Geschwindigkeit gleich.

## 7b2)
```` Java
ClientX
send            
receive
send
receive
send
receive
...

ClientY 
send            
send
send
receive
receive
receive
....
```
Bei parallen TCP Server ist ClientY schneller als ClientX, da jeden gesende Request sindsofort in einer Thread ausgelagernt und bearbetet, somit ist die Antwortszeit kurzer. Dadurch ist er schneller.

# Aufagbe 8: RMI -Stub und Skeleton

## Stub
```java
  public static void main(String[] args)
    {
        // rmi://<Rechnername>/<Objektname>
        String rechnername = "localhost";
        String objektname = "AppendName";
        String url = "rmi://" + rechnername + "/" + objektname;

        try
        {
             //TODO: Beschreiben Sie die Method lookup macht!!
             Append append = (Append) Naming.lookup(url);
            // code using counter Object...
        }
        catch (MalformedURLException | RemoteException |NotBoundException e)
        {

            e.printStackTrace();
        }     

    }
```

## Skeleton(Serverseitig)
```Java
    public static void main(String[] args)
    {

        // Registry
        try
        {
            // RemoteOject
            Append append = new AppendImpl();
            
            //TODO: Beschreiben Sie die Method rebind() macht!!
            Naming.rebind("AppendName", append);
        }
        catch (RemoteException |MalformedURLException e)
        {

            e.printStackTrace();
        }
        

    }
```
   
   
   
