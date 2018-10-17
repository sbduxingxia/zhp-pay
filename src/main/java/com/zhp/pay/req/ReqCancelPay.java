package com.zhp.pay.req;

import java.io.Serializable;

/**
 * @author zhp.dts
 * @date 2018/10/15.
 */
public class ReqCancelPay extends ReqPayType implements Serializable {
    private String orderCode;
    private String nonceStr;
    private String operatorId;

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }
}
