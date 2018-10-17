package com.zhp.pay.utils;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author zhp.dts
 * @date 2018/10/11.
 */
public class XmlUtils {
    public static String toXML(Object obj) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.FALSE);
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            return writer.toString().replaceFirst(" standalone=\"yes\"", "");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param obj
     * @param fragment 是否去掉xml头信息
     * @return
     */
    public static String toXML(Object obj,boolean fragment) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式

            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, fragment);
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            return writer.toString().replaceFirst(" standalone=\"yes\"", "");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @SuppressWarnings("unchecked")
    public static <T> T fromXML(String xml, Class<T> valueType) {
        try {
            JAXBContext context = JAXBContext.newInstance(valueType);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
