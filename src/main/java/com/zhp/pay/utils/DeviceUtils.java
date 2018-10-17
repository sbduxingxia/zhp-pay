package com.zhp.pay.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author zhp.dts
 * @date 2018/10/12.
 */
public class DeviceUtils {
    public static String getHostIp(){
        try {
            return InetAddress.getLocalHost().getHostAddress().toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "0.0.0.0";
    }
}
