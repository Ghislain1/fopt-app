# Aufgabe 1
* a) Implementierung Siehe Klasse Zahlenschloss.java
* b) Wir haben nur eine Wartebediengung(: Die Zahlenkombination bei der sich das Schloss �ffnet.

	 - Wir k�nnen diese Frage an verschiedenen Threads stellen: Warum sollst du warten?
	 - �hnlich Bespiel wurde in Online Tutorium  behandeln!! 
	 
* c) Durch Ver�nderung des Zustands des Objektes Zahlenschloss k�nnen mehrere Threads Ihres While-Wait-Schleife verlassen. Folglich muss man NotifyAll() verwenden.
* d) s Aufgabe a
* e) Nach Betrachtung des folgenden Programmcodes eines Threads

```java
for(int i=0; i<zk.anzahlRaedschen(); i++)
{
    System.out.println(" " + zk.lesen(i));
}
System.out.println();
```
Wenn ein Thread z.b lesende Thread auf zk zugreigt, bevor alle R�dschen durchlaufen sind,denn die schreibenden Threads blockiert sind.
Die For-Schleife iteriert �ber die komplexe Arrays und liesst jedes R�dschen von der Array
Thread 1: drehen(0, 9) // setzt erste R�dschen auf 9
Thread 2: lesen(): gibt die felder aus   90000 , hier wurde kein 4 nullen gesetzt
* f) Programmcode �ndern

```java
   private boolean [] korrektRaedschen = new  boolean[5];
   public synchronized void drehen(int radnummer, int zahl)
   {
   // ...
    //..
    korrektRaedschen[radnummber]= true;
   }
   for(int i=0; i<zk.anzahlRaedschen(); i++)
   {
      if(korrektRaedschen[i])
      {
      System.out.println(" " + zk.lesen(i));
      }
    
   }     
```

* g) TODO??
# Aufgabe 2
# Aufgabe 3
# Aufgabe 4 (RMI)
a) Es fehlt die Deklaration der Kontruktor, zusatz�lich soll die Konstruktor der  abgeleiteten Klasse aufgerufen werden  bei Verwenden der Schl�sswort super(), Dar�berhinaus soll  diese Kontruktor  ein Exception geworfen werden. (siehe  Buch Abschnitt 6.2.1)
