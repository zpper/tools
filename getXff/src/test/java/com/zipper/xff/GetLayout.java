package com.zipper.xff;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import org.junit.Test;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/18.
 */
public class GetLayout {

    @Test
    public void getLayout(){
        GridPane gridpane = new GridPane();
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(20);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(25);
        boolean cols = gridpane.getColumnConstraints().addAll(col1, col2, col3);
        System.out.println(gridpane.getColumnConstraints().get(1).getPrefWidth());

    }
}
