package com.zhp.pay.alipay.wechatpay.controller;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author zhp.dts
 * @date 2018/10/12.
 */
@XmlRootElement(name = "xml")
public class ReqWxBackPrePay extends ReqWxBackBase implements Serializable {
    private String deviceInfo;
    private String sign;
    private String errCode;
    private String errCodeDes;
    private String openId;
    private String isSubscribe;
    private String tradeType;
    private String bankType;
    private int totalFee;
    private String feeType;
    private int cashFee;
    private String cashFeeType;
    private int couponFee;
    private int couponCount;
    private String transactionId;
    private String outTradeNo;
    private String attach;
    private String timeEnd;
    private String resultCode;

    public String getResultCode() {
        return resultCode;
    }
    @XmlElement(name = "result_code")
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }
    @XmlElement(name = "device_info")
    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getSign() {
        return sign;
    }
    @XmlElement(name = "sign")
    public void setSign(String sign) {
        this.sign = sign;
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

    public String getOpenId() {
        return openId;
    }
    @XmlElement(name = "openid")
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getIsSubscribe() {
        return isSubscribe;
    }
    @XmlElement(name = "is_subscribe")
    public void setIsSubscribe(String isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public String getTradeType() {
        return tradeType;
    }
    @XmlElement(name = "trade_type")
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getBankType() {
        return bankType;
    }
    @XmlElement(name = "bank_type")
    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public int getTotalFee() {
        return totalFee;
    }
    @XmlElement(name="total_fee")
    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String getFeeType() {
        return feeType;
    }
    @XmlElement(name = "fee_type")
    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public int getCashFee() {
        return cashFee;
    }
    @XmlElement(name="cash_fee")
    public void setCashFee(int cashFee) {
        this.cashFee = cashFee;
    }

    public String getCashFeeType() {
        return cashFeeType;
    }
    @XmlElement(name = "cash_fee_type")
    public void setCashFeeType(String cashFeeType) {
        this.cashFeeType = cashFeeType;
    }

    public int getCouponFee() {
        return couponFee;
    }
    @XmlElement(name = "coupon_fee")
    public void setCouponFee(int couponFee) {
        this.couponFee = couponFee;
    }

    public int getCouponCount() {
        return couponCount;
    }
    @XmlElement(name = "coupon_count")
    public void setCouponCount(int couponCount) {
        this.couponCount = couponCount;
    }

    public String getTransactionId() {
        return transactionId;
    }
    @XmlElement(name = "transaction_id")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }
    @XmlElement(name = "out_trade_no")
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getAttach() {
        return attach;
    }
    @XmlElement(name = "attach")
    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getTimeEnd() {
        return timeEnd;
    }
    @XmlElement(name="time_end")
    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }
}
