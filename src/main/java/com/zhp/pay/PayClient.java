package com.zhp.pay;


import com.zhp.pay.req.*;
import com.zhp.pay.res.ResBase;
import com.zhp.pay.res.ResPayResult;
import com.zhp.pay.res.ResPrePayOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付主体客户端
 * @author zhp.dts
 * @date 2018/10/11.
 */
public class PayClient implements IPay{
    private final Logger log = LoggerFactory.getLogger(PayClient.class);
    public static final PayClient instance = new PayClient();
    public PayClient(){
        log.info("pay client init success");
    }

    @Override
    public ResPrePayOrder replyPrePayOrder(ReqCreatePrePay reqCreatePrePay) {
        return getClient(reqCreatePrePay).replyPrePayOrder(reqCreatePrePay);
    }

    @Override
    public ResBase cancelOrder(ReqCancelPay reqCancelPay) {
        return getClient(reqCancelPay).cancelOrder(reqCancelPay);
    }

    @Override
    public boolean validateSign(ReqValidateSign reqValidateSign) {
        return getClient(reqValidateSign).validateSign(reqValidateSign);
    }

    @Override
    public ResPayResult checkPayResult(ReqPayResult reqPayResult) {
        return getClient(reqPayResult).checkPayResult(reqPayResult);
    }

    private IPay getClient(ReqPayType reqPayType){
        return PayManager.instance(EnumPayType.getByKey(reqPayType.getPayType()));
    }
    public static PayClient instance(){
        return instance;
    }
}
