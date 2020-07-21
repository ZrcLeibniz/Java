package zrc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/*
File
    File类和四大家族没有关系，所以File类不能完成文件的读和写
    File对象代表文件和目录路径名的抽象表示形式
    一个File对象可能是对应的目录，也可能是文件，File只是一个路径名的抽象表示形式
 */
public class FileTest {
    public static void main(String[] args) {
        File file = new File("F:\\StudyFile");
        // 判断File对象所代表的文件路径是否存在
        System.out.println(file.exists());
        // 如果File对象所代表的文件路径不存在，以文件的形式创建
        File file1 = new File("F:\\StudyFile\\study.txt");
        if (!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 如果File对象所代表的文件路径不存在，以目录的形式创建
        File file2 = new File("F:\\StudyFile\\study");
        if (!file2.exists()) {
            file2.mkdir();
        }
        // 如果File对象所代表的文件路径不存在，以多重目录的形式创建
        File file3 = new File("F:\\StudyFile\\a\\b\\c\\d");
        if (!file3.exists()) {
            file3.mkdirs();
        }
        // 获取一个File对象的父级File对象（返回类型是String）
        System.out.println(file3.getParent());
        // 获取一个File对象的父级File对象（返回类型是File对象）
        System.out.println(file3.getParentFile());
        // 获取绝对路径
        File file5 = new File("ArrayStack");
        System.out.println(file5.getAbsolutePath());
        // 删除文件
        file3.delete();
        // 判断File对象是否是一个目录
        System.out.println(file2.isDirectory());
        // 判断File对象是否是一个文件
        System.out.println(file1.isFile());
        // 获取文件最后一次修改时间
        long l = file2.lastModified();
        Date date = new Date(l);
        System.out.println(date);
        // 获取文件大小
        File file4 = new File("C:\\Users\\lenovo\\Desktop\\饭碗\\java虚拟机.doc");
        System.out.println(file4.length());
        // 获取当前文件夹下的所有子目录
        File file6 = new File("E:\\GitWarehouse\\Java");
        File[] files = file6.listFiles();
       for (File f :files) {
           System.out.println(f.getName());
       }
    }
}
