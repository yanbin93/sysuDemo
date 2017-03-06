package hadoop.hdfs;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.apache.hadoop.hdfs.TestDFSMkdirs;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.mapreduce.TestLargeSort;
import org.junit.Before;
import org.junit.Test;
import com.sun.jersey.server.impl.uri.PathTemplate;


public class HDFSDemo {
	FileSystem fs = null ;
		@Before
	public void init( ) throws IOException, URISyntaxException{
			//首先创建FileSystem的实现类（工具类）
			Configuration conf = new Configuration();
//			conf.set("dfs.nameservices","ns1");
//			conf.set( "dfs.ha.namenodes.ns1", "nn1,nn2");
//			conf.set("dfs.namenode.rpc-address.ns1.nn1", "master1:9002");
//			conf.set("dfs.namenode.rpc-address.ns1.nn2", "master2:9002");
//			conf.set("dfs.client.failover.proxy.provider.ns1", "org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider");
//			fs =FileSystem.get(new URI("hdfs://ns1"), conf);
			fs = FileSystem.get(new URI("hdfs://master1:9002"),conf);
	} 
		@Test
	public void testUpload( ) throws Exception{
		//读取本地文件系统的文件，返回输入流
			InputStream in =new FileInputStream("/home/yanbin/HTTP_20130313143750.dat");
			//在HDFS上创建一个文件，返回输出流
			OutputStream out = fs.create(new Path("/tmp/data/data.dat"));
			//输入-》输出
			IOUtils.copyBytes(in, out, 4096,true);
	}
		@Test
		public void testDownload()throws Exception{
			fs.copyToLocalFile(new Path("/tmp/input"), new Path("/home/yanbin/input"));
		}
		
		@Test
		public void TestDFSMkdirs( ) throws Exception {
			boolean flag = fs.mkdirs(new Path ("/tmp/data"));
			System.out.println(flag);
		}
		@Test
		public void test() throws IOException{
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader brStat = null;
		StringTokenizer tokenStat = null;
		Process process = Runtime.getRuntime().exec("hadoop fs -ls /tmp");
		is = process.getInputStream();
		isr = new InputStreamReader(is);
		brStat = new BufferedReader(isr);
		String strLine = null;
		//textFile.setText("");
		strLine=brStat.readLine();
		System.out.print(strLine);
		while (strLine != null) {
			tokenStat = new StringTokenizer(strLine);
			String mode = tokenStat.nextToken();
			tokenStat.nextToken();
			String user = tokenStat.nextToken();
			String group = tokenStat.nextToken();
			String size = tokenStat.nextToken();
			String time = tokenStat.nextToken() + " " + tokenStat.nextToken();
			String path = tokenStat.nextToken();
			System.out.println(mode+" "+user+" "+group+" "+size+" "+time +" "+path);
	}
		}
	@Test
		public void TestLs() throws IOException{
		HDFSUtil hdfs = new HDFSUtil();
		RemoteIterator<LocatedFileStatus> file =hdfs.listFiles(fs, "/tmp", true);
		while(file.hasNext()){
			System.out.println(file.next());
		}
		fs.close();
	}
	@Test
		public void testDel( ) throws Exception{
			boolean flag = fs.delete(new Path("/tmp/input"), true );
			System.out.println(flag);
		}
		
	public static void main(String[ ] args) throws Exception{
		FileSystem fs =FileSystem.get(new URI("hdfs://master1:9002"), new Configuration( ) );
		InputStream in=fs.open(new Path("/tmp/input/file1.txt"));
		OutputStream out=new FileOutputStream("/home/yanbin/file.txt");
		IOUtils.copyBytes(in,out,4096,true);
	}
}
