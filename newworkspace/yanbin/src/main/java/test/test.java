package test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.net.URL;

import javax.security.auth.x500.X500Principal;

import com.sun.jersey.server.impl.model.parameter.multivalued.StringReaderProviders.TypeValueOf;

public class test {
	public static void main(String[] args){
		String t="icon.xpm";
		String[] tmp = t.split("\\.");
		System.out.println(tmp[tmp.length-1]);
		InputStream inputStream = new URL(HADOOP_URL+filename).openStream();
	}
//		String dirname = "/";
//		String[] arr=trans(dirname);
//		for (int i=0;i<arr.length;i++){
//			System.out.println("----"+arr[i]+"------");
//		}
//		if (arr.length==0){System.out.println("null!!!");}
//	}
	public static  String[] trans(String dirname){
		if (dirname.length()>=17){
			dirname=dirname.substring(18, dirname.length());
			}
		String[] arr=dirname.split("/");
		if (arr.length<1){return new String[0];}
		List<String> path = new ArrayList<String>();
		for (int i=0;i<arr.length;i++){
			path.add(path(arr, i));
		}
		path.remove(0);
		System.out.println(path);
		String[] paths= path.toArray(new String[0]);
		return paths;
	}
	
	public static String path(String[] arr,int index){
	int len=arr.length;
	String path="";
	if (len==1){return arr[0];}
	for (int i=0;(i<index)&&(i<len-1);i++){
		path=path+arr[i]+"/";
	}
	path = path +arr[index];
	return path;
	}
	}
