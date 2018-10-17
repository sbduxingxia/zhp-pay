package com.zhp.pay.alipay;


/**
 * @author zhp.dts
 * @date 2018/10/17.
 */
public enum EnumAliPayStatus {

    /**
     * ali
     * 	交易状态：WAIT_BUYER_PAY（交易创建，等待买家付款）、TRADE_CLOSED（未付款交易超时关闭，或支付完成后全额退款）、TRADE_SUCCESS（交易支付成功）、TRADE_FINISHED（交易结束，不可退款）
     */
    ALI_PAY_STATUS_TRADE_SUCCESS("TRADE_SUCCESS","支付成功"),
    ALI_PAY_STATUS_TRADE_FINISHED("TRADE_FINISHED","交易结束"),
    ALI_PAY_STATUS_TRADE_CLOSED("TRADE_CLOSED","已关闭"),
    ALI_PAY_STATUS_WAIT_BUYER_PAY("WAIT_BUYER_PAY","用户支付中");
    private String key;
    private String value;
    EnumAliPayStatus(String key, String value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static EnumAliPayStatus getByKey(String key){
        for(EnumAliPayStatus status:EnumAliPayStatus.values()){
            if(status.key.equals(key)){
                return status;
            }
        }
        return null;
    }
}
