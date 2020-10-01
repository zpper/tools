package org.zipper.edit.iface;

import java.io.File;
import java.util.List;

public interface DocSvr {

    File getCurrentDoc();

    List<File> getCurrentDocs();

    void setCurrentDoc(File file);
}