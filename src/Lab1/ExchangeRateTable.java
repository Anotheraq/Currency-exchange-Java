package Lab1;

import java.util.ArrayList;
import java.util.List;

public class ExchangeRateTable {
    public static ExchangeRateTable instance = null;

    private String dateOfPublication;
    private String tableNumber;

    private List<Currency> currencyList = new ArrayList<>();

    public void add(Currency currency){
        currencyList.add(currency);
    }

    private ExchangeRateTable(){

    }

    public static ExchangeRateTable getInstance(){
        if (instance == null){
            instance = new ExchangeRateTable();
        }
        return instance;
    }


    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }
}
