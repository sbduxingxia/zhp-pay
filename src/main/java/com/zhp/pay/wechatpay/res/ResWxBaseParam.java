package com.zhp.pay.wechatpay.res;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author zhp.dts
 * @date 2018/10/16.
 */
public class ResWxBaseParam {
    private String returnCode;

    private String returnMsg;

    private String appId;
    private String mchId;
    private String nonceStr;
    private String sign;
    private String resultCode;
    private String errCode;
    private String errCodeDes;

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
    @XmlElement(name="nonce_str")
    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }
    @XmlElement(name="sign")
    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getResultCode() {
        return resultCode;
    }
    @XmlElement(name = "result_code")
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrCode() {
        return errCode;
    }
    @XmlElement(name = "err_code")
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }
    @XmlElement(name="err_code_des")
    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }
}
