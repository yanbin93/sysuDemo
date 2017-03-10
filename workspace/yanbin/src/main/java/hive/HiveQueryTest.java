package hive;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Test;

import model.MD5;

public class HiveQueryTest {
	static boolean flag = false;
	 public static void main(String[] args){
		 insert();
		 
	 }
	 
	public static void test(String[] args) {
		Scanner scanner = new Scanner(System.in);// 创建输入流扫描器
		System.out.println("请输入sql：");// 提示用户输入
		String sql = scanner.nextLine();// 获取用户输入的一行文本
		// 打印对输入文本的描述

		System.out.println("请输入操作方式（1、查询;2、操作）：");// 提示用户输入
		String method = scanner.nextLine();// 获取用户输入的一行文本
		// 打印对输入文本的描述
		if (Integer.parseInt(method) == 1) {
			System.out.println("操作方式为查询");
			System.out.println("sql:" + sql);
			QueryHiveUtils.count(sql);
		}
		if (Integer.parseInt(method) == 2) {
			System.out.println("操作方式为操作");
			System.out.println("sql:" + sql);
			QueryHiveUtils hiveUtils = new QueryHiveUtils();
			flag = hiveUtils.opeart(sql);
			if (flag) {
				System.out.println("OK!");
			} else {
				System.out.println("failed！");
			}
		} else {
			System.exit(0);
		}
	}
	public static void insert(){
		String username="sb";
		String pwd="123";
		String email="@qq.com";
		pwd =MD5.EncryptionStr32(pwd, "MD5", "UTF-8");
		String sql="insert into table username values (?,?,"+null+",?)";
		Connection hiveConn = JDBCToHiveUtils.getConnnection();
		java.sql.PreparedStatement ps =JDBCToHiveUtils.prepare(hiveConn,sql);
		int rs;
		boolean flag = false;
		try {
			ps.setString(1,username);
			ps.setString(2,pwd);
			ps.setString(3,email);
			rs = ps.executeUpdate();
			System.out.println("添加用户成功?");
			if (rs>0){
			System.out.println("添加用户成功");
			}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
}
