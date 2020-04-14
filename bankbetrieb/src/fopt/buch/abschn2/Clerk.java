package fopt.buch.abschn2;

public class Clerk extends Thread
{
    // Zum Speichern des gemeinsam genutzten Objektes...
    private Bank bank;

    public Clerk(String name, Bank bank)
    {
        // Name der Thread bzw. der Bankangestellte
        super(name);
        this.bank = bank;

        // Angestellte erwecken!! LOL
        start();
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 10000; i++)
        {
            /*
             * Kontonummer einlesen; simuliert durch Wahl einer Zufallszahl
             * zwischen 0 und 99
             */
            int accountNumber = (int) (Math.random() * 100);
            /*
             * Überweisungsbetrag einlesen; simuliert durch Wahl einer
             * Zufallszahl zwischen -500 und +499
             */
            float amount = (int) (Math.random() * 1000) - 500;

            // Ausführen eine Gutschrift Oder Buchung..
            bank.transferMoney(accountNumber, amount);
        }
    }

}
