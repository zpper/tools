package org.zipper.edit.ctrl;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Screen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zipper.edit.config.AppConfig;
import org.zipper.edit.event.AppContextUtils;
import org.zipper.edit.event.EventService;
import org.zipper.edit.event.TaskDTO;
import org.zipper.edit.util.RefreshEvent;
import org.zipper.edit.util.S;

import java.io.File;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);


    @FXML
    private SplitPane funPane;

    @FXML
    private SplitPane splitPane;

    @FXML
    private Menu i18n;

    //文档树
    private TreeView<String> docTree;

    private static EventService es = AppContextUtils.getBean(EventService.class);

    //初始化监听器
    @Override
    public void initialize(URL location, ResourceBundle resources) {

//     TODO 暂时只支持中英两种语言   Locale[] locales = Locale.getAvailableLocales();

        Locale[] locales = new Locale[]{Locale.CHINA, Locale.ENGLISH};

        ToggleGroup tg = new ToggleGroup();

        es.regListener(RefreshEvent.RE_LANG, RefreshEvent.RE_LANG.name(), dto -> {
            Locale locale = dto.getDataValue(Locale.class);
            //TODO 添加刷新的方法


            initDocTree(splitPane);
        });

        for (int i = 0; i < locales.length; i++) {

            Locale locale = locales[i];

            if (!S.isEmpty(locale.getDisplayLanguage())) {

                RadioMenuItem mi = new RadioMenuItem();

                if (locale.getDisplayLanguage().equals(Locale.getDefault().getDisplayLanguage())) {

                    mi.setSelected(true);
                } else {

                    mi.setSelected(false);
                }

                mi.setText(locale.getDisplayLanguage(locale));
                mi.setToggleGroup(tg);
                mi.setOnAction(event -> {
                    RadioMenuItem _mi = (RadioMenuItem) event.getSource();
                    for (int i1 = 0; i1 < locales.length; i1++) {
                        if (_mi.getText().equals(locales[i1].getDisplayLanguage(locales[i1]))) {
                            //　语言切换
                            AppConfig.setLocale(locales[i1]);


                            TaskDTO td = new TaskDTO();
                            td.setData(locales[i1]);
                            td.setPath(RefreshEvent.RE_LANG.name());
                            es.addTask(td);
                            break;
                        }

                    }

                });

                i18n.getItems().add(mi);

            }

        }

        splitPane.setPrefHeight(Screen.getPrimary().getBounds().getHeight() / 2);

        initDocTree(splitPane);


    }

    /**
     * @param splitPane 主面板
     */
    private void initDocTree(SplitPane splitPane) {
       
        File rootFile = AppConfig.docSvr.getCurrentDoc();
        docTree = new TreeView<>();
        //树型添加鼠标点击事件
        docTree.onMouseClickedProperty().set(event -> {
            System.out.println(event.getEventType());
        });


        es.regListener(RefreshEvent.RF_TREE, "rf_tree", dto -> {

            File dir = dto.getDataValue(File.class);
            TreeItem<String> root = new TreeItem<>(dir.getName());
            docTree.setRoot(root);
            root.setExpanded(true);
            getChild(root, dir);
            docTree.setPrefWidth(splitPane.getWidth() * 0.3);
            docTree.setPrefHeight(splitPane.getHeight());
            ObservableList<Node> items = splitPane.getItems();
            items.clear();
            items.add(docTree);

            //
            TextArea context = new TextArea();
            context.setPrefWidth(splitPane.getWidth() * 0.7);
            context.setPrefHeight(splitPane.getHeight());

            //指定默认宽度

            splitPane.getItems().add(context);

            HTMLEditor hte = new HTMLEditor();
            hte.onKeyReleasedProperty().set(event -> {

                System.out.println(hte.getHtmlText());
            });

            splitPane.getItems().add(hte);
            splitPane.setDividerPositions();
        });

        if (rootFile == null || !rootFile.exists()) {

            Button bt = new Button(getMessage("chooseFile"));
            bt.setOnAction(event -> {
                FileChooser fc = new FileChooser();

                File file = fc.showOpenDialog(new Popup());

                if (file != null) {
                    AppConfig.docSvr.setCurrentDoc(file);
                    TaskDTO td = new TaskDTO();
                    td.setData(file);
                    td.setMsg("刷新对象树");
                    td.setPath("rf_tree");
                    es.addTask(td);
                }

            });

            Button btDir = new Button(getMessage("chooseDir"));
            btDir.setOnAction(event -> {
                DirectoryChooser dc = new DirectoryChooser();

                File file = dc.showDialog(new Popup());

                if (file != null) {
                    AppConfig.docSvr.setCurrentDoc(file);
                    TaskDTO td = new TaskDTO();
                    td.setData(file);
                    td.setMsg("刷新对象树");
                    td.setPath("rf_tree");
                    es.addTask(td);
                }

            });

            HBox hb = new HBox();
            hb.getChildren().add(bt);
            hb.getChildren().add(btDir);
            splitPane.getItems().add(hb);
        }

    }

    private void getChild(TreeItem<String> parent, File rootDoc) {
        if (parent != null && rootDoc.exists()) {
            File[] _files = rootDoc.listFiles();
            if (_files != null && _files.length > 0) {
                for (int i = 0; i < _files.length; i++) {
                    File _file = _files[i];
                    TreeItem<String> child = new TreeItem<>(_file.getName());

                    if (LOG.isDebugEnabled()) {
                        LOG.debug("选择文件：{}", _file.getName());
                    }

                    child.setValue(_file.getPath());
                    parent.getChildren().add(child);
                    child.setExpanded(false);
                    getChild(child, _file);
                }
            }

        }
    }


    /**
     * @return 获取国际化标识
     */
    public static String getMessage(String msgKey) {

        ResourceBundle bundle = ResourceBundle.getBundle("message", AppConfig.getLocale());

        return bundle.getString(msgKey);
    }
}