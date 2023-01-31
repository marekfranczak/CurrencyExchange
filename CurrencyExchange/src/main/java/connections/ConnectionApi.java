package connections;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

/**
 * Class responsible for connecting to the service and downloading the currency rate.
 * @author Marek Frańczak
 * @since 1.0.0
 */
public class ConnectionApi {

    /**
     * Field storing the token to the service that that provides exchange rates.
     * Replace "xxx" with a token before use.
     */
    private static final String API_URL_TEMPLE = "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=%s&to_currency=%s&apikey=xxx";

    /**
     * @see ConnectionFactory
     */
    private final ConnectionFactory connectionFactory;
    /**
     * @see Jsonb
     */
    private final Jsonb jsonb;

    /**
     * Empty constructor.
     */
    public ConnectionApi(){
        this(new ConnectionFactory(), JsonbBuilder.create());
    }

    /**
     * Constructor that creates objects connectionFactory and jsonb.
     * @param connectionFactory ConnectionFactory object that will be responsible for connecting to the service.
     * @param jsonb Jsonb object that will store the service response.
     */
    public ConnectionApi(ConnectionFactory connectionFactory, Jsonb jsonb){
        this.connectionFactory = connectionFactory;
        this.jsonb = jsonb;
    }

    /**
     * Method responsible for establishing a connection and obtaining information about the course.
     * @param exchangeFrom Source currency code
     * @param exchangeTo Target currency code
     * @return Value of the current exchange rate of selected currencies.
     */
    public double exchangeRate(String exchangeFrom, String exchangeTo){
        String requestUrl = String.format(API_URL_TEMPLE, exchangeFrom, exchangeTo);

        try(HttpConnection connection = connectionFactory.build(requestUrl)){
            String response = connection.response();
            RateInformation jsonObject = jsonb.fromJson(response, RateInformation.class);
            if(jsonObject.getRateDetails() == null){
                return 0.0;
            }
            return Double.parseDouble(jsonObject.getRateDetails().getExchangeRate());
        }
    }
}
