package com.zhp.pay.wechatpay.req;

import com.github.wxpay.sdk.WXPayUtil;
import com.zhp.pay.config.IPayConfig;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author zhp.dts
 * @date 2018/10/16.
 */
public class ReqWxBaseParam {
    private String appId;
    private String mchId;
    private String nonceStr;
    private String sign;
    private String signType;

    @XmlElement(name="appid")
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
    @XmlElement(name="mch_id")
    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }
    @XmlElement(name = "nonce_str")
    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }
    @XmlElement(name = "sign")
    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
    @XmlElement(name = "sign_type")
    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    /**
     * 初始化必要参数
     * @param config
     */
    public void initBase(IPayConfig config){
        setAppId(config.getAppId());
        setMchId(config.getPayStoreId());
        setNonceStr(WXPayUtil.generateNonceStr());

    }
}
