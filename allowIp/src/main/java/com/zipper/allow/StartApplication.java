package com.zipper.allow;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/14.
 */
public class StartApplication extends javafx.application.Application {

    public static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml_example.fxml"));

        stage.setTitle("登陆");
        Scene sence = new Scene(root, 300, 275);

        stage.setScene(sence);
        StartApplication.stage = stage;

        stage.show();
    }

    public static void onSwitch() throws IOException {

        Parent root = FXMLLoader.load(StartApplication.class.getResource("/Second.fxml"));

        StartApplication.stage.setTitle("判断是否为白名单");
        Scene second = new Scene(root, 300, 275);

        addClibordListener(second);

        StartApplication.stage.setScene(second);
        StartApplication.stage.show();
    }

    private static Consumer<String> _consumer;

    public static void addListener(Consumer<String> consumer) {
        if (_consumer == null) {
            _consumer = consumer;
        }
    }

    private static void addClibordListener(Scene second) {

        EventHandler evh = new EventHandler() {
            @Override
            public void handle(Event event) {

                if ("MOUSE_ENTERED_TARGET".equals(event.getEventType().getName())) {
                    if (_consumer != null) {
                        _consumer.accept(getSysClipBoardText());
                    }
                } else if ("MOUSE_EXITED_TARGET".equals(event.getEventType().getName())) {

                }
            }
        };

        second.addEventHandler(EventType.ROOT, evh);
    }

    public static String getSysClipBoardText() {
        String ret = "";
        java.awt.datatransfer.Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 获取剪切板中的内容
        Transferable clipTf = sysClip.getContents(null);
        if (clipTf != null) {
            // 检查内容是否是文本类型
            if (clipTf.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                try {
                    ret = (String) clipTf.getTransferData(DataFlavor.stringFlavor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }
}