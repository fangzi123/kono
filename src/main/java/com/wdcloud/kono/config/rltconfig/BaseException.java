package com.wdcloud.kono.config.rltconfig;

public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -4271274584614989089L;

    protected String[] i18nMsg;

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, String... i18nMsg) {
        super(message);
        this.i18nMsg = i18nMsg;
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public String[] getI18nMsg() {
        return i18nMsg;
    }

    public void setI18nMsg(String... i18nMsg) {
        this.i18nMsg = i18nMsg;
    }
}
