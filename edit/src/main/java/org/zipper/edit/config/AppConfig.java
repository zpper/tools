package org.zipper.edit.config;

import org.zipper.edit.iface.DocSvr;
import org.zipper.edit.service.DocServiceImpl;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 应用的配置方法<br>
 *
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/27.
 */
public class AppConfig {

    private static Locale _glbLocal;

    public static DocSvr docSvr;

    private static ConcurrentHashMap<String, String> config;
    private static ConcurrentHashMap<String, List<String>> cfgList;

    private static final String BASE_DIR = "config";


    static {
        config = new ConcurrentHashMap();
        cfgList = new ConcurrentHashMap();

        _glbLocal = Locale.getDefault();
        docSvr = new DocServiceImpl();
    }

    public static void setLocale(Locale local) {



        if (local != null) {
            _glbLocal = local;
        }
    }

    public static Locale getLocale() {
        return _glbLocal;
    }

    private static File getBaseDir() {
        File baseDir = new File(System.getProperty("user.dir") + File.separator + BASE_DIR);
        if (!baseDir.exists()) {
            baseDir.mkdir();
        }
        return baseDir;
    }

}
