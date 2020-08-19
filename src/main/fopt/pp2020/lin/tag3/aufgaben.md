
Aufgabe: Parallele UDP-Server

In den Lehrmaterialien wird die Parallelisierung für Client-Server-Anwendungen mit Sockets nur für den TCP-Server gezeigt. Entwickeln Sie nun für ein Sleep-Beispiel einen statisch parallelen, dynamisch parallelen und gemischt statisch-dynamisch parallelen UDP-Server und demonstrieren Sie den Effekt der Parallelität anhand eines passenden Clients! Überlegen Sie zuerst, ob die Klasse UDPSocket thread-safe (also für die parallele Nutzung durch mehrere Threads geeignet) ist und entsprechend, ob bzw. wie Sie die Klasse UDPSocket für diese Aufgabe nutzen können!



Aufgabe: TCP-Batch-Modus

a) Der in den Lehrmaterialien besprochene Client für das TCP-Zählerbeispiel arbeitet nach dem Muster "senden – empfangen – senden – empfangen – …". Programmieren Sie nun einen Client für das TCP-Zählerbeispiel, der nach dem Muster "senden – senden – … – empfangen – empfangen – …." arbeitet (Batch-Modus)! Das heißt: In Ihrem Programm soll in einer Schleife n Mal das Kommando "increment" gesendet und in einer weiteren Schleife n Mal die Antworten empfangen werden.

b) Welchen Effekt hat diese Änderung des Client-Verhaltens auf die Laufzeit? Was vermuten Sie? In welchem Fall sollte sich der Effekt besonders deutlich zeigen?

c) Können Sie deutliche Unterschiede für die Laufzeiten zwischen der alten und der neuen Variante messen? Hinweis: Versuchen Sie beide Varianten einmal für den Fall, dass Sie Client und Server auf demselben Rechner und einmal für den Fall, dass Sie sie auf unterschiedlichen Rechnern ausführen!

d) Was passiert, wenn Sie Anzahl der "increment"-Operationen für den Batch-Modus-Client immer weiter erhöhen? Erklären Sie den Effekt!

e) Wie können Sie die Höchstgrenze, bei der Ihr Programm noch funktioniert, nach oben schrauben? Hinweis: Schauen Sie sich die Methoden setSendBufferSize und setReceiveBufferSize der Klasse Socket an!

f) Wie können Sie das Problem komplett lösen? Hinweis: Denken Sie an Parallelität!



Aufgabe: Übertragung serialisierter Objekte über UDP und TCP

Im Lehrbuch gab es die Klassen UDPSocket und TCPSocket zum Übertragen von Strings mit UDP bzw. TCP. In einer Übungsaufgabe wurde gezeigt, wie ints, doubles und booleans mit TCP übertragen werden können. Schreiben Sie nun die Klassen UDPSocketAdvanced und TCPSocketAdvanced zum Senden und Empfangen von Strings, ints, doubles und booleans sowie serialisierter Java-Objekte über UDP bzw. TCP und probieren Sie Ihre Klassen anhand je einer kleinen Client-Server-Anwendung aus!



Aufgabe: RMI-Anwendung zur Multiplikation von Zahlen

Schreiben Sie eine Client-Server-Anwendung mit RMI, bei der ein Server eine Methode zum Multiplizieren zweier int-Zahlen anbietet! Schreiben Sie einen Client, der das kleine Einmaleins ausgibt, wobei er zur Berech­nung des Ergebnisses den Server in Anspruch nimmt!




Aufgabe: RMI-Objekt mit mehr als einer RMI-Schnittstelle

Definieren Sie zwei (einfache) RMI-Schnittstellen und implementieren Sie diese in einer einzigen RMI-Klasse! Demonstrieren Sie, dass der Client-Stub beide Schnittstellen implementiert, indem Sie im Client die Methode Naming.lookup ein einziges Mal aufrufen, das dadurch erhaltene Objekt aber nacheinander auf beide Schnittstellen casten und jeweils die dazugehörigen Methodenufrufen!




Aufgabe: Unterschiedliche Stubs für dasselbe und für unterschiedliche RMI-Objekte

Erzeugen Sie in Ihrem RMI-Server zwei RMI-Objekte und melden Sie diese unter unterschiedlichem Namen bei der RMI-Registry an!

a) Verwenden Sie die static-Methode Naming.list, um die Namen aller in einer RMI-Registry aktuell angemeldeten RMI-Objekte abzufragen!

b) Beschaffen Sie sich mit zwei Naming.lookup-Aufrufen zwei Stubs auf dasselbe RMI-Objekt! Ver­gleichen Sie die Stubs mit == und equals!

c) Beschaffen Sie sich mit zwei Naming.lookup-Aufrufen zwei Stubs auf die beiden unterschied­lichen RMI-Objekte! Vergleichen Sie auch diese Stubs mit == und equals!

d) Was folgern Sie aus den Beobachtungen der Teilaufgaben b und c? Wie ist equals für Stubs wohl definiert?




Aufgabe: Demonstration des Unterschieds zwischen Call-By-Value und Call-By-Reference

Demonstrieren Sie den Unterschied zwischen Call-By-Value und Call-By-Reference anhand des folgenden Beispiels:

a) Schreiben Sie eine Klasse Data mit einem Attribut des Typs int sowie einer Setter- und Getter-Methode! Die Setter- und Getter-Methode soll je eine Ausgabe auf der Console erzeugen.

b) Schreiben Sie eine RMI-Klasse Demo mit einer Methode increment, die einen Parameter des Typs Data entgegennimmt, über die Getter-Methode den aktuellen Wert von Data ausliest und über die Setter-Methode den Wert um 1 erhöht! Natürlich brauchen Sie dafür auch eine entsprechende RMI-Schnittstelle.

c) Schreiben Sie einen RMI-Server und RMI-Client dazu! Geben Sie auf dem Client den Wert des Data-Objekts vor und nach dem RMI-Aufruf von increment auf der Console aus!

d) Bringen Sie Ihre Anwendung einmal mit einem Call-By-Value und einmal mit einem Call-By-Reference zum Laufen! Welche Unterschiede sehen Sie bei den Ausgaben des Clients und der Setter- und Getter-Methode von Data?
