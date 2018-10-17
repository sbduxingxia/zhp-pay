package com.zhp.pay;

import com.zhp.pay.config.IPayConfig;
import com.zhp.pay.config.PayConfigManager;

/**
 * @author zhp.dts
 * @date 2018/10/17.
 */
public class StartMain {
    public static void main(String [] args){
        PayConfigManager.addConfig(EnumPayType.WECHAT_PAY,new WechatPayConfig());
    }
    private static class WechatPayConfig implements IPayConfig{

        @Override
        public String getPayType() {
            return null;
        }

        @Override
        public String getAppId() {
            return null;
        }

        @Override
        public String getAppSecret() {
            return null;
        }

        @Override
        public String getSecretType() {
            return null;
        }

        @Override
        public String getDataType() {
            return null;
        }

        @Override
        public String getSecretKey() {
            return null;
        }

        @Override
        public String getPayStoreId() {
            return null;
        }

        @Override
        public String getNotifyUrl() {
            return null;
        }

        @Override
        public String getActionUrl() {
            return null;
        }
    }
}
