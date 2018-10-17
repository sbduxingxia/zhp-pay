package com.zhp.pay;

/**
 * @author zhp.dts
 * @date 2018/10/11.
 */
public enum EnumWechatCode {
    WECHAT_NOAUTH("NOAUTH","商户无此接口权限"),
    WECHAT_NOTENOUGH("NOTENOUGH","余额不足"),
    WECHAT_ORDERPAID("ORDERPAID","商户订单已支付"),
    WECHAT_ORDERCLOSED("ORDERCLOSED","订单已关闭"),
    WECHAT_SYSTEMERROR("SYSTEMERROR","系统错误"),
    WECHAT_APPID_NOT_EXIST("APPID_NOT_EXIST","APPID不存在"),
    WECHAT_MCHID_NOT_EXIST("MCHID_NOT_EXIST","MCHID不存在"),
    WECHAT_APPID_MCHID_NOT_MATCH("APPID_MCHID_NOT_MATCH","appid和mch_id不匹配"),
    WECHAT_LACK_PARAMS("LACK_PARAMS","缺少参数"),
    WECHAT_OUT_TRADE_NO_USED("OUT_TRADE_NO_USED","商户订单号重复"),
    WECHAT_SIGNERROR("SIGNERROR","签名错误"),
    WECHAT_XML_FORMAT_ERROR("XML_FORMAT_ERROR","XML格式错误"),
    WECHAT_REQUIRE_POST_METHOD("REQUIRE_POST_METHOD","请使用post方法"),
    WECHAT_POST_DATA_EMPTY("POST_DATA_EMPTY","post数据为空"),
    WECHAT_NOT_UTF8("NOT_UTF8","编码格式错误");
    private String key;
    private String value;
    EnumWechatCode(String key,String value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public String getNameByCode(String code){
        for(EnumWechatCode enumWechatCode:EnumWechatCode.values()){
            if(enumWechatCode.getKey().equals(code)){
                return enumWechatCode.getValue();
            }
        }
        return null;
    }
}
