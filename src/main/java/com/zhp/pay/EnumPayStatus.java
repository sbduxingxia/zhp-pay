package com.zhp.pay;


import com.zhp.pay.alipay.EnumAliPayStatus;
import com.zhp.pay.wechatpay.EnumWechatPayStatus;

/**
 * @author zhp.dts
 * @date 2018/10/17.
 */
public enum EnumPayStatus {
    /**
     * wechat
     * SUCCESS—支付成功
     *
     * REFUND—转入退款
     *
     * NOTPAY—未支付
     *
     * CLOSED—已关闭
     *
     * REVOKED—已撤销（刷卡支付）
     *
     * USERPAYING--用户支付中
     *
     * PAYERROR--支付失败(其他原因，如银行返回失败)
     **/
    PAY_STATUS_SUCCESS("SUCCESS","支付成功"),
    PAY_STATUS_CLOSED("CLOSED","已关闭"),
    PAY_STATUS_NOTPAY("NOTPAY","未支付"),
    PAY_STATUS_PAYERROR("PAYERROR","支付失败"),
    PAY_STATUS_NOT_DEFINDED("NOT_DEFINDED","状态未定义");

    private String key;
    private String value;
    EnumPayStatus(String key, String value){
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

    public static EnumPayStatus getByKey(String key){
        for(EnumPayStatus status:EnumPayStatus.values()){
            if(status.key.equals(key)){
                return status;
            }
        }
        return null;
    }
    public static EnumPayStatus parse(EnumPayType enumPayType,String status){
        switch (enumPayType){
            case WECHAT_PAY:

                return wechatTrans(status);
            case ALI_PAY:
                return aliTrans(status);
        }
        return PAY_STATUS_NOT_DEFINDED;
    }
    private static EnumPayStatus wechatTrans(String statusString){
        EnumWechatPayStatus status = EnumWechatPayStatus.getByKey(statusString);
        if(status == null){
            return PAY_STATUS_NOT_DEFINDED;
        }
        switch (status){
            case WX_PAY_STATUS_SUCCESS:
                return PAY_STATUS_SUCCESS;
            case WX_PAY_STATUS_CLOSED:
                return PAY_STATUS_CLOSED;
            case WX_PAY_STATUS_NOTPAY:
                return PAY_STATUS_NOTPAY;
            case WX_PAY_STATUS_PAYERROR:
                return PAY_STATUS_PAYERROR;
            case WX_PAY_STATUS_REFUND:
            case WX_PAY_STATUS_REVOKED:
            case WX_PAY_STATUS_USERPAYING:

                break;
                default:

        }
        return PAY_STATUS_NOT_DEFINDED;
    }

    private static EnumPayStatus aliTrans(String statusString){
        EnumAliPayStatus status = EnumAliPayStatus.getByKey(statusString);
        if(status == null){
            return PAY_STATUS_NOT_DEFINDED;
        }
        switch (status){
            case ALI_PAY_STATUS_TRADE_FINISHED:
            case ALI_PAY_STATUS_TRADE_SUCCESS:
                return PAY_STATUS_SUCCESS;
            case ALI_PAY_STATUS_TRADE_CLOSED:
                return PAY_STATUS_CLOSED;
            case ALI_PAY_STATUS_WAIT_BUYER_PAY:
                return PAY_STATUS_NOTPAY;
            default:

        }
        return PAY_STATUS_NOT_DEFINDED;
    }
}
