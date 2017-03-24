package model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ListAll {
	static Class<?> c = null;  
    public static List<String> show(Object object) throws Exception{
    List<String> result = new ArrayList<String>();
    String type=object.getClass().toString().split(" ")[1];
	c = Class.forName(type);
    Field [] fields = c.getDeclaredFields();  
    Method[] methods = c.getMethods();
    Pattern p = Pattern.compile("\\w+\\.");
    for(Field f:fields){  
        f.setAccessible(true);  
    }  
    //输出p1的所有属性  
//    System.out.println("=============About file===============");  
    for(Field f:fields){  
//   	 	System.out.println(f.toString());
        String field = f.toString().substring(f.toString().lastIndexOf(".")+1);
        Object fetch = f.get(object);//取出属性名称
        if (fetch==null){fetch="";}
//			System.out.println(object.toString()+" "+field+" --> "+fetch);
			result.add(fetch.toString());
    }
    return result;
    }
}
