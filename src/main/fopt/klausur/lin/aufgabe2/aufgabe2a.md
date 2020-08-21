a. die Lösung funktioniert nicht wie die vorgegeben wird.
1. in tick methode muss schreibende aktion vorhanden, nur notifyAll() in {} bringt nix.
2. durch notifyAll kann ein Thread mehrfach nicht aufgeweckt werden. die bedingung in while schleife kann die wartende Zeit nicht richtig darstellen.



b. Lösung sieht LogicalTime

c. notifyAll ist besser als notify.
die Bedingung für notifyAll --> 1. es gibt mehrere Wartebedingungen (verschiedene Thread mit unterschiedlich waitTickValue)
                            --> 2. kann durch die Änderung des Werts können mehr als ein Thread ihre while-wait-schleife verlassen.
