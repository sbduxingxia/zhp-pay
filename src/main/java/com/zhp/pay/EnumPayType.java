package com.zhp.pay;

import java.io.Serializable;

/**
 * @author zhp.dts
 * @date 2018/10/11.
 */
public enum EnumPayType implements Serializable {
    DEFAULT_PAY("0","空支付类型"),
    WECHAT_PAY("1","微信支付"),
    ALI_PAY("2","支付宝支付");
    private String key;
    private String value;
    EnumPayType(String key, String value){
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
    public static EnumPayType getByKey(String key){
        for(EnumPayType pay: EnumPayType.values()){
            if(pay.getKey().equals(key)){
                return pay;
            }
        }
        return null;
    }

}
