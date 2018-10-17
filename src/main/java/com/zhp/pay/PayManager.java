package com.zhp.pay;

import com.zhp.pay.alipay.Alipay;
import com.zhp.pay.config.IPayConfig;
import com.zhp.pay.config.PayConfigManager;
import com.zhp.pay.wechatpay.WechatPay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 根据支付方式，调用不同的支付实现
 * @author zhp.dts
 * @date 2018/10/11.
 */
public class PayManager {
    private final static Logger log = LoggerFactory.getLogger(PayManager.class);
    private final static ConcurrentHashMap<EnumPayType,IPay> PAY_IMPL = new ConcurrentHashMap<>();


    public static IPay instance(EnumPayType payType){
        if(payType == null){
            throw new RuntimeException("payType nonsupport.");
        }
        IPay payImpl = PAY_IMPL.get(payType);
        if(payImpl == null){
            synchronized (PayManager.class){
                payImpl = PAY_IMPL.get(payType);
                if(payImpl == null){
                    payImpl = createPay(payType);
                    PAY_IMPL.put(payType,payImpl);
                }
            }
        }
        return payImpl;
    }
    private static IPay createPay(EnumPayType payType){
        IPayConfig config = PayConfigManager.getConfig(payType);
        if(config == null){
            return new DefaultPay();
        }
        //防止初始化失败，导致系统停止运行
        try {
            switch (payType) {
                case ALI_PAY:
                    return new Alipay(config);
                case WECHAT_PAY:
                    return new WechatPay(config);
                default:
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("create Pay is error : {}",e);
        }
        log.warn("{} : {} is nonsupport .",payType.getKey(),payType.getValue());
        return new DefaultPay();
    }
}
