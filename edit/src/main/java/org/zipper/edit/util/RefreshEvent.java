package org.zipper.edit.util;

import org.zipper.edit.event.Event;

/**
 * 刷新事件类型<br>
 *
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/30.
 */
public enum RefreshEvent implements Event {

    //刷新文档树列表
    RF_TREE,
    //刷新默认语言
    RE_LANG;
}
