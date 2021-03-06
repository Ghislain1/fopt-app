package fopt.pp2020.tag2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model
{
    private double gesamtGW;

    private double maxWeight;

    private double[] einzelgewichte;

    private List<Double> allItemWeights;

    List<String> enabledItems;

    private HashMap<String, Double> map;

    public Model(String[] bezeichnungen, double[] einzelgewichte, double maxWeight)
    {

        this.einzelgewichte = einzelgewichte;
        this.maxWeight = maxWeight;
        allItemWeights = new ArrayList<>();
        for (double db : this.einzelgewichte)
        {
            allItemWeights.add(Double.valueOf(db));
        }
        this.enabledItems = new ArrayList<>();
        this.map = new HashMap<String, Double>();
        int index = 0;
        for (String bz : bezeichnungen)
        {
            this.map.put(bz, einzelgewichte[index]);
            index++;
        }

    }

    // Liefert eine String-Liste mit den Bezeichnungen aller im Moment noch
    // selektierbaren Gegenstaende (die schon selektierten kommen darin nicht
    // vor).
    public List<String> getEnabledItems()//
    {
        return this.enabledItems;
    }

    // Liefert das momentane Gesamtgewicht aller selektierter Gegenstaende.
    public double getSumOfUsedWeights()
    {
        return this.sum;
    }

    // Liefert eine String-Liste mit den Bezeichnungen aller Gegenstaende.
    public List<String> getAllItemNames()
    {
        // Siehe Abschnitt 4.4.2 Buch
        return List.of(this.map.keySet().toArray(new String[0]));
    }

    // : Liefert ein Double-Liste mit den Gewichten aller Gegenstaende.
    public List<Double> getAllItemWeights()
    {
        return allItemWeights;
    }

    private double sum;

    // Setzt fuer den Gegenstand mit der Bezeichnung name die
    public void setSelected(String name, boolean selected)
    {

        double gewicht = Double.valueOf(this.map.get(name));
        if (selected)
        {
            if (sum + gewicht <= this.getMaxWeight())
            {
                this.sum = sum + gewicht;
            }
        }
        else
        {
            this.sum = sum - gewicht;
        }

        // Filter
        for (String bez : this.map.keySet())
        {
            Double value = Double.valueOf(this.map.get(bez));

            if (this.sum + value > this.getMaxWeight())
            {
                this.enabledItems.add(bez);
            }

        }

    }

    // : Liefert das maximal zulaessige Gesamtgewicht.
    public double getMaxWeight()
    {
        return maxWeight;
    }

}
