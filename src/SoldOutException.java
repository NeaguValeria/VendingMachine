public class SoldOutException extends Throwable {

    private String message;

    public SoldOutException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SoldOutException{" +
                "message='" + message + '\'' +
                '}';
    }
}
