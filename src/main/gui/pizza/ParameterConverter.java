package gui.pizza;

import java.util.Map;

public class ParameterConverter
{
    private static final String PARAM_NAME_INGREDIENTS = "toppings";

    private static final String PARAM_NAME_INGREDIENTS_PRICES = "toppingPrices";

    private static final String PARAM_NAME_SIZES = "sizes";

    private static final String PARAM_NAME_SIZE_PRICES = "sizePrices";

    private static final String PARAM_NAME_DEFAULT_INGRIEDENTS_NUMBER = "numberOfDefaultToppings";

    public static Configuration createConfiguration(Map<String, String> namedParameters)
    {
        checkParameterExistence(namedParameters);

        String[] toppingNames = parseStringValues(namedParameters.get(PARAM_NAME_INGREDIENTS));
        String[] sizeNames = parseStringValues(namedParameters.get(PARAM_NAME_SIZES));
        int[] toppingPrices = parseIntValues(namedParameters.get(PARAM_NAME_INGREDIENTS_PRICES));
        int[] sizePrices = parseIntValues(namedParameters.get(PARAM_NAME_SIZE_PRICES));
        int numberOfDefaultToppings = parseIntValue(namedParameters.get(PARAM_NAME_DEFAULT_INGRIEDENTS_NUMBER));

        return new Configuration(sizeNames, sizePrices, toppingNames, toppingPrices, numberOfDefaultToppings);
    }

    private static void checkParameterExistence(Map<String, String> namedParameters)
    {
        String[] allParams =
        { PARAM_NAME_INGREDIENTS, PARAM_NAME_INGREDIENTS_PRICES, PARAM_NAME_SIZES, PARAM_NAME_SIZE_PRICES, PARAM_NAME_DEFAULT_INGRIEDENTS_NUMBER };

        if (namedParameters.isEmpty())
        {
            throw new IllegalStateException("no named parameters available");
        }
        for (String parameterName : allParams)
        {
            if (!namedParameters.containsKey(parameterName))
            {
                throw new IllegalStateException("parameter " + parameterName + " does not exist");
            }
        }
    }

    private static String[] parseStringValues(String s)
    {
        String[] values = s.split(",");
        for (int i = 0; i < values.length; i++)
        {
            values[i] = values[i].trim();
        }
        return values;
    }

    private static int[] parseIntValues(String s)
    {
        String[] tmp = parseStringValues(s);
        int[] values = new int[tmp.length];

        for (int i = 0; i < values.length; i++)
        {
            values[i] = Integer.parseInt(tmp[i]);
        }
        return values;
    }

    private static int parseIntValue(String s)
    {
        return Integer.parseInt(s.trim());
    }

}