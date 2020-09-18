package com.zipper.xff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/18.
 */
public class GetIPController {


    @FXML
    private Button listenButton;
    @FXML
    private TextArea showPanel;

    private Boolean hasListener;

    private Boolean show;

    private java.util.List<String> ips;

    public GetIPController() {
        this.hasListener = false;
        this.show = false;
    }

    public void switchListen(ActionEvent actionEvent) {
        show = !show;
        listenButton.setText(show ? "取消监听展示" : "添加监听展示");
        if (!hasListener) {

            StartApplication.addListener((ips) -> {
                this.ips = ips;
                showPanel.clear();
                if (show) {
                    ips.stream().forEach(i -> {
                        showPanel.appendText(i + "\n");
                    });
                }
            });
            hasListener = true;
        }
    }

    public void wfOther(ActionEvent actionEvent) {

        if (ips != null && !ips.isEmpty()) {

            java.awt.datatransfer.Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();

            StringBuilder sb = new StringBuilder();
            ips.forEach(i -> {
                sb.append(i);
                sb.append("\n");
            });
            Transferable tText = new StringSelection(sb.toString());
            sysClip.setContents(tText, null);
        }

    }
}
