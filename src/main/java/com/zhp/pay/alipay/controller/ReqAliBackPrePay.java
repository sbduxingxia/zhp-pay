package com.zhp.pay.alipay.controller;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author zhp.dts
 * @date 2018/10/17.
 */
public class ReqAliBackPrePay implements Serializable {
    private String tradeNo;
    private String tradeStatus;
    private String totalAmount;
    private String outTradeNo;

    public String getOutTradeNo() {
        return outTradeNo;
    }
    @JSONField(name="out_trade_no")
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }
    @JSONField(name="trade_no")
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }
    @JSONField(name="trade_status")
    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getTotalAmount() {
        return totalAmount;
    }
    @JSONField(name="total_amount")
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
