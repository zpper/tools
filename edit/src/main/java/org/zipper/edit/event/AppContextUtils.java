package org.zipper.edit.event;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 配置服务获取<br>
 */
public class AppContextUtils {

    private static Logger logger = LoggerFactory.getLogger(AppContextUtils.class);
    //唯一的
    private static EventService eventService;

    static {
        ServiceLoader<EventService> ts = ServiceLoader.load(EventService.class);
        for (final Iterator<EventService> iter = ts.iterator(); iter.hasNext(); ) {
            eventService = iter.next();
            break;
        }
    }

    /**
     * 加载所有符合条件的实现类
     */
    public static <T> Iterable<T> getBeans(Class<T> clazz) {

        ServiceLoader<T> ts = ServiceLoader.load(clazz);
        return ts;
    }

    /**
     * 仅加载一个符合条件的实现类，如果有多个则跳过
     */
    public static <T> T getBean(Class<T> clazz) {

        T res = null;

        if (clazz.equals(EventService.class) && eventService != null) {

            res = (T) eventService;

        } else if (eventService == null) {
            logger.error("需要静态初始化事件管理器");
        } else {

            ServiceLoader<T> ts = ServiceLoader.load(clazz);
            for (final Iterator<T> iter = ts.iterator(); iter.hasNext(); ) {
                res = iter.next();
                break;
            }
        }

        return res;
    }

}
