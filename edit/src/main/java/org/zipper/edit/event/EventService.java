package org.zipper.edit.event;


import java.util.function.Function;

/**
 * 必须通过AppContextUtils获取，否则获取不到监听事件<br>
 *
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/11.
 */
public interface EventService {


    //插件的监听器，可以被系统销毁
    public void regListener(Event name, String path, ISyncSender sender);

    //插件的监听器，可以被系统销毁
    public void regFunctionListener(Event name, Function<String , Boolean> function, ISyncSender sender);

    public void addTask(TaskDTO taskDTO);

    //销毁监听器
    public void destroyEvent(Event name);
}
