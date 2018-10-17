package com.zhp.pay.res;

/**
 * @author zhp.dts
 * @date 2018/10/17.
 */
public class ResPayResult extends ResBase{
    private boolean isPayed;
    private String payStatus;
    private String payStatusDesc;

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayStatusDesc() {
        return payStatusDesc;
    }

    public void setPayStatusDesc(String payStatusDesc) {
        this.payStatusDesc = payStatusDesc;
    }
}
