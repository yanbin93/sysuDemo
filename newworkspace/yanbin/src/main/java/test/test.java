package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sun.jersey.server.impl.model.parameter.multivalued.StringReaderProviders.TypeValueOf;

public class test {
	public static void main(String[] args){
		String dirname = "hdfs://MS-TXY:9002/test";
		
		String[] arr=trans(dirname);
		System.out.println(arr.length);
		for (int i=0;i<arr.length;i++){
			System.out.println("----"+arr[i]+"------");
		}
	}
	public static  String[] trans(String dirname){
		if (dirname.length()>=17){
			dirname=dirname.substring(18, dirname.length());
			}
		String[] arr=dirname.split("/");
		System.out.println(arr.length);
		ArrayList<String> path = new ArrayList<String>();
		for (int i=0;i<arr.length;i++){
			System.out.println("----"+arr[i]+"------");
			path.add(path(arr, i));
		System.out.println(path(arr, i));
		}
		String[] paths= path.toArray(new String[]);
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
