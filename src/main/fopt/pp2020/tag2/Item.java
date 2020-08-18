package fopt.pp2020.tag2;

public class Item
{
    private String bezeichnung;

    private double gewicht;

    // isSelected
    private double imRuckSack;

    public Item(String bezeichnung, double gewicht)
    {
        this.bezeichnung = bezeichnung;
        this.gewicht = gewicht;
    }

    public double getImRuckSack()
    {
        return imRuckSack;
    }

    public void setImRuckSack(double imRuckSack)
    {
        this.imRuckSack = imRuckSack;
    }

    public String getBezeichnung()
    {
        return bezeichnung;
    }

    public double getGewicht()
    {
        return gewicht;
    }

}
