package com.zhp.pay.wechatpay.controller;



import com.zhp.pay.wechatpay.WechatContant;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author zhp.dts
 * @date 2018/10/12.
 */
@XmlRootElement(name="xml")
public class ResWxBackBase implements Serializable {
    private String returnCode;
    private String returnMsg;

    @XmlElement( name = "return_code")
    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
    @XmlElement(name= "return_msg")
    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public ResWxBackBase success(String msg){
        setReturnCode(WechatContant.SUCCESS);
        setReturnMsg(msg);
        return this;
    }
    public ResWxBackBase fail(String msg){
        setReturnCode(WechatContant.FAIL);
        setReturnMsg(msg);
        return this;
    }
}
