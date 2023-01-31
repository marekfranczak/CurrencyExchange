package connections;

/**
 * Class responsible for creating the object HttpConnection.
 * @author Marek Frańczak
 * @since 1.0.0
 */
public class ConnectionFactory {

    public HttpConnection build(String url){
        return new HttpConnection(url);
    }
}
