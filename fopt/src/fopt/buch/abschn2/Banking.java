package fopt.buch.abschn2;

public class Banking
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

        // Erzeugen des gemeinsam genutzten Objektes
        Bank myBank = new Bank();

        // Erzeugen 3 Threads mit automatisch impliziert erwecken
        new Clerk("Andrea Müller", myBank);
        new Clerk("Petra Schmitt", myBank);
        new Clerk("Ghislain", myBank);

    }

}
