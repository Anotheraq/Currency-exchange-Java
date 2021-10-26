package Lab1;

public class Currency {
    private final String name;
    private final float conversionFactor;
    private final String currencyCode;
    private final float currencyRate;

    public Currency(String name, float conversionFactor, String currencyCode, float currencyRate){
        this.name = name;
        this.conversionFactor = conversionFactor;
        this.currencyCode = currencyCode;
        this.currencyRate = currencyRate;
    }
    public String getName() {
       return name;
    }

    public float getConversionFactor() {
        return conversionFactor;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public float getCurrencyRate() {
        return currencyRate;
    }
}
