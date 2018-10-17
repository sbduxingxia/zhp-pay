package com.zhp.pay.res;

/**
 * @author zhp.dts
 * @date 2018/10/11.
 */
public class ResPrePayOrder extends ResBase {
    private String prePayCode;
    private String tradeType;
    private String requestParamString;

    public String getRequestParamString() {
        return requestParamString;
    }

    public void setRequestParamString(String requestParamString) {
        this.requestParamString = requestParamString;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getPrePayCode() {
        return prePayCode;
    }

    public void setPrePayCode(String prePayCode) {
        this.prePayCode = prePayCode;
    }
}
