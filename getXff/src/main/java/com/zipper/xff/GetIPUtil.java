package com.zipper.xff;

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
public class GetIPUtil {


    //----------------------------------------
    public static List<String> getXffList(File sf) {
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

    public static String getXffList(String line) {
        if (null == line || "".equals(line)) {
            return line;
        }

        String token = null;

        StringTokenizer st = new StringTokenizer(line);
        if (st.countTokens() == 16) {

            for (int i = 0; st.hasMoreTokens(); token = st.nextToken(), i++) {

                if (token != null && !"".equals(token) && i == 10) {
                    return token;
                }
            }
        }

        return token;
    }

}
