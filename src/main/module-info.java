module fopt
{
    // Read-Abhaengigkeiten von fopt-app
    requires java.rmi;

    requires transitive javafx.graphics;

    requires javafx.controls;

    requires javafx.base;

    /*
     * requires transitive org.apiguardian.api; requires transitive
     * org.junit.platform.commons; requires transitive org.opentest4j;
     */

    // Exports von Packages von fopt-app
    exports pp.eventset;

    exports fopt.buch.abschn2;

    exports fopt.buch.abschn421;

    exports fopt.buch.abschn621;

    exports fopt.buch.absch441;

    exports fopt.buch.abschn413;

    exports fopt.buch.absch431;

    exports fopt.buch.abschn452;

    exports fopt.buch.absch433;

    exports fopt.klausur.ghis.ws2013;

    exports pp.filelocking;

    exports gui.graphics.sinus;

    exports fopt.klausur.ghis.ss2019;

    // TODO@Lin this package is not exist!! check it again if you have trouble
    // ToDo@Ghislain: this two package exists.
    exports fopt.klausur.lin.aufgabe5;

    exports fopt.klausur.lin.aufgabe6;

    exports fopt.klausur.lin.aufgabe7;

    // 4 packages for rmi exercises
    exports fopt.pp2020.lin.tag3.aufgabe4.client;

    exports fopt.pp2020.lin.tag3.aufgabe4.interfaces;

    exports fopt.pp2020.lin.tag3.aufgabe4.logic;

    exports fopt.pp2020.lin.tag3.aufgabe4.server;

    exports fopt.pp2020.lin.tag2;

    exports fopt.buch.abschn55;

    exports fopt.pp2020.tag2;

    exports fopt.buch.abschn64;

    exports fopt.pp2020.tag3;

    // In Ordner der Klassendatein soll rmiregistry gestartet werden
    // Demonstraktion von Call-By-Value in RMI -> Serialization
    // Effekt von synchronized bei RMI-Method
    exports fopt.video.rmi.sleep;

    // MVP Grundstruktr von Video Vorlesung
    // Typysche Methode in View, Presenter
    exports fopt.video.gbo.login;

}