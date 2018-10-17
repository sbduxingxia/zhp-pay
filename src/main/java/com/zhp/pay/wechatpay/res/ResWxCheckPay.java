package com.zhp.pay.wechatpay.res;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author zhp.dts
 * @date 2018/10/11.
 */
@XmlRootElement(name = "xml")
public class ResWxCheckPay extends ResWxBaseParam implements Serializable {
    private String prepayId;
    private String tradeType;
    private String tradeStatus;

    public String getTradeStatus() {
        return tradeStatus;
    }
    @XmlElement(name="trade_state")
    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

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
