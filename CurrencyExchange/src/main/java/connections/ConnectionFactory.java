package connections;

public class ConnectionFactory {

    public HttpConnection build(String url){
        return new HttpConnection(url);
    }
}
