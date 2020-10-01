package org.zipper.edit.util;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/08/22.
 */
public class S {

    /**
     * @return 是否为空
     */
    public static boolean isEmpty(String str) {
        return null == str || "".equals(str.trim());
    }

    /**
     * @return 是否包含空格
     */
    public static boolean hasEmpty(String... strs) {
        boolean empty = false;
        if (strs != null && strs.length > 0) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] == null || "".equals(strs[i].trim())) {
                    empty = true;
                }
            }
        } else {
            empty = true;
        }
        return empty;
    }
}
