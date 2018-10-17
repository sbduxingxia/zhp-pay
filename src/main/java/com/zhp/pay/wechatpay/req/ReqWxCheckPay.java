package com.zhp.pay.wechatpay.req;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author zhp.dts
 * @date 2018/10/15.
 */
@XmlRootElement(name = "xml")
public class ReqWxCheckPay extends ReqWxBaseParam implements Serializable {
    private String outTradeNo;
    private String transactionId;

    @XmlElement(name = "transaction_id")
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @XmlElement(name = "out_trade_no")
    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }
}
