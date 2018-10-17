package com.zhp.pay.wechatpay;

/**
 * @author zhp.dts
 * @date 2018/10/17.
 */
public enum EnumWechatPayStatus {
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
    WX_PAY_STATUS_SUCCESS("SUCCESS","支付成功"),
    WX_PAY_STATUS_REFUND("REFUND","转入退款"),
    WX_PAY_STATUS_NOTPAY("NOTPAY","未支付"),
    WX_PAY_STATUS_CLOSED("CLOSED","已关闭"),
    WX_PAY_STATUS_REVOKED("REVOKED","已撤销（刷卡支付）"),
    WX_PAY_STATUS_USERPAYING("USERPAYING","用户支付中"),
    WX_PAY_STATUS_PAYERROR("PAYERROR","支付失败");

    private String key;
    private String value;
    EnumWechatPayStatus(String key, String value){
        this.key = key;
        this.value = value;
    }
    public static EnumWechatPayStatus getByKey(String key){
        for(EnumWechatPayStatus status:EnumWechatPayStatus.values()){
            if(status.key.equals(key)){
                return status;
            }
        }
        return null;
    }

}
