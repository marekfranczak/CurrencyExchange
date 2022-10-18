package connections;

import javax.json.bind.annotation.JsonbProperty;

public class RateInformation {

    @JsonbProperty("Realtime Currency Exchange Rate")
    private RateDetails rateDetails;

    public RateDetails getRateDetails() {
        return rateDetails;
    }

    public void setRateDetails(RateDetails rateDetails) {
        this.rateDetails = rateDetails;
    }
}
