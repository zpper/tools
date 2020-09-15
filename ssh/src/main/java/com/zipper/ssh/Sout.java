package com.zipper.ssh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/06/01.
 */
public class Sout implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(Sout.class);

    private static AtomicBoolean exit;

    private InputStream inputStream;

    public Sout(InputStream inputStream) {
        exit = new AtomicBoolean(false);
        this.inputStream = inputStream;
    }

    public void setExit() {
        exit.set(true);
    }

    public boolean getExit() {
        return exit.get();
    }

    @Override
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

        String msg = null;

        try {
            while ((msg = in.readLine()) != null) {
                exit.getAndSet(false);
                System.out.println(msg);
            }
        } catch (Exception e) {
            logger.error("【读取输出结果异常】", e);
        }

    }
}
