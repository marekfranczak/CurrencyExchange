package calculations;

import connections.ConnectionApi;

/**
 * Class with methods responsible for calculating the value of the exchanged currency.
 * @author Marek Frańczak
 * @since 1.0.0
 */

public class Calc {

    /**
     * Field storing the exchange rate of currently exchanged currencies.
     */
    private double exchangeRate;

    /**
     * Method returns the currently used currency rate.
     * @return Currently used exchange rate.
     */
    public double getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Method returns value after converting currencies.
     * @param currentCurrency The value of the currency to be exchanged
     * @param exchangeFrom Initial currency. Use the ISO 4217 currency code.
     * @param exchangeTo Destination currency. Use the ISO 4217 currency code.
     * @return Value after converting currencies.
     */
    public String calc(double currentCurrency, String exchangeFrom, String exchangeTo){
        this.exchangeRate = new ConnectionApi().exchangeRate(exchangeFrom, exchangeTo);
        double newCurrency = currentCurrency * exchangeRate;
        return String.valueOf(newCurrency);
    }
}
