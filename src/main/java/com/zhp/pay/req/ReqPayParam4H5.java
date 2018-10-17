package com.zhp.pay.req;

import java.io.Serializable;

/**
 * @author zhp.dts
 * @date 2018/10/16.
 */
public class ReqPayParam4H5 extends ReqPayType implements Serializable {
    private String tradeNo;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
}
