package org.zipper.edit.service;



import org.zipper.edit.iface.DocSvr;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/29.
 */
public class DocServiceImpl implements DocSvr {

    private List<File> docs;

    public DocServiceImpl() {
        super();

        docs = new ArrayList<>();
    }

    @Override
    public File getCurrentDoc() {
        File rf = null;
        if (docs.size() > 0) {
            rf = docs.get(0);
        }
        return rf;
    }

    @Override
    public List<File> getCurrentDocs() {
        return null;
    }

    @Override
    public void setCurrentDoc(File file) {
        docs.add(file);
    }
}
