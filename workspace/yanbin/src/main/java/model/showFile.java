package model;
import java.net.URI;
import java.util.ArrayList;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import hdfs.HDFSUtil;
public class showFile{
	final Configuration conf = new Configuration();
	static FileSystem fs;
	
	public ArrayList<File> show(String dirname) throws Exception{
//	?dirname = "/hive";
	fs = FileSystem.get(new URI("hdfs://master1:9002"), conf);
	FileStatus [] statuses=HDFSUtil.listStatus(conf, dirname);
	ArrayList<File> files = new ArrayList<File>();
	for (FileStatus status:statuses){
			File file = new File();
			long size=status.getLen()/1024;
			Path name=status.getPath();
			String type = status.isDirectory()?"Dir":"File";
			file.setSize(size);
			file.setName(name.toString());
			file.setType(type);
			files.add(file);
			System.out.println(name+ " " +Long.toString(size)+"KB "+type);
	}
    return files;
	}
}
