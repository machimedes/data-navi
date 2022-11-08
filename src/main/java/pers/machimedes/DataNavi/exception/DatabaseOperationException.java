package pers.machimedes.DataNavi.exception;

public class DatabaseOperationException extends BaseException {
    public DatabaseOperationException(String msg) {
        super(2, msg);
    }
}
