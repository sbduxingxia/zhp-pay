package com.zhp.pay.wechatpay.res;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author zhp.dts
 * @date 2018/10/11.
 */
@XmlRootElement(name = "xml")
public class ResWxPrePay extends ResWxBaseParam implements Serializable {
    private String prepayId;
    private String tradeType;

    public String getTradeType() {
        return tradeType;
    }
    @XmlElement(name = "trade_type")
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getPrepayId() {
        return prepayId;
    }
    @XmlElement(name = "prepay_id")
    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

}
