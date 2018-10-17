package com.zhp.pay;


import com.zhp.pay.req.ReqCancelPay;
import com.zhp.pay.req.ReqCreatePrePay;
import com.zhp.pay.req.ReqPayResult;
import com.zhp.pay.req.ReqValidateSign;
import com.zhp.pay.res.ResBase;
import com.zhp.pay.res.ResPayResult;
import com.zhp.pay.res.ResPrePayOrder;

/**
 * 支付控制接口
 * @author zhp.dts
 * @date 2018/10/11.
 */
public interface IPay {
    /**
     * 申请创建预付款订单，支付平台返回预付款订单单号或流水号
     * @param reqCreatePrePay
     * @return
     */
    ResPrePayOrder replyPrePayOrder(ReqCreatePrePay reqCreatePrePay);

    ResBase cancelOrder(ReqCancelPay reqCancelPay);

    boolean validateSign(ReqValidateSign reqValidateSign);

    ResPayResult checkPayResult(ReqPayResult reqPayResult);

//    String requestPayParam(ReqPayParam4H5 reqPayParam4H5);
}
