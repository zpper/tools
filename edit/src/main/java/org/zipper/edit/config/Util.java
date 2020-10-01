package org.zipper.edit.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zipper.edit.iface.TypeTransformer;
import org.zipper.edit.util.S;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/29.
 */
public class Util {

    private static final Logger logger = LoggerFactory.getLogger(Util.class);

    private static ConcurrentHashMap<String, String> settings;
    //类名称，转换器
    private static Map<String, TypeTransformer> transformers;

    static {
        settings = new ConcurrentHashMap<>();
        transformers = new TreeMap<>();
    }

    public static void putTransform(TypeTransformer transformer) {
        //TODO 暂时碰到问题
        Type superClass = TypeTransformer.class.getGenericSuperclass();
        Type type = ((ParameterizedType) superClass).getActualTypeArguments()[0];

        if (type instanceof ParameterizedType) {
            Class classType = (Class) ((ParameterizedType) type).getRawType();
            transformers.put(classType.getName(), transformer);
        }

    }


    @SuppressWarnings("unchecked")
    public static <T> T getValue(String key, Class<T> clazz) {

        String value = settings.get(key);

        if (!S.isEmpty(value) && value.getClass().getName().equals(clazz.getName())) {

            T res = null;

            try {

                TypeTransformer<T> transformer = transformers.get(value.getClass().getName());

                if (transformer != null) {
                    res = (T) transformer.decoder(value);
                } else {
                    res = (T) value;
                }
            } catch (ClassCastException e) {

                logger.error("类型不匹配", new RuntimeException());

            }

            return res;
        } else {

            return null;
        }
    }

    public static String getStringValue(String key) {

        if (settings.get(key) == null) {

            return null;
        } else {

            return settings.get(key).toString();
        }

    }


    public void put(String key, Object value) {

    }


}
