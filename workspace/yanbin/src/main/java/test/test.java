package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.*;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.security.auth.x500.X500Principal;

import org.apache.commons.lang.ArrayUtils;

import com.sun.jersey.server.impl.model.parameter.multivalued.StringReaderProviders.TypeValueOf;

import model.File;
import model.ListAll;
import model.Product;
import model.ShowProduct;

public class test {
		    public static void main(String[] args) throws Exception, IOException {
		    	 InetAddress ia=null;
		         try {
		             ia=ia.getLocalHost();
		              
		             String localname=ia.getHostName();
		             String localip=ia.getHostAddress();
		             System.out.println("本机名称是："+ localname);
		             System.out.println("本机的ip是 ："+localip);
		         } catch (Exception e) {
		             // TODO Auto-generated catch block
		             e.printStackTrace();
		         }
		    }
//		    	for (Product list:asList){
//		    	System.out.println(ListAll.show(list));}
//		         }
//		         String type=file.getClass().toString().split(" ")[1];
//		         System.out.println(file.getClass().toString().split(" ")[1]);
//		         c = Class.forName(type);
//		         
//		         Field [] fields = c.getDeclaredFields();  
//		         Method[] methods = c.getMethods();
//		         Pattern p = Pattern.compile("\\w+\\.");
//		         Constructor[] ctors = c.getConstructors();
//		         for (Constructor method:ctors){
//		        	 System.out.println("A---------------------------------A");
//		        	 System.out.println(p.matcher(method.toString()).replaceAll(""));
//		        	 System.out.println("---------------------------------");
//		        	 System.out.println(method.toString());
//		        	 System.out.println("B---------------------------------B");
//		         }
//		         for(Field f:fields){  
//		             f.setAccessible(true);  
//		         }  
//		         //输出p1的所有属性  
//		         System.out.println("=============About file===============");  
//		         for(Field f:fields){  
//		        	 System.out.println(f.toString());
//		             String field = f.toString().substring(f.toString().lastIndexOf(".")+1);         //取出属性名称  
//		             System.out.println("p1."+field+" --> "+f.get(file));  
//		         }     
		    public static String getProperties(String key)throws Exception{
		    String property=null;
		    Properties pps = new Properties();
	        pps.load(new FileInputStream("~/workspace/yanbin/src/hadoop.properties"));
	        property=pps.getProperty(key).toString();
	        return property;
		    }		    
//		InputStream inputStream = new URL(HADOOP_URL+filename).openStream();
	
//		String dirname = "/";
//		String[] arr=trans(dirname);
//		for (int i=0;i<arr.length;i++){
//			System.out.println("----"+arr[i]+"------");
//		}
//		if (arr.length==0){System.out.println("null!!!");}
//	}
	public static  String[] trans(String dirname){
		if (dirname.length()>=18){
			dirname=dirname.substring(19, dirname.length());
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
