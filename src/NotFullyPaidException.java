public class NotFullyPaidException extends Throwable {

    private String message;
    private long remaining;

    public NotFullyPaidException(String message, long remaining) {
        this.message = message;
        this.remaining = remaining;
    }

    public String getMessage() {
        return message;
    }

    public long getRemaining() {
        return remaining;
    }

    @Override
    public String toString() {
        return "NotFullyPaidException{" +
                "message='" + message + '\'' +
                ", remaining=" + remaining +
                '}';
    }
}
