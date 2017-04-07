package com.demo.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import model.GetProperties;

public class test {
	private static Properties props = new Properties();
	static{
		InputStream is = null;
		is = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			System.out.println("???");
			props.load(is);
			System.out.println("!!!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			}
	}
	static DBUtils dbutil =new DBUtils();
public static void main(String[] args){
	System.out.println((String)props.get("url")+(String)props.get("username")+(String)props.get("password"));
	Connection con=dbutil.createConn2();
	String result = GetProperties.getProperties2("url", "jdbc.properties");
	if(con!=null){System.out.println("成功 ");}
	else{System.out.println("失败");}
}

}
