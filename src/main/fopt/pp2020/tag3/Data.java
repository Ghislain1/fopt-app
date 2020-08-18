package fopt.pp2020.tag3;

import java.io.Serializable;

//TODO@GhZe:  1. Warum  sollen wir Serializable implementieren?
public class Data implements Serializable
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
// 1. Laut Buch RMI mit Wertuebergabe soll die Datenstuktur serialisieren
// lassen.
