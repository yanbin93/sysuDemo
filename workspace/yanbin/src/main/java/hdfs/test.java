package hdfs;
import org.junit.Test;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
public class test {
	@Test
    public void test() throws Exception {
        Configuration conf = new Configuration();
        String newDir = "/test";
        //01.检测路径是否存在 测试
        if (HDFSUtil.exits(conf, newDir)) {
            System.out.println(newDir + " 已存在!");
        } else {
            //02.创建目录测试
            boolean result = HDFSUtil.createDirectory(conf, newDir);
            if (result) {
                System.out.println(newDir + " 创建成功!");
            } else {
                System.out.println(newDir + " 创建失败!");
            }
        }
        String fileContent = "Hi,DengLijie. I love you";
        String newFileName = newDir + "/myfile.txt";

        //03.创建文件测试
        HDFSUtil.createFile(conf, newFileName, fileContent);
        System.out.println(newFileName + " 创建成功");

        //04.读取文件内容 测试
        System.out.println(newFileName + " 的内容为:\n" + HDFSUtil.readFile(conf, newFileName));

        //05. 测试获取所有目录信息
        FileStatus[] dirs = HDFSUtil.listStatus(conf, "/");
        System.out.println("--根目录下的所有子目录---");
        for (FileStatus s : dirs) {
            System.out.println(s);
        }

        //06. 测试获取所有文件
        FileSystem fs = FileSystem.get(new URI("hdfs://master1:9002"),conf);
        String dirname = "tmp目录";
        RemoteIterator<LocatedFileStatus> files = HDFSUtil.listFiles(fs, "/tmp", true);
        System.out.println("--临时目录下的所有文件---");
        String FileName = dirname + "/目录列表.txt";
        String context ="";
        if (HDFSUtil.exits(conf, dirname)) {
            System.out.println(dirname + " 已存在!");
        } else {
        boolean result = HDFSUtil.createDirectory(conf, dirname);
        if(result){System.out.println(dirname+"创建成功");}
        else{System.out.println(dirname+"创建失败");}
        }
        while (files.hasNext()) {
            context= context+files.next()+"\r";
            //System.out.println(files.next());
        }
        HDFSUtil.createFile(conf, FileName, context);
        //fs.close();

        //删除文件测试
        //boolean isDeleted = HDFSUtil.deleteFile(conf, newDir);
        //System.out.println(newDir + " 已被删除");
	}
    }
