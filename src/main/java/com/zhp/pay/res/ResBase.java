package com.zhp.pay.res;

/**
 * @author zhp.dts
 * @date 2018/10/11.
 */
public class ResBase {
    //请求过程是否正常
    private boolean isSuccess;
    private String statusCode;
    private String statusMessage;
    private Object storeResult;


    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Object getStoreResult() {
        return storeResult;
    }

    public void setStoreResult(Object storeResult) {
        this.storeResult = storeResult;
    }
}
