package model;

import java.util.ArrayList;
import java.util.List;

public class pathList {
	public static String[] trans(String dirname) {
		if (dirname.length() >= 18) {
			dirname = dirname.substring(19, dirname.length());
		}
		String[] arr = dirname.split("/");
		if (arr.length < 1) {
			return new String[0];
		}
		List<String> path = new ArrayList<String>();
		for (int i = 0; i < arr.length; i++) {
			path.add(path(arr, i));
		}
		path.remove(0);
		System.out.println(path);
		String[] paths = path.toArray(new String[0]);
		return paths;
	}

	public static String path(String[] arr, int index) {
		int len = arr.length;
		String path = "";
		if (len == 1) {
			return arr[0];
		}
		for (int i = 0; (i < index) && (i < len - 1); i++) {
			path = path + arr[i] + "/";
		}
		path = path + arr[index];
		return path;
	}
}
