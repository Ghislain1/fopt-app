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

    exports fopt.demo.kap4;

    exports fopt.buch.abschn2;

    exports fopt.buch.abschn421;

    exports fopt.buch.abschn621;

    exports fopt.buch.absch441;

}