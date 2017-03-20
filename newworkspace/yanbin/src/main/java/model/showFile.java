package model;
import java.net.URI;
import java.util.ArrayList;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

import hdfs.HDFSUtil;
public class showFile{
	final Configuration conf = new Configuration();
	static FileSystem fs;
	
	public ArrayList<File> show(String dirname) throws Exception{
//	?dirname = "/hive";
	fs = FileSystem.get(new URI("hdfs://MS-TXY:9002"), conf);
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


	public ArrayList<File> showSomeone(String filename) throws Exception{
	fs = FileSystem.get(new URI("hdfs://MS-TXY:9002"), conf);
	RemoteIterator<LocatedFileStatus> statuses = HDFSUtil.listFiles(fs, "/",true);
	ArrayList<File> filter = new ArrayList<File>();
	while(statuses.hasNext()){
		LocatedFileStatus status = statuses.next();	
		System.out.println(status.getPath().getName());
		if (status.getPath().getName().equals(filename)){
				File file = new File();
				long size=status.getLen()/1024;
				Path name=status.getPath();
				String type = status.isDirectory()?"Dir":"File";
				file.setSize(size);
				file.setName(name.toString());
				file.setType(type);
				filter.add(file);
				System.out.println(name+ " " +Long.toString(size)+"KB "+type);
		}
	}
	    return filter;
	}
	public String showFile(String filename) throws Exception{
	fs = FileSystem.get(new URI("hdfs://MS-TXY:9002"), conf);
	String content = HDFSUtil.readFile(conf, filename);
	return content;
}
}
