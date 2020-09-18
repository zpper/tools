package com.zipper.xff;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author peng0806@foxmail.com <br>
 * Date: 2020/09/17.
 */
public class GetXFFIP {


    @Test
    public void getXff() {

        String path = "C:\\Users\\12925\\Desktop\\zh\\XX内容.txt";

        if (path.contains("\\:") && path.startsWith(File.separator)) {
        } else {
            path = System.getProperty("user.dir") + File.separator + path;
        }

        File sf = new File(path);
        if (sf.isFile() && sf.exists()) {
            List<String> ips = getXffList(sf);
            ips.forEach(System.out::println);
        } else {
            System.out.println("文件不存在");
        }
    }

    private List<String> getXffList(File sf) {
        List<String> ips = new ArrayList<>();
        try {

            List<String> lines = Files.readAllLines(sf.toPath());
            if (lines != null && !lines.isEmpty()) {
                lines.stream().forEach(line -> {
                    StringTokenizer st = new StringTokenizer(line);
                    if (st.countTokens() == 16) {
                        String token = null;
                        for (int i = 0; st.hasMoreTokens(); token = st.nextToken(), i++) {

                            if (token != null && !"".equals(token) && i == 10) {
                                ips.add(token);
                                break;
                            }
                        }
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ips;
    }
}
