package com.zhp.pay;


import com.zhp.pay.req.ReqCancelPay;
import com.zhp.pay.req.ReqCreatePrePay;
import com.zhp.pay.req.ReqPayResult;
import com.zhp.pay.req.ReqValidateSign;
import com.zhp.pay.res.ResBase;
import com.zhp.pay.res.ResPayResult;
import com.zhp.pay.res.ResPrePayOrder;

/**
 * @author zhp.dts
 * @date 2018/10/11.
 */
public class DefaultPay implements IPay {
    @Override
    public ResPrePayOrder replyPrePayOrder(ReqCreatePrePay reqCreatePrePay) {
        return null;
    }

    @Override
    public ResBase cancelOrder(ReqCancelPay reqCancelPay) {
        return null;
    }

    @Override
    public boolean validateSign(ReqValidateSign reqValidateSign) {
        return false;
    }

    @Override
    public ResPayResult checkPayResult(ReqPayResult reqPayResult) {
        return null;
    }
}
