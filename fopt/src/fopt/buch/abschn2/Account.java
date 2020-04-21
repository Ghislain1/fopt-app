package fopt.buch.abschn2;

/**
 * Repräsentiert einen Konto in der Bankbetrieb. Sehr einfach abtrahiert!!.
 */
public class Account
{

    // Zum Speichern des Kontostandes eines Konten.
    private float balance;

    // Zum Lesen des Kontostandes eines Kontoinhalbers
    public float getBalance()
    {
        return balance;
    }

    // Zum Setzen des Kontostandes eines Kontoinhalbers.
    public void setBalance(float balance)
    {
        this.balance = balance;
    }

}
