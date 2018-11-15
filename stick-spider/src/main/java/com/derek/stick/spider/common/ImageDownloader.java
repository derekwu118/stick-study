package com.derek.stick.spider.common;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.io.IOUtils;

import com.google.common.base.Preconditions;

/**
 * @author derek.wu
 * @date 2018-11-15
 * @since v1.0.0
 */
public class ImageDownloader {

    private String        dir;
    private AtomicInteger counter = new AtomicInteger(1);

    public ImageDownloader(String dir) {
        Preconditions.checkNotNull(dir, "dir cannot be null.");
        File f = new File(dir);
        if (!f.exists()) {
            f.mkdirs();
        }
        if (!dir.endsWith("/")) {
            this.dir = dir + "/";
        } else {
            this.dir = dir;
        }
    }

    public void download(String imageUrl) {
        URL url = null;
        DataInputStream dataInputStream = null;
        FileOutputStream fileOutputStream = null;
        ByteArrayOutputStream output = null;
        try {
            url = new URL(imageUrl);
            dataInputStream = new DataInputStream(url.openStream());
            fileOutputStream = new FileOutputStream(new File(getPath()));
            output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(dataInputStream);
            IOUtils.closeQuietly(fileOutputStream);
            IOUtils.closeQuietly(output);
        }
    }

    private String getPath() {
        return dir + counter.getAndIncrement() + ".jpg";
    }
}
