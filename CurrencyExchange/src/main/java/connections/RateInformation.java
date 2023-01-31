package connections;

import javax.json.bind.annotation.JsonbProperty;

/**
 * Class that passes information about the exchange rate from the class RateDetails.
 * @author Marek Frańczak
 * @since 1.0.0
 * @see javax.json.JsonObject
 */
public class RateInformation {

    @JsonbProperty("Realtime Currency Exchange Rate")
    private RateDetails rateDetails;

    public RateDetails getRateDetails() {
        return rateDetails;
    }
}
