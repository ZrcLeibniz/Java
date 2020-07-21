package zrc.io;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        // 拷贝源头
        File srcFile = new File("E:\\LearnofSSM");
        // 拷贝目标
        File destFile = new File("F:\\StudyFile");
        // 调用方法拷贝
        copyDir(srcFile, destFile);
    }

    private static void copyDir(File srcFile, File destFile) {
        if (srcFile.isFile()) {
            FileInputStream fileInputStream = null;
            FileOutputStream fileOutputStream = null;
            try {
                fileInputStream = new FileInputStream(srcFile);
                String path = destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() : destFile.getAbsolutePath() + "\\" + srcFile.getAbsolutePath().substring(3);
                fileOutputStream = new FileOutputStream(path);
                byte[] bytes = new byte[1024 * 1024];
                int readCount = 0;
                while ((readCount = fileInputStream.read(bytes)) != -1) {
                    fileOutputStream.write(bytes, 0, readCount);
                }
                fileOutputStream.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return;
        }
        // 获取拷贝源的子目录
        File[] files = srcFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                String srcDir = file.getAbsolutePath();
                String destDir = destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() : destFile.getAbsolutePath() + "\\" + srcDir.substring(3);
                File newFile = new File(destDir);
                if (!newFile.exists()) {
                    newFile.mkdirs();
                }
            }
            copyDir(file, destFile);
        }
    }

}
