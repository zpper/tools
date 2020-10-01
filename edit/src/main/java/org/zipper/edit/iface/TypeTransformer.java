package org.zipper.edit.iface;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/29.
 */
public interface TypeTransformer<T> {


    String encoder(T t);

    T decoder(String str);
}
