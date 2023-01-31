package connections;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Class responsible for handling the connection to the service.
 * @author Marek Frańczak
 * @since 1.0.0
 * @see Closeable
 */
public class HttpConnection implements Closeable {

    /**
     * @see HttpURLConnection
     */
    private final HttpURLConnection connection;

    /**
     * Constructor creating an object responsible for communication.
     * @param url Url to which the application connects
     * @see URL
     */
    public HttpConnection(String url){
        try{
            connection = (HttpURLConnection) new URL(url).openConnection();
        }catch (IOException e){
            throw new ExceptionApi(e);
        }
    }

    /**
     * Method responsible for capturing the message.
     * @return Captured message in string format.
     */
    public String response(){
        validResponse();
        StringBuilder response = new StringBuilder();
        try(BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
            String line;
            while ((line = responseReader.readLine()) != null){
                response.append(line);
            }
        }catch (IOException e){
            throw new ExceptionApi(e);
        }
        return response.toString();
    }

    /**
     * Method responsible for close connection with service.
     * @see Closeable
     */
    @Override
    public void close(){
        connection.disconnect();
    }

    /**
     * Method that checks the correctness of the service's response.
     */
    void validResponse(){
        try {
            int responseCode = connection.getResponseCode();
            if(responseCode != 200){
                String responseMessage = connection.getResponseMessage();
                throw new ExceptionApi(String.format("Something went wrong! [%d] %s", responseCode, responseMessage));
            }
        } catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
