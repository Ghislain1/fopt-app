package fopt.buch.abschn2;

public class Bank
{
    // Zum Speichern alle Konten in einer Bank!
    private Account[] account;

    private boolean locked;

    // Zum Speicher Anzahl der Konten
    private static int COUNT = 100;

    public Bank()
    {
        this.account = new Account[COUNT];
        // Anlegen 100 Kontoinhalber mit Kontostand auf 0
        for (int i = 0; i < account.length; i++)
        {
            account[i] = new Account();
        }
    }

    // Zum Ausführen einer Abbuchung oder einer Gutschrift
    public void transferMoney(int accountNumber, float amount)
    {
        // Wir haben 2 Probleme hier:
        // 1. Problem der Inkorrektheit
        // 2. Problem der Ineffizienz --> Aktiven Warten oder Polling
        while (this.locked)
        {
            // Kann leider Problem der Inkorrektheit feststellen?
            System.out.println(this.locked);
        }
        this.locked = true;
        // Lesen des aktuallen Kontostandes mit Kontonummer accountNumber z.b. 2
        float oldBalance = this.account[accountNumber].getBalance();
        // Gutschrift oder Abbuchung berechnen
        float newBalance = oldBalance + amount;
        // Setzen des Kontostandes
        this.account[accountNumber].setBalance(newBalance);

        this.printBalance(accountNumber, newBalance);
        locked = false;

    }

    private void printBalance(int accountNumber, float amount)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Angestellte: ");
        stringBuilder.append(Thread.currentThread().getName());

        stringBuilder.append(" KontoNr: ");
        stringBuilder.append(accountNumber);

        stringBuilder.append(" Kontostand: ");
        stringBuilder.append(amount);

        System.out.println(stringBuilder.toString());

    }

}
