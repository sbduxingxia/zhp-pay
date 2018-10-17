package com.zhp.pay.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeCloseModel;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.*;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeCloseResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.zhp.pay.EnumPayStatus;
import com.zhp.pay.EnumPayType;
import com.zhp.pay.IPay;
import com.zhp.pay.config.IPayConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.zhp.pay.req.ReqCancelPay;
import com.zhp.pay.req.ReqCreatePrePay;
import com.zhp.pay.req.ReqPayResult;
import com.zhp.pay.req.ReqValidateSign;
import com.zhp.pay.res.ResBase;
import com.zhp.pay.res.ResPayResult;
import com.zhp.pay.res.ResPrePayOrder;
import java.math.BigDecimal;
import java.util.Map;

/**
 * 封装alipay
 * @author zhp.dts
 * @date 2018/10/11.
 */
public class Alipay  implements IPay {
    private final Logger log = LoggerFactory.getLogger(Alipay.class);
    private IPayConfig payConfig;
    private AlipayClient alipayClient;
    public Alipay(IPayConfig config){
        if(config == null){
            throw new RuntimeException("alipay`s config is null");
        }
        this.payConfig = config;
        this.alipayClient = new DefaultAlipayClient(payConfig.getActionUrl(),
                payConfig.getAppId(),
                payConfig.getAppSecret(),
                payConfig.getDataType(),
                "UTF-8",
                payConfig.getSecretKey(),
                payConfig.getSecretType());
    }
    @Override
    public ResPrePayOrder replyPrePayOrder(ReqCreatePrePay reqCreatePrePay) {
        ResPrePayOrder resPrePayOrder = new ResPrePayOrder();
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest ();
        request.setNotifyUrl(payConfig.getNotifyUrl());
        AlipayTradePayModel alipayTradePayModel = new AlipayTradePayModel();
        alipayTradePayModel.setOutTradeNo(reqCreatePrePay.getOrderCode());
        alipayTradePayModel.setBody(reqCreatePrePay.getRemark());
        alipayTradePayModel.setSubject("VPLUS购买");
        //默认超时时间2个小时
        alipayTradePayModel.setTimeoutExpress("120m");
        BigDecimal bigDecimal = new BigDecimal(reqCreatePrePay.getPayAmount());
        bigDecimal = bigDecimal.divide(new BigDecimal(100));
        alipayTradePayModel.setTotalAmount(bigDecimal.toString());
        request.setBizModel(alipayTradePayModel);
        try {
            log.info("alipay create order REQ: {}" ,JSON.toJSONString(alipayTradePayModel));
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            log.info("alipay create order RES: {}",JSON.toJSONString(response));
            if(response.isSuccess()){
                resPrePayOrder.setSuccess(true);
                resPrePayOrder.setPrePayCode(response.getTradeNo());
                resPrePayOrder.setRequestParamString(response.getBody());
            }else{
                resPrePayOrder.setSuccess(false);
                resPrePayOrder.setStatusCode(response.getCode());
                resPrePayOrder.setStatusMessage(response.getSubMsg());
                resPrePayOrder.setStoreResult(response.getBody());
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
            log.error("alipay create order is error : {}" ,e);
            resPrePayOrder.setSuccess(false);
            resPrePayOrder.setStatusMessage(e.getMessage());
        }
        return resPrePayOrder;
    }

    @Override
    public ResBase cancelOrder(ReqCancelPay reqCancelPay) {
        ResPrePayOrder resPrePayOrder = new ResPrePayOrder();
        AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
        AlipayTradeCloseModel alipayTradeCloseModel = new AlipayTradeCloseModel();
        alipayTradeCloseModel.setOutTradeNo(reqCancelPay.getOrderCode());
        alipayTradeCloseModel.setOperatorId(reqCancelPay.getOperatorId());
        request.setBizModel(alipayTradeCloseModel);
        try {
            log.info("alipay cancel order REQ: {}" , JSON.toJSON(alipayTradeCloseModel));
            AlipayTradeCloseResponse alipayTradeCloseResponse = alipayClient.execute(request);
            log.info("alipay cancel order RES: {}" ,JSON.toJSON(alipayTradeCloseResponse));
            if(alipayTradeCloseResponse.isSuccess()){
                resPrePayOrder.setSuccess(true);
            }else{
                resPrePayOrder.setSuccess(false);
                resPrePayOrder.setStatusCode(alipayTradeCloseResponse.getCode());
                resPrePayOrder.setStatusMessage(alipayTradeCloseResponse.getSubMsg());
                resPrePayOrder.setStoreResult(alipayTradeCloseResponse.getBody());
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
            log.error("alipay create order is error : {}" ,e);
            resPrePayOrder.setSuccess(false);
            resPrePayOrder.setStatusMessage(e.getMessage());
        }
        return resPrePayOrder;
    }

    @Override
    public boolean validateSign(ReqValidateSign reqValidateSign) {
        try{
            Map<String,String> param = JSON.parseObject(reqValidateSign.getData().toString(),Map.class);
            return AlipaySignature.rsaCheckV1(param, payConfig.getSecretKey(), "UTF-8", payConfig.getSecretType());
        }catch (Exception e){
            e.printStackTrace();
            log.error("validata sign error : {}" , e);
        }
        return false;
    }

    @Override
    public ResPayResult checkPayResult(ReqPayResult reqPayResult) {
        ResPayResult resPayResult = new ResPayResult();
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        AlipayTradeQueryModel model = new AlipayTradeQueryModel();
        model.setOutTradeNo(reqPayResult.getOrderCode());
        model.setTradeNo(reqPayResult.getPayStoreCode());
        request.setBizModel(model);
        try {
            AlipayTradeQueryResponse response = alipayClient.execute(request);
            if(response.isSuccess()){
                resPayResult.setSuccess(true);
                EnumPayStatus status = EnumPayStatus.parse(EnumPayType.ALI_PAY,response.getTradeStatus());
                resPayResult.setPayStatus(status.getKey());
                resPayResult.setPayStatusDesc(status.getValue());
                resPayResult.setPayed(EnumPayStatus.PAY_STATUS_SUCCESS.equals(status));
            }else{
                resPayResult.setSuccess(false);
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
            log.error("alipay check order is error : {}" ,e);
            resPayResult.setSuccess(false);
            resPayResult.setStatusMessage(e.getMessage());
        }
        return resPayResult;
    }
}
