package Lab1;

import java.util.Scanner;

public class Exchange implements Input{
    private static final ExchangeRateTable exchangeRateTable = ExchangeRateTable.getInstance();
    Scanner input = new Scanner(System.in);

    private String kodZrodlowej = "";
    private String kodDocelowej = "";


    private float wartosc = 0.0f;
    private float currencyRate1 = 0.0f;
    private float currencyRate2 = 0.0f;
    private float conversionFactor1 = 0.0f;
    private float conversionFactor2 = 0.0f;

    @Override
    public void input() throws Exception{
        System.out.println("Numer tabeli: " + exchangeRateTable.getTableNumber());
        System.out.println("Data publikacji tabeli: " + exchangeRateTable.getDateOfPublication());

        System.out.println("Podaj kod waluty zrodlowej: ");
        kodZrodlowej = input.nextLine();
        System.out.println("Podaj kod waluty docelowej: ");
        kodDocelowej = input.nextLine();
        if(kodZrodlowej.trim().length() > 3 || kodDocelowej.trim().length() > 3){throw new Exception("Wrong currency code");}
        System.out.println("Podaj wartosc: ");
        wartosc = Float.parseFloat(input.nextLine());
    }

    public void exchange() throws Exception {
        for(Currency c : exchangeRateTable.getCurrencyList()) {

            if (c.getCurrencyCode().equalsIgnoreCase(kodZrodlowej)) {
                currencyRate1 = c.getCurrencyRate();
                conversionFactor1 = c.getConversionFactor();
            }
            if (c.getCurrencyCode().equalsIgnoreCase(kodDocelowej)) {
                currencyRate2 = c.getCurrencyRate();
                conversionFactor2 = c.getConversionFactor();
            }
        }
        if(currencyRate1 == 0 || currencyRate2 == 0){throw new Exception("Currency not found");}

        float amountOfMoney = ((currencyRate1 * conversionFactor2 / (currencyRate2 * conversionFactor1)) * wartosc);
        System.out.printf("Exchanged: %.4f", amountOfMoney);

    }
}
