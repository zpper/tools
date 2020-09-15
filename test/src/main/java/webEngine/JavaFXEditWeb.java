//package webEngine;
//
//import java.awt.BorderLayout;
//import java.awt.Toolkit;
//
//import com.sun.webkit.dom.HTMLAppletElementImpl;
//import javafx.application.Platform;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.concurrent.Worker.State;
//import javafx.embed.swing.JFXPanel;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.scene.web.WebEngine;
//import javafx.scene.web.WebView;
//
//import javax.swing.JFrame;
//
//import org.w3c.dom.Element;
//import org.w3c.dom.html.HTMLAppletElement;
//import org.w3c.dom.html.HTMLDivElement;
//
//public class JavaFXEditWeb {
//	private static final int WIDTH = 800;
//	private static final int HEIGHT = 600;
//	private static final String url = "http://192.168.1.11";
//	private static final String urlStart = "http://";
//
//	/**
//	 * @param args
//	 */
//	public static void start(String[] args) {
//		JFrame frame = new JFrame("JavaFX in Swing Test");
//		final JFXPanel webBrowser = new JFXPanel();
//		frame.setLayout(new BorderLayout());
//		frame.add(webBrowser, BorderLayout.CENTER);
//		Platform.runLater(new Runnable() {
//
//			public void run() {
//				Group root = new Group();
//				Scene scene = new Scene(root, WIDTH, HEIGHT);
//				webBrowser.setScene(scene);
//				Double widthDouble = new Integer(WIDTH).doubleValue();
//				Double heightDouble = new Integer(HEIGHT).doubleValue();
//
//				VBox box = new VBox(10);
//				HBox urlBox = new HBox(10);
//				final TextField urlTextField = new TextField();
//				urlTextField.setText(url);
//				Button go = new Button("go");
//				urlTextField.setPrefWidth(WIDTH - 70);
//				urlBox.getChildren().addAll(urlTextField, go);
//
//				WebView view = new WebView();
//
//				view.setMinSize(widthDouble, heightDouble);
//				view.setPrefSize(widthDouble, heightDouble);
//				final WebEngine eng = view.getEngine();
//				eng.load(url);
//				root.getChildren().add(view);
//
//				box.getChildren().add(urlBox);
//				box.getChildren().add(view);
//				root.getChildren().add(box);
//
//				go.setOnAction(new EventHandler<ActionEvent>() {
//
//					public void handle(ActionEvent event) {
//						System.out.println("加载页面成功+++");
//						if (!urlTextField.getText().startsWith(urlStart)) {
//							eng.load(urlStart + urlTextField.getText());
//						} else {
//							eng.load(urlTextField.getText());
//						}
//					}
//				});
//
//				eng.getLoadWorker().stateProperty()
//						.addListener(new ChangeListener<State>() {
//
//							public void changed(
//									ObservableValue<? extends State> ov,
//									State oldState, State newState) {
//								if (newState == State.SUCCEEDED) {
//									System.out.println("succeeded");
//									//todo 获取页面待调整
//									HTMLAppletElementImpl element = (HTMLAppletElementImpl) eng.getDocument().getDocumentElement();
//									System.out.println(element.toString());
//								}
//							}
//						});
//
//			}
//		});
//
//		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
//		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
//
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(WIDTH, HEIGHT);
//		frame.setLocation((screenWidth - WIDTH) / 2,
//				(screenHeight - HEIGHT) / 2);
//		frame.setVisible(true);
//	}
//
//}
