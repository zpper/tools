package localEngine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 通过加载本地文件渲染,可以加载html,todo js 无效待查看
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/local/local.fxml"));
        primaryStage.setTitle("JAVAFX嵌入html测试");
        primaryStage.setScene(new Scene(root, 1270, 860));
        primaryStage.show();
    }


    public static void start(String[] args) {
        launch(args);
    }
}
