package com.zipper.xff;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/14.
 */
public class StartApplication extends javafx.application.Application {

    private static Consumer<List<String>> _consumer;

    public static void addListener(Consumer<List<String>> consumer) {
        if (_consumer == null) {
            _consumer = consumer;
        }
    }

    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/home.fxml"));

        stage.setTitle("获取IP");
        Scene scene = new Scene(root, 300, 275);
        addClibordListener(scene);
        stage.setScene(scene);
        stage.show();

    }


    private static void addClibordListener(Scene second) {

        EventHandler evh = new EventHandler() {
            @Override
            public void handle(Event event) {

                if ("MOUSE_ENTERED_TARGET".equals(event.getEventType().getName())) {
                    java.awt.datatransfer.Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
                    DataFlavor[] df = sysClip.getAvailableDataFlavors();
                    // 获取剪切板中的内容
                    Transferable clipTf = sysClip.getContents(null);
                    if (clipTf != null) {
                        // 检查内容是否是文本类型
                        if (clipTf.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                            try {
                                String ret = (String) clipTf.getTransferData(DataFlavor.stringFlavor);
                                if (null == ret && "".equals(ret)) {
                                    return;
                                }

                                List<String> xxfIps = new ArrayList<>();
                                Arrays.stream(ret.split("\n")).forEach(i -> {
                                    String xffIp = GetIPUtil.getXffList(i);
                                    if (xffIp != null) {
                                        xxfIps.add(xffIp);
                                    }

                                });

                                if (_consumer != null) {
                                    _consumer.accept(xxfIps);
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }


                } else if ("MOUSE_EXITED_TARGET".equals(event.getEventType().getName())) {

                }
            }
        };

        second.addEventHandler(EventType.ROOT, evh);
    }


    //---------------------------------------------------

    private static void test(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("请添加文件参数");
            return;
        }
        String path = args[0];
        if (path.contains("\\:") && path.startsWith(File.separator)) {
        } else {
            path = System.getProperty("user.dir") + File.separator + path;
        }

        File sf = new File(path);
        if (sf.isFile() && sf.exists()) {
            List<String> ips = GetIPUtil.getXffList(sf);
            ips.forEach(System.out::println);
        } else {
            System.out.println("文件不存在");
        }

    }


}