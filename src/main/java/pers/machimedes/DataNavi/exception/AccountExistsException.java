package pers.machimedes.DataNavi.exception;

public class AccountExistsException extends BaseException {
    public AccountExistsException() {
        super(1, "账号已存在");
    }
}
