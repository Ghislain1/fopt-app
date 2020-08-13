package gui.pizza;

// Nicht vom Mir gemacht!!
// Diese Klasse aus Sicht der MVP-Architekturmuster repraesentiert MODEL
public class Configuration
{
    String[] SizeNames;

    int[] SizePrices;

    String[] ToppingNames;

    int[] ToppingPrices;

    int NumberOfDefaultToppings;

    public Configuration(String[] SizeNames, int[] SizePrices, String[] ToppingNames, int[] ToppingPrices, int NumberOfDefaultToppings)
    {
        if (SizeNames == null || SizePrices == null || ToppingNames == null || ToppingPrices == null || SizeNames.length != SizePrices.length || ToppingNames.length != ToppingPrices.length || NumberOfDefaultToppings > ToppingNames.length)
        {
            throw new IllegalArgumentException();
        }

        this.SizeNames = SizeNames;
        this.SizePrices = SizePrices;
        this.ToppingNames = ToppingNames;
        this.ToppingPrices = ToppingPrices;
        this.NumberOfDefaultToppings = NumberOfDefaultToppings;

    }

    public String[] getSizeNames()
    {
        return SizeNames;
    }

    public int[] getSizePrices()
    {
        return SizePrices;
    }

    public String[] getToppingNames()
    {
        return ToppingNames;
    }

    public int[] getToppingPrices()
    {
        return ToppingPrices;
    }

    public int getNumberOfDefaultToppings()
    {
        return NumberOfDefaultToppings;
    }

    public void setSizeNames(String[] sizeNames)
    {
        SizeNames = sizeNames;
    }

    public void setSizePrices(int[] sizePrices)
    {
        SizePrices = sizePrices;
    }

    public void setToppingNames(String[] toppingNames)
    {
        ToppingNames = toppingNames;
    }

    public void setToppingPrices(int[] toppingPrices)
    {
        ToppingPrices = toppingPrices;
    }

    public void setNumberOfDefaultToppings(int numberOfDefaultToppings)
    {
        NumberOfDefaultToppings = numberOfDefaultToppings;
    }
}