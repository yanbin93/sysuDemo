package com.demo.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

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
public static void main(String[] args){
	System.out.println((String)props.get("url")+(String)props.get("username")+(String)props.get("password"));
	DBUtils dbutil =new DBUtils();
	Connection con= dbutil.createConn();
	if(con!=null){System.out.println("成功");}
	else{System.out.println("失败");}
}

}
