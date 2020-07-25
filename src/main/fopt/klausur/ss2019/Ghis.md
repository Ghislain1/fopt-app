# Aufgabe 1
* a) Welche Probleme gibt es bei Zuriff auf gemeinsam genutzte Objekt ?
    * Es entsteht ein Inkosistenzproblem (Ref: Abschnitt 2.2)
    * Ein Thread A möchte eine Multiplikation durchführen: Er ruft die Methode mutiply() mit Argument [1,2,3,4,5], Aber vor der letzten Zahl (hier 4) wird Thread B eingeschaltet und er ruft mit Argument [0,0] auf. Das Ergebnis lautet hier Zero statt 120.
    * Hier ist ähnlich wie verlore Buchung.
     
* b) Problem lösen ohne Benutzung der Synchronisation
     * Man kann hier die Schlusswort volatile auf der Attribut wert verwendet
     * Für das Lesen und Schreiben von  primitive Datentypen außer Double und long scheint dass kein Synchronization notwendig ist: (Ref: Abschnitt 2.3.5)