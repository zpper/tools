package org.zipper.edit.event;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.zipper.edit.util.S;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * 进行消息的共享和传递 <br>
 *
 * @author peng0806@foxmail.com <br>
 * Date: 2020/08/31.
 */
public final class EventServiceImpl implements EventService {

    private static final Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);

    private Set<Event> events;

    //私有化构造器
    public EventServiceImpl() {

        funListenerMap = new ConcurrentHashMap<>();

        events = new HashSet<>();
    }


    //模式匹配监听器
    private ConcurrentHashMap<Function<String, Boolean>, ISyncSender> funListenerMap;


    @Override
    public void regListener(Event name, String path, ISyncSender sender) {
        if (S.isEmpty(path)) {
            logger.info("注册的监听器不能为空");
            return;
        }
        regFunctionListener(name, (s) -> {
            return s.equals(path);
        }, sender);
    }

    @Override
    public void regFunctionListener(Event name, Function<String, Boolean> function, ISyncSender sender) {
        if (!events.contains(name)) {
            events.add(name);
        } else {
            logger.error("事件{}已经存在", name);
        }
        funListenerMap.put(function, sender);
    }

    //发送消息
    @Override
    public void addTask(TaskDTO taskDTO) {

        if (S.isEmpty(taskDTO.getPath())) {
            logger.error("taskDTO 的path不能为空");
            return;
        }

        funListenerMap.entrySet().forEach(entry -> {

            if (entry.getKey().apply(taskDTO.getPath())) {

                final ISyncSender sender = entry.getValue();
                if (sender == null) {
                    logger.error("{}未获取到监听器", taskDTO.getPath());
                    return;
                }

                try {
                    sender.sendEvent(taskDTO);
                } catch (Exception e) {
                    logger.error("发送{}失败", taskDTO.getPath(), new RuntimeException());
                }
            }
        });
    }

    @Override
    public void destroyEvent(final Event name) {
        if (events.contains(name)) {
            logger.info("TODO 销毁{}监听器", name);
        } else {
            logger.info("事件{}未注册", name);
        }
    }

}
