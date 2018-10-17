package com.zhp.pay.req;

import java.io.Serializable;

/**
 * @author zhp.dts
 * @date 2018/10/17.
 */
public class ReqPayResult extends ReqPayType implements Serializable {
    private String orderCode;
    private String payStoreCode;
    private String nonceStr;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getPayStoreCode() {
        return payStoreCode;
    }

    public void setPayStoreCode(String payStoreCode) {
        this.payStoreCode = payStoreCode;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }
}
