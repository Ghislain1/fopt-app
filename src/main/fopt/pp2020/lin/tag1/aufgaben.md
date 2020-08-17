
Aufgabe: BoundedCounter

In dieser Aufgabe sollen Sie in durch Implementierung der Klasse BoundedCounter (auf deutsch: begrenzter Zähler) das Umgehen mit synchronized, wait, notify bzw. notifyAll weiter üben. Die Klasse BoundedCounter soll einen int-Zähler repräsentieren, der durch die Methode up um eins erhöht und durch die Methode down um eins erniedrigt werden kann. Im einzigen Konstruktor dieser Klasse soll ein Minimum- und ein Maximumwert für den int-Zähler angegeben werden können (d.h. der Zähler soll nie kleiner als das im Konstruktor angegebene Minimum und nie größer als das im Konstruktor angegebene Maximum werden). Versucht ein Thread die Methode down auszuführen, wenn der Zähler seinen Minimumwert besitzt, so soll er solange verzögert werden, bis das Erniedrigen des Zählers möglich ist, ohne dass der Minimalwert unterschritten wird (d.h. bis ein anderer Thread den Zähler entsprechend erhöht hat). Das Entsprechende gilt für das Erhöhen des Zählers in der Methode up und den Maximumwert. Zusätzlich soll es eine Funktion get geben, die den aktuellen Zählerwert zurückliefert.

a) Geben Sie eine Implementierung der Klasse BoundedCounter an! Der Anfangswert des Zählers soll der angegebene Minimalwert sein.

b) Schreiben Sie ein Programm, in dem ein Objekt der Klasse BoundedCounter von mehreren Threads gleichzeitig benutzt wird!



Aufgabe: SynchStack

Gegeben sei die wohlbekannte Datenstruktur eines Kellers (Stack) mit den Methoden push und pop. Im Folgenden sollen diese Methoden so geändert werden, dass die Methode push (Ablegen eines Elements im Keller) wie bisher auch ohne besondere Einschränkungen ausgeführt werden kann. Beim Aufruf der Methode pop (Entfernen des obersten Elements des Kellers und Rückgabe des entfernten Elements als Rückgabewert) soll allerdings bei leerem Keller so lange gewartet werden, bis ein Element zurückgegeben werden kann. Das heißt: Damit kann es nicht mehr vorkommen, dass die Methode pop kein Element zurückgibt, da der Keller leer war. Die Elemente, die im Keller abgelegt werden, sollen Objekte jeder beliebigen Klasse sein können. Deshalb soll als Datentyp für die abzulegenden Elemente die Klasse Object verwendet werden. Der Keller soll durch ein Feld (in diesem Fall ein Object-Feld) oder eine ArrayList realisiert werden.

Implementieren Sie die Klasse SynchStack mit Hilfe der Java-Synchronisations­konzepte syn­chronized, wait, notify bzw. notifyAll und schreiben Sie ein Hauptprogramm dazu, mit dem Sie Ihren synchronisierenden Stack ausprobieren können!



Aufgabe: Ampel

In dieser Aufgabe sollen Sie die Funktionsweise einer Ampel und deren Nutzung mit synchronized, wait und notify bzw. notifyAll nachahmen.

a) Schreiben Sie zunächst eine Schnittstelle Ampel mit zwei parameterlosen Void-Methoden schalteRot und schalteGruen zum Setzen der Ampel auf rot bzw. grün (die Zwischenphase gelb spielt keine Rolle – Sie können von diesem Zustand abstrahieren)! Eine dritte parameterlose Void-Methode mit dem Namen passieren soll das Vorbeifahren eines Fahrzeugs an dieser Ampel nachbilden. Mit einer vierten parameterlosen Int-Methode namens wartendeFahrzeuge sollen Sie abfragen können, wie viele Autos momentan an der Ampel stehen.

b) Geben Sie jetzt eine erste Implementierung der Schnittstelle Ampel namens ItalienischeAmpel an! Die Methode passieren soll dabei folgendermaßen funktionieren: Ist die Ampel beim Aufruf der Methode rot, so wird der aufrufende Thread angehalten, und zwar so lange, bis die Ampel grün wird. Ist die Ampel dagegen grün, so kann der Thread sofort aus der Methode zurückkehren, ohne den Zustand der Ampel zu verändern. Sie müssen zunächst nicht wie in der Realität nachahmen, dass beim Grünwerden der Ampel die Autos der Reihe nach losfahren. Stellen Sie sich der Einfachheit halber eine Ampel vor, bei der sich alle wartenden Autos nebeneinander aufstellen (wie in Italien)! Sobald die Ampel grün wird, hat jedes Auto unabhängig von allen anderen Autos die Möglichkeit loszufahren. Verwenden Sie wait, notify und notifyAll nur an den unbedingt nötigen Stellen!

c) Geben Sie nun eine zweite Implementierung der Schnittstelle Ampel mit dem Namen DeutscheAmpel an! Bei dieser Implementierung sollen sich die Autos nicht mehr nebeneinander aufstellen, sondern hintereinander! Das heißt, ein Auto kann erst fahren, wenn die Ampel grün ist und alle vor ihm stehenden Autos an der Ampel vorbeigefahren sind.

d) Schreiben Sie nun eine Klasse Auto (abgeleitet aus Thread)! Im Konstruktor wird eine Referenz auf ein Feld von Ampeln übergeben, wobei diese Referenz in einem entsprechenden Attribut der Klasse Auto gespeichert wird. In der run-Methode werden alle Ampeln des Feldes passiert, und zwar in einer Endlosschleife (d.h. nach dem Passieren der letzten Ampel des Feldes wird wieder die erste Ampel im Feld passiert). Verwenden Sie als Typ die Schnittstelle Ampel, so dass nicht festgelegt wird, um welche Art von Ampel es sich wirklich handelt!

e) Schreiben Sie eine weitere Thread-Klasse zur Steuerung der Ampeln. Verwenden Sie auch hier wieder als Typ die Schnittstelle Ampel, so dass nicht festgelegt wird, um welche Art von Ampel es sich wirklich handelt!

f) Probieren Sie Ihre Threads mit italienischen und deutschen Ampeln aus!



Aufgabe: EventSet

In dieser Aufgabe geht es um die Klasse EventSet, deren Attribut ein boolesches Feld ist, dessen Länge im Konstruktor angegeben wird. Jedes Feldelement kann einzeln durch die Methode set auf true oder false gesetzt werden. Ferner gibt es die Methoden waitAND und waitOR, mit denen ein Thread darauf warten kann, bis alle Feldelemente true sind bzw. bis mindestens ein Feldelement true ist. Die Methoden waitAND und waitOR verändern das Feld nicht. 

Realisieren Sie die Klasse EventSet mit Hilfe der Java-Synchronisations­konzepte synchronized, wait, notify bzw. notifyAll und schreiben Sie ein Programm dazu, in dem Sie ein Objekt der Klasse EventSet von mehreren Threads gleichzeitig benutzen, um die Klasse EventSet auszuprobieren!



Aufgabe: notify/notifyAll

Betrachten Sie die Beispiele BoundedCounter, SynchStack, Ampel und EventSet! In welchen der Beispiele kann notify, in welchen Beispielen muss notifyAll verwendet werden? Geben Sie für jedes Beispiel an, ob keine, eine oder beide Bedingungen, die notifyAll notwendig machen, erfüllt sind oder nicht!



Aufgabe: Methodenschablonen

Betrachten Sie die Beispiele BoundedCounter, SynchStack, Ampel und EventSet! Können Sie alle sechs Schablonen für Synchronized-Methoden (zwei lesende und vier schreibende Methoden) finden?
