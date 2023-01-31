package connections;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Class that handles the json data format. Contains further annotated json fields and get(), set() methods for them.
 * @author Marek Frańczak
 * @since 1.0.0
 * @see javax.json.JsonObject
 */
public class RateDetails {

    @JsonbProperty("1. From_Currency Code")
    private String fromCurrncyCode;
    @JsonbProperty("2. From_Currency Name")
    private String fromCurrencyName;
    @JsonbProperty("3. To_Currency Code")
    private String toCurrencyCode;
    @JsonbProperty("4. To_Currency Name")
    private String toCurrencyName;
    @JsonbProperty("5. Exchange Rate")
    private String exchangeRate;
    @JsonbProperty("6. Last Refreshed")
    private String lastRefreshed;
    @JsonbProperty("7. Time Zone")
    private String timeZone;
    @JsonbProperty("8. Bid Price")
    private String bidPrice;
    @JsonbProperty("9. Ask Price")
    private String askPrice;


    public String getFromCurrncyCode() {
        return fromCurrncyCode;
    }

    public void setFromCurrncyCode(String fromCurrncyCode) {
        this.fromCurrncyCode = fromCurrncyCode;
    }

    public String getFromCurrencyName() {
        return fromCurrencyName;
    }

    public void setFromCurrencyName(String fromCurrencyName) {
        this.fromCurrencyName = fromCurrencyName;
    }

    public String getToCurrencyCode() {
        return toCurrencyCode;
    }

    public void setToCurrencyCode(String toCurrencyCode) {
        this.toCurrencyCode = toCurrencyCode;
    }

    public String getToCurrencyName() {
        return toCurrencyName;
    }

    public void setToCurrencyName(String toCurrencyName) {
        this.toCurrencyName = toCurrencyName;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    public void setLastRefreshed(String lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(String askPrice) {
        this.askPrice = askPrice;
    }
}
