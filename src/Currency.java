import com.google.gson.internal.LinkedTreeMap;

public class Currency {

    private LinkedTreeMap<String, Double> conversion_rates;
    public double getConversionRate (String currency) {
        return conversion_rates.get(currency);
    }
}
