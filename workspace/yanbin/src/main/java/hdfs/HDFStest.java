package hdfs;
import java.net.URI;
import java.util.ArrayList;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

import model.*;
public class HDFStest {
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
//		FileSystem fs;
//		fs = FileSystem.get(new URI("hdfs://master1:9002"), conf);
//		String dirname = "/";
////		String content = HDFSUtil.readFile(conf, dirname);
//		RemoteIterator<LocatedFileStatus> statuses = HDFSUtil.listFiles(fs, dirname, true);
////		FileStatus [] statuses=HDFSUtil.listStatus(conf, dirname);
//		ArrayList<File> files = new ArrayList<File>();
//		while(statuses.hasNext()){
//		LocatedFileStatus status = statuses.next();	
//				File file = new File();
//				long size=status.getLen()/1024;
//				Path name=status.getPath();
//				String type = status.isDirectory()?"Dir":"File";
//				file.setSize(size);
//				file.setName(name.toString());
//				file.setType(type);
//				files.add(file);
//				System.out.println(name.getName()+ " " +Long.toString(size)+"KB "+type);
		boolean flag=HDFSUtil.createDirectory(conf, "/newtest");
		System.out.println(flag);
		}
//		System.out.println(content);
		
//		Path[] dirs = FileUtil.stat2Paths(statuses);
//		  for (Path dir:dirs){
//		   System.out.println(dir);
//		  }
//		while (files.hasNext()) {
//			LocatedFileStatus tmp=files.next();
//			Path path=tmp.getPath();
//			long size=tmp.getLen();
//			boolean isFile=tmp.isFile();
//			if (!isFile)
//			{
//			System.out.println(path+" : "+isFile+" "+Long.toString(size));}
//		}
//	}
}
