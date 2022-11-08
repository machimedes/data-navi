package pers.machimedes.DataNavi.util;

import pers.machimedes.DataNavi.exception.BaseException;

public class ResultWrap<T> {
    private int code;
    private T data;
    private String message;
    private String error;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public static <T> ResultWrap<T> success(T data) {
        return new ResultWrap<T>(0, data);
    }

    public static <T> ResultWrap<T> fail(int code, String message, String error) {
        assert code != 0;
        return new ResultWrap<T>(0, message, error);
    }

    public static <T> ResultWrap<T> fail(BaseException baseException) {
        Throwable cause = baseException.getCause();
        return new ResultWrap<T>(baseException.code, baseException.getMessage(),
                cause == null ? null : cause.toString());
    }

    public ResultWrap(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResultWrap(int code, String message, String error) {
        this.code = code;
        this.message = message;
        this.error = error;
    }

}

