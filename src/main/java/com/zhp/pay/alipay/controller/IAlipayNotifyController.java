package com.zhp.pay.alipay.controller;

/**
 * @author zhp.dts
 * @date 2018/10/16.
 */
public interface IAlipayNotifyController {
    /**
     * 支付宝异步通知支付成功结果
     * @param reqAliBackPrePay
     * @return
     * @link https://docs.open.alipay.com/291/106074
     */
    String alipayNotifyPayResult(ReqAliBackPrePay reqAliBackPrePay);
}
