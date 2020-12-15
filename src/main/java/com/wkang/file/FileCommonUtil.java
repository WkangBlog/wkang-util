package com.wkang.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * 文件通用工具类
 * wkang 20201215
 */
public class FileCommonUtil {

    public static byte[] readFile(String filePath) throws Exception {
        return Files.readAllBytes(new File(filePath).toPath());
    }

    public static void writeFile(String destPath, byte[] bytes) throws IOException {
        File dest = new File(destPath);
        if (!dest.exists()) {
            dest.createNewFile();
        }
        Files.write(dest.toPath(), bytes);
    }
}
