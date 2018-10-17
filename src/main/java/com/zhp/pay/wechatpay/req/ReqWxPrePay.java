package com.zhp.pay.wechatpay.req;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author zhp.dts
 * @date 2018/10/11.
 */
@XmlRootElement(name="xml")
public class ReqWxPrePay extends ReqWxBaseParam implements Serializable {
    private String deviceInfo;
    private String body;
    private String detail;
    private String attach;
    private String outTradeNo;
    private String feeType;
    private String totalFee;
    private String spbillCreateIp;
    private String timeStart;
    private String timeExpire;
    private String goodsTag;
    private String notifyUrl;
    private String tradeType;
    private String limitPay;
    private String sceneInfo;

    @XmlElement(name = "device_info")
    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }
    @XmlElement(name = "body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    @XmlElement(name = "detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    @XmlElement(name = "attach")
    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }
    @XmlElement(name = "out_trade_no")
    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }
    @XmlElement(name = "fee_type")
    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }
    @XmlElement(name = "total_fee")
    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }
    @XmlElement(name = "spbill_create_ip")
    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }
    @XmlElement(name = "time_start")
    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }
    @XmlElement(name="time_expire")
    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }
    @XmlElement(name = "goods_tag")
    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }
    @XmlElement(name="notify_url")
    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
    @XmlElement(name = "trade_type")
    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }
    @XmlElement(name="limit_pay")
    public String getLimitPay() {
        return limitPay;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }
    @XmlElement(name="scene_info")
    public String getSceneInfo() {
        return sceneInfo;
    }

    public void setSceneInfo(String sceneInfo) {
        this.sceneInfo = sceneInfo;
    }
}
