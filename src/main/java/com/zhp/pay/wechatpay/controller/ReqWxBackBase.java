package com.zhp.pay.alipay.wechatpay.controller;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author zhp.dts
 * @date 2018/10/12.
 */
public class ReqWxBackBase {

    private String appId;
    private String mchId;
    private String nonceStr;
    private String returnCode;
    private String returnMsg;


    public String getAppId() {
        return appId;
    }
    @XmlElement(name="appid")
    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }
    @XmlElement(name="mch_id")
    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getNonceStr() {
        return nonceStr;
    }
    @XmlElement(name = "nonce_str")
    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getReturnCode() {
        return returnCode;
    }

    @XmlElement(name="return_code")
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }
    @XmlElement(name="return_msg")
    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }
}
