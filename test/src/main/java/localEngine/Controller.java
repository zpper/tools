package localEngine;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Controller  implements Initializable {


    @FXML
    private WebView webView;

    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

        final WebEngine webengine = webView.getEngine();
        String url = Main.class.getResource("/local/index.html").toExternalForm();
        webengine.load(url);
    }
}
