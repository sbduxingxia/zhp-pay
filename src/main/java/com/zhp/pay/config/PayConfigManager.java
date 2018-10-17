package com.zhp.pay.config;


import com.zhp.pay.EnumPayType;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhp.dts
 * @date 2018/10/11.
 */
public class PayConfigManager {
    private static final ConcurrentHashMap<EnumPayType,IPayConfig> PAY_CONFIG_MAP = new ConcurrentHashMap<>();
    public static void addConfig(EnumPayType payType, IPayConfig payConfig){
        if(payType == null || payConfig == null){
            throw new RuntimeException("enumPay is null Or payConfig is null.");
        }
        PAY_CONFIG_MAP.put(payType,payConfig);
    }
    public static IPayConfig getConfig(EnumPayType payType){
        if(payType == null){
            throw new RuntimeException("enumPay is null.");
        }
        return PAY_CONFIG_MAP.get(payType);
    }

}
