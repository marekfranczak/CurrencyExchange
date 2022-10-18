package connections;

public class ExceptionApi extends RuntimeException {

    public ExceptionApi(Throwable cause){
        super(cause);
    }

    public ExceptionApi(String message){
        super(message);
    }
}
