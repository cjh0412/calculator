package example.calculator3.exception;

public class ErrorException extends Exception{

    public ErrorException(ErrorCode errorCode) {
        super(errorCode.getError());
    }

}
