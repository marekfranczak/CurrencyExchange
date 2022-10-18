package connections;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection implements Closeable {

    private final HttpURLConnection connection;

    public HttpConnection(String url){
        try{
            connection = (HttpURLConnection) new URL(url).openConnection();
        }catch (IOException e){
            throw new ExceptionApi(e);
        }
    }

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

    @Override
    public void close(){
        connection.disconnect();
    }

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
