package pers.machimedes.DataNavi.exception;

public class BaseException extends Exception {
    public int code;

    public BaseException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }
}
