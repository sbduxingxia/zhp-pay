package com.zhp.pay.config;


/**
 * @author zhp.dts
 * @date 2018/10/11.
 */
public interface IPayConfig {
    String getPayType();
    String getAppId();
    String getAppSecret();
    String getSecretType();
    String getDataType();
    //加密字段
    String getSecretKey();
    String getPayStoreId();
    String getNotifyUrl();
    String getActionUrl();
}
