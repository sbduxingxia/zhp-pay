package com.zhp.pay.wechatpay.req;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author zhp.dts
 * @date 2018/10/15.
 */
@XmlRootElement(name = "xml")
public class ReqWxCancelPay extends ReqWxBaseParam implements Serializable {
    private String outTradeNo;

    @XmlElement(name = "out_trade_no")
    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }
}
