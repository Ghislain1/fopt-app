module fopt
{
    // Read-Abhaengigkeiten von fopt-app
    requires java.rmi;

    requires javafx.graphics;

    requires javafx.controls;

    /*
     * requires transitive org.apiguardian.api; requires transitive
     * org.junit.platform.commons; requires transitive org.opentest4j;
     */

    // Exports von Packages von fopt-app
    exports pp.eventset;

    exports fopt.buch.abschn2;

    exports fopt.buch.abschn421;

    exports fopt.buch.abschn621;
}