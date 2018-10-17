package com.zhp.pay.wechatpay;

import com.alipay.api.internal.util.StringUtils;
import com.github.wxpay.sdk.WXPayUtil;
import com.zhp.pay.EnumPayStatus;
import com.zhp.pay.EnumPayType;
import com.zhp.pay.IPay;
import com.zhp.pay.config.IPayConfig;
import com.zhp.pay.req.ReqCancelPay;
import com.zhp.pay.req.ReqCreatePrePay;
import com.zhp.pay.req.ReqPayResult;
import com.zhp.pay.req.ReqValidateSign;
import com.zhp.pay.res.ResBase;
import com.zhp.pay.res.ResPayResult;
import com.zhp.pay.res.ResPrePayOrder;
import com.zhp.pay.utils.DeviceUtils;
import com.zhp.pay.utils.HttpUtils;
import com.zhp.pay.utils.XmlUtils;
import com.zhp.pay.wechatpay.req.ReqWxCancelPay;
import com.zhp.pay.wechatpay.req.ReqWxCheckPay;
import com.zhp.pay.wechatpay.req.ReqWxH5Pay;
import com.zhp.pay.wechatpay.req.ReqWxPrePay;
import com.zhp.pay.wechatpay.res.ResWxBase;
import com.zhp.pay.wechatpay.res.ResWxCheckPay;
import com.zhp.pay.wechatpay.res.ResWxPrePay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


/**
 * @author zhp.dts
 * @date 2018/10/11.
 */
public class WechatPay implements IPay {
    private final Logger log = LoggerFactory.getLogger(WechatPay.class);
    private IPayConfig payConfig;
    public WechatPay(IPayConfig config){
        if(config == null){
            throw new RuntimeException("wechatpay`s config is null");
        }
        this.payConfig = config;
    }
    @Override
    public ResPrePayOrder replyPrePayOrder(ReqCreatePrePay reqCreatePrePay) {
        ResPrePayOrder resPrePayOrder = new ResPrePayOrder();

        ReqWxPrePay reqWxPrePay = new ReqWxPrePay();
        reqWxPrePay.initBase(payConfig);
        reqWxPrePay.setNotifyUrl(payConfig.getNotifyUrl());
        reqWxPrePay.setTradeType(payConfig.getPayType());

        reqWxPrePay.setBody(reqCreatePrePay.getRemark());
        reqWxPrePay.setOutTradeNo(reqCreatePrePay.getOrderCode());
        reqWxPrePay.setTotalFee(reqCreatePrePay.getPayAmount());
        reqWxPrePay.setSpbillCreateIp(DeviceUtils.getHostIp());

        try {
            String xmlStr = XmlUtils.toXML(reqWxPrePay,true);
            reqWxPrePay.setSign(WXPayUtil.generateSignature(WXPayUtil.xmlToMap(xmlStr),payConfig.getSecretKey()));
            xmlStr = XmlUtils.toXML(reqWxPrePay,true);
            log.info("[wechat pay create REQ] : {}", xmlStr);
            String resultStr = HttpUtils.httpRequest(payConfig.getActionUrl()+WechatContant.CREATE_ORDER,"POST",xmlStr);
            log.info("[wechat pay create RES] : {}", resultStr);
            if(StringUtils.isEmpty(resultStr)){
                resPrePayOrder.setStatusCode("");
                resPrePayOrder.setStatusMessage("请求异常");
                resPrePayOrder.setSuccess(false);
            }else{
                ResWxPrePay resWxPrePay = XmlUtils.fromXML(resultStr,ResWxPrePay.class);
                if(resWxPrePay.getReturnCode().equals(WechatContant.SUCCESS)){
                    resPrePayOrder.setStatusCode(resWxPrePay.getResultCode());
                    if(resWxPrePay.getResultCode().equals(WechatContant.SUCCESS)){
                        resPrePayOrder.setSuccess(true);
                        resPrePayOrder.setStatusMessage(resWxPrePay.getReturnMsg());
                        resPrePayOrder.setPrePayCode(resWxPrePay.getPrepayId());
                        resPrePayOrder.setTradeType(resWxPrePay.getTradeType());
                        resPrePayOrder.setRequestParamString(requestPayParam(resWxPrePay.getPrepayId()));
                    }else{
                        resPrePayOrder.setSuccess(false);
                        resPrePayOrder.setStatusCode(resWxPrePay.getErrCode());
                        resPrePayOrder.setStatusMessage(resWxPrePay.getErrCode()+" : "+resWxPrePay.getErrCodeDes());
                    }
                }else{
                    resPrePayOrder.setSuccess(false);
                    resPrePayOrder.setStatusMessage(resWxPrePay.getReturnMsg());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("sign error : {}",e);
        }
        return resPrePayOrder;
    }

    @Override
    public ResBase cancelOrder(ReqCancelPay reqCancelPay) {
        ReqWxCancelPay reqWxCancelPay = new ReqWxCancelPay();
        reqWxCancelPay.setOutTradeNo(reqCancelPay.getOrderCode());
        reqWxCancelPay.initBase(payConfig);
        String xmlStr = XmlUtils.toXML(reqWxCancelPay,true);
        ResBase resBase = new ResBase();
        try {
            reqWxCancelPay.setSign(WXPayUtil.generateSignature(WXPayUtil.xmlToMap(xmlStr),payConfig.getSecretKey()));
            xmlStr = XmlUtils.toXML(reqWxCancelPay,true);
            log.info("[wechat pay cancel REQ] : {}", xmlStr);
            String resultStr = HttpUtils.httpRequest(payConfig.getActionUrl()+WechatContant.CANCEL_ORDER,"POST",xmlStr);
            log.info("[wechat pay cancel RES] : {}", resultStr);
            if(StringUtils.isEmpty(resultStr)){
                resBase.setStatusCode("");
                resBase.setStatusMessage("请求异常");
                resBase.setSuccess(false);
            }else{
                ResWxBase resWxBase = XmlUtils.fromXML(resultStr,ResWxBase.class);
                if(resWxBase.getReturnCode().equals(WechatContant.SUCCESS)){
                    resBase.setStatusCode(resWxBase.getResultCode());
                    if(resWxBase.getResultCode().equals(WechatContant.SUCCESS)){
                        resBase.setSuccess(true);
                        resBase.setStatusMessage(resWxBase.getReturnMsg());

                    }else{
                        resBase.setSuccess(false);
                        resBase.setStatusCode(resWxBase.getErrCode());
                        resBase.setStatusMessage(resWxBase.getErrCode()+" : "+resWxBase.getErrCodeDes());
                    }
                }else{
                    resBase.setSuccess(false);
                    resBase.setStatusMessage(resWxBase.getReturnMsg());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("cancel error : {}",e);
        }
        return resBase;
    }

    @Override
    public boolean validateSign(ReqValidateSign reqValidateSign) {
        try {
            if(WXPayUtil.isSignatureValid(reqValidateSign.getData().toString(),payConfig.getSecretKey())){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String requestPayParam(String tradeNo) {
        ReqWxH5Pay reqWxH5Pay = new ReqWxH5Pay();
        reqWxH5Pay.initBase(payConfig);
        reqWxH5Pay.setPrepayId(tradeNo);
        try {
            Map<String,String> dataParam = WXPayUtil.xmlToMap(XmlUtils.toXML(reqWxH5Pay,true));
            String sign = WXPayUtil.generateSignature(dataParam,payConfig.getSecretKey());
            reqWxH5Pay.setPaySign(sign);
            return reqWxH5Pay.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("wechat h5 pay param : {}",e);
        }
        return null;
    }

    @Override
    public ResPayResult checkPayResult(ReqPayResult reqPayResult) {
        ReqWxCheckPay reqWxCheckPay = new ReqWxCheckPay();
        reqWxCheckPay.setOutTradeNo(reqPayResult.getOrderCode());
        reqWxCheckPay.setTransactionId(reqPayResult.getPayStoreCode());
        reqWxCheckPay.initBase(payConfig);
        String xmlStr = XmlUtils.toXML(reqWxCheckPay,true);
        ResPayResult resPayResult = new ResPayResult();
        try {
            reqWxCheckPay.setSign(WXPayUtil.generateSignature(WXPayUtil.xmlToMap(xmlStr),payConfig.getSecretKey()));
            xmlStr = XmlUtils.toXML(reqWxCheckPay,true);
            log.info("[wechat pay result REQ] : {}", xmlStr);
            String resultStr = HttpUtils.httpRequest(payConfig.getActionUrl()+WechatContant.QUERY_ORDER,"POST",xmlStr);
            log.info("[wechat pay result RES] : {}", resultStr);
            if(StringUtils.isEmpty(resultStr)){
                resPayResult.setStatusCode("");
                resPayResult.setStatusMessage("请求异常");
                resPayResult.setSuccess(false);
            }else{
                ResWxCheckPay resWxCheckPay = XmlUtils.fromXML(resultStr,ResWxCheckPay.class);
                if(resWxCheckPay.getReturnCode().equals(WechatContant.SUCCESS)){
                    resPayResult.setStatusCode(resWxCheckPay.getResultCode());
                    if(resWxCheckPay.getResultCode().equals(WechatContant.SUCCESS)){
                        resPayResult.setSuccess(true);
                        resPayResult.setStatusMessage(resWxCheckPay.getReturnMsg());
                        EnumPayStatus status = EnumPayStatus.parse(EnumPayType.WECHAT_PAY,resWxCheckPay.getTradeStatus());
                        resPayResult.setPayStatus(status.getKey());
                        resPayResult.setPayStatusDesc(status.getValue());
                        resPayResult.setPayed(EnumPayStatus.PAY_STATUS_SUCCESS.equals(status));
                    }else{
                        resPayResult.setSuccess(false);
                        resPayResult.setStatusCode(resWxCheckPay.getErrCode());
                        resPayResult.setStatusMessage(resWxCheckPay.getErrCode()+" : "+resWxCheckPay.getErrCodeDes());
                    }
                }else{
                    resPayResult.setSuccess(false);
                    resPayResult.setStatusMessage(resWxCheckPay.getReturnMsg());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("cancel error : {}",e);
        }
        return resPayResult;
    }
}
