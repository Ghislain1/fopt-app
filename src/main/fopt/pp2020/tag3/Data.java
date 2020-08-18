package fopt.pp2020.tag3;

public class Data
{
    private int value;

    public int getValue()
    {
        // Ausgabe auf der Console erzeugen
        System.out.println("GETTER> " + this.value);
        return this.value;
    }

    public void setValue(int value)
    {
        this.value = value;
        // Ausgabe auf der Console erzeugen
        System.out.println("SETTER> " + this.value);

    }

}
