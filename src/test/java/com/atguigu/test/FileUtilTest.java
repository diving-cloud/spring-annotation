package com.atguigu.test;

import static java.lang.System.out;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author hezongkui <hezongkui@kuaishou.com>
 * Created on 2022-03-14
 */
public class FileUtilTest {


    /**
     * contentEquals：判断两个文件是否相同
     * isFileNewer：判断文件的创建日期与指定日期比较
     * listFiles：查询目录下文件
     * readFileToString：读取文件为字符串
     * readLines：读取文件为多行字符串
     * sizeOf：查询文件大小
     * writeStringToFile：将一个字符串写入一个文件创建文件，如果不存在。
     * writeLines：将多行文本写入文件
     * mkdir：创建目录或创建文件的父目录
     * copy：将目录/文件复制到目录/文件；可过滤；可设置保存最新日期
     * move：将目录/文件移动到目录/文件；可过滤；可设置保存最新日期
     * deleteFile：删除目录或文件
     * deleteFilesViaPath：批量删除文件或目录
     * deleteFiles：批量删除文件或目录
     */

    /**
     * 修改文件编码：gbk -> utf-8
     */
    @Test
    public void testReadLines() {
        String path = "/Users/hezongkui/github/springmvc-annotation";
        // 列出目录下所有文件
        Collection<File> files = FileUtils.listFiles(new File(path), null, true);
        files.forEach(file -> {
            try {
                // 按照指定编码读取文件
                List<String> lines = FileUtils.readLines(file, "GBK");
                // 写文件
                FileUtils.writeLines(file, lines, "\n", false);
            } catch (Exception e) {
            }
        });
    }

    @Test
    public void testEncodingConvert() {

    }

    @Test
    public void showURL() throws IOException, IOException {
        // 第一种：获取类加载的根路径
        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f);

        // 获取当前类的所在工程路径; 如果不加“/”  获取当前类的加载目录
        File f2 = new File(this.getClass().getResource("").getPath());
        System.out.println(f2);

        // 第二种：获取项目路径
        File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath();
        System.out.println(courseFile);


        // 第三种：
        URL xmlpath = this.getClass().getClassLoader().getResource("");
        System.out.println(xmlpath);


        // 第四种：
        System.out.println(System.getProperty("user.dir"));

        // 第五种：  获取所有的类路径 包括jar包的路径
        System.out.println(System.getProperty("java.class.path"));


    }

    private static String buildPath(String path) {
        return System.getProperty("user.dir") + "/src/main/java/com/atguigu/" + path;
    }


    public static void main(String[] args) {
        boolean blank = StringUtils.isBlank(" ");//注意此处是null哦  这和isEmpty不一样的
        System.out.println(blank);

        boolean empty = StringUtils.isEmpty(" ");//注意这里是false
        System.out.println(empty);

        boolean anyBlank = StringUtils.isAnyBlank("a", " ", "c");// 其中一个是不是空字符串
        System.out.println(anyBlank);

        boolean numeric = StringUtils.isNumeric("1");//字符串是不是全是数字组成，"." 不算数字
        System.out.println(numeric);

        String remove = StringUtils.remove("abcdefgh", "a");//移除字符串
        System.out.println(remove);
    }

}
