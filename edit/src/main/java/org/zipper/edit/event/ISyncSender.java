package org.zipper.edit.event;


/**
 * 管理中心和终端事件消息的传输方法。
 *
 * @author peng0806@foxmail.com <br>
 * Date: 2020/08/18.
 */
@FunctionalInterface
public interface ISyncSender {


    void sendEvent(TaskDTO taskDTO);

}
