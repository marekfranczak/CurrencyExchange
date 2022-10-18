package calculations;

import connections.ConnectionApi;

public class Calc {

    private double currentCurrency;
    private double exchangeRate;
    private double newCurrency;

    public double getCurrentCurrency() {
        return currentCurrency;
    }

    public void setCurrentCurrency(double currentCurrency) {
        this.currentCurrency = currentCurrency;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public double getNewCurrency() {
        return newCurrency;
    }

    public String calc(double currentCurrency, String exchangeFrom, String exchangeTo){
        this.currentCurrency = currentCurrency;
        this.exchangeRate = new ConnectionApi().exchangeRate(exchangeFrom, exchangeTo);
        newCurrency = currentCurrency * exchangeRate;
        return String.valueOf(newCurrency);
    }
}
