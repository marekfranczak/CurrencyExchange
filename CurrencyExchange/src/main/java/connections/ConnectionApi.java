package connections;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;


public class ConnectionApi {

    private static final String API_URL_TEMPLE = "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=%s&to_currency=%s&apikey=3WBOHBSE4FOKCNCY";

    private final ConnectionFactory connectionFactory;
    private final Jsonb jsonb;

    public ConnectionApi(){
        this(new ConnectionFactory(), JsonbBuilder.create());
    }

    public ConnectionApi(ConnectionFactory connectionFactory, Jsonb jsonb){
        this.connectionFactory = connectionFactory;
        this.jsonb = jsonb;
    }

    public double exchangeRate(String exchangeFrom, String exchangeTo){
        String requestUrl = String.format(API_URL_TEMPLE, exchangeFrom, exchangeTo);

        try(HttpConnection connection = connectionFactory.build(requestUrl)){
            String response = connection.response();
            RateInformation jsonObject = jsonb.fromJson(response, RateInformation.class);
            if(jsonObject.getRateDetails() == null){
                return 0.0;
            }
            System.out.println(Double.parseDouble(jsonObject.getRateDetails().getExchangeRate()));
            return Double.parseDouble(jsonObject.getRateDetails().getExchangeRate());
        }
    }
}
