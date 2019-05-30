public class NotSufficientChangeException extends Throwable {

    private String message;

    public NotSufficientChangeException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "NotSufficientChangeException{" +
                "message='" + message + '\'' +
                '}';
    }
}
