package com.zhp.pay.alipay.wechatpay.controller;

/**
 * @author zhp.dts
 * @date 2018/10/12.
 */
public interface IWechatNotifyController {
    /**
     * 微信预支付订单异步返回结果通知
     * @param data
     * @return
     */
    String wechatPrepayResultCallback(String data);

    /**
     * 微信退款通知异步回调返回结果
     * @param data
     * @return
     */
    String wechatBackpayResultCallback(String data);
}
