package hdfs;

import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.apache.hadoop.hbase.tmpl.common.TaskMonitorTmpl;

public class HDFStest {
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		FileSystem fs;
		fs = FileSystem.get(new URI("hdfs://MS-TXY:9002"), conf);
		String dirname = "/tmp";
		RemoteIterator<LocatedFileStatus> files = HDFSUtil.listFiles(fs, dirname, false);
		FileStatus [] status=HDFSUtil.listStatus(conf, dirname);
		System.out.println("--临时目录下的所有文件---");
		Path[] dirs = FileUtil.stat2Paths(status);
		  for (Path dir:dirs){
		   System.out.println(dir);
		  }
		while (files.hasNext()) {
			LocatedFileStatus tmp=files.next();
			Path path=tmp.getPath();
			long size=tmp.getLen();
			boolean isFile=tmp.isFile();
			System.out.println(path+" : "+isFile+" "+Long.toString(size));
		}
	}
}
