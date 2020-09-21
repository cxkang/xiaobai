package com.xiaobai.loT.util;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AppUtil {

    /**
     * 版本号比较
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int versionCompareTo(String version1, String version2) {

        version1 = version1 == null ? "" : version1.replaceAll("[^\\d\\.]+", "");

        version2 = version2 == null ? "" : version2.replaceAll("[^\\d\\.]+", "");

        String[] version1Array = version1.split("\\.");

        String[] version2Array = version2.split("\\.");

        List<Integer> version1List = new ArrayList<Integer>();

        List<Integer> version2List = new ArrayList<Integer>();

        for (int i = 0; i < version1Array.length; i++) {

            version1List.add(Integer.parseInt(version1Array[i]));

        }

        for (int i = 0; i < version2Array.length; i++) {

            version2List.add(Integer.parseInt(version2Array[i]));

        }

        int size = version1List.size() > version2List.size() ? version1List.size() : version2List.size();

        while (version1List.size() < size) {

            version1List.add(0);

        }

        while (version2List.size() < size) {

            version2List.add(0);

        }

        for (int i = 0; i < size; i++) {

            if (version1List.get(i) > version2List.get(i)) {

                return 1;

            }

            if (version1List.get(i) < version2List.get(i)) {

                return -1;

            }

        }

        return 0;

    }

    /**
     * 图片下载
     *
     * @param path
     * @param paintingUrl
     * @throws IOException
     */
    public static void downLoadPic(String path, String paintingUrl) throws IOException {
        URL url;
        url = new URL(paintingUrl);
        DataInputStream dataInputStream = new DataInputStream(url.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = dataInputStream.read(buffer)) > 0) {
            output.write(buffer, 0, length);
        }
        fileOutputStream.write(output.toByteArray());
        dataInputStream.close();
        fileOutputStream.close();
    }

}
