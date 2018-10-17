package com.zhp.pay.wechatpay.req;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.github.wxpay.sdk.WXPayUtil;
import com.zhp.pay.config.IPayConfig;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 微信支付js sdk支付参数
 * @author zhp.dts
 * @date 2018/10/16.
 */
@XmlRootElement(name = "xml")
public class ReqWxH5Pay implements Serializable {
    private String appId;
    private String content;
    private String nonceStr;
    private String timeStamp;
    private String signType;
    private String paySign;

    @XmlElement(name="appId")
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @XmlElement(name="package")
    @JSONField(name="package")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @XmlElement(name="nonceStr")
    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    @XmlElement(name="timeStamp")
    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @XmlElement(name="signType")
    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    @XmlElement(name="paySign")
    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }

    public void setPrepayId(String prepayId){
        this.content = "prepay_id="+prepayId;
    }
    /**
     * 初始化必要参数
     * @param config
     */
    public void initBase(IPayConfig config){
        setAppId(config.getAppId());
        setNonceStr(WXPayUtil.generateNonceStr());
        setTimeStamp((int)(System.currentTimeMillis()/1000)+"");
        setSignType("MD5");
    }

    public String toJSONString() {
        return JSON.toJSONString(this);
        /*StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{")
                .append("\"appId\":").append("\"").append(getAppId()).append("\",")
                .append("\"timeStamp\":").append("\"").append(getTimeStamp()).append("\",")
                .append("\"nonceStr\":").append("\"").append(getNonceStr()).append("\",")
                .append("\"package\":").append("\"").append(getContent()).append("\",")
                .append("\"signType\":").append("\"").append(getSignType()).append("\",")
                .append("\"paySign\":").append("\"").append(getPaySign()).append("\"")
                .append("}");
        return stringBuffer.toString();*/
    }
}
