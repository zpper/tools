//package vodio;
//
//import javafx.application.Platform;
//import javafx.embed.swing.JFXPanel;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.SceneBuilder;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.scene.media.MediaView;
//
//import javax.swing.*;
//
//public class MyFrame extends JFrame {
//
//    /**
//     *
//     */
//    private static final long serialVersionUID = 1L;
//
//    /**
//     * Create a new Frame, set title, ...
//     */
//    public MyFrame() {
//
//        this.setTitle("Swing and JavaFX");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(1024, 768);
//
//        // create a JFXPanel
//        final JFXPanel jfxPanel = new JFXPanel();
//
//        // add the jfxPanel to the contentPane of the JFrame
//        this.getContentPane().add(jfxPanel);
//        this.setVisible(true);
//
//        Platform.runLater(new Runnable() {
//
//            @Override
//            public void run() {
//                jfxPanel.setScene(initScene());
//            }
//        });
//    }
//
//    public static final void start(String[] args) {
//        new MyFrame();
//    }
//
//    /**
//     * init the JFX Scene and
//     *
//     * @return scene
//     */
//    private Scene initScene() {
//
//        Group root = new Group();
//        SceneBuilder<?> sb = SceneBuilder.create().width(640).height(400).root(root);
//
//        //71_bbc-original-trafigura-video.flv
//        //file:///E:/home/download/4_rj-36.mp3
//
//        Media video = new Media("file:///E:/home/download/4_rj-36.mp3");
//        MediaPlayer mediaPlayer = new MediaPlayer(video);
//        mediaPlayer.setAutoPlay(true);
//        mediaPlayer.play();
//
//
//        MediaView view = new MediaView(mediaPlayer);
//
//        root.getChildren().add(view);
//
//        Scene scene = sb.build();
//
//        return scene;
//
//    }
//}