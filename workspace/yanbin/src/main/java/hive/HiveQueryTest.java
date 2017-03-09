package hive;

import java.util.Scanner;

public class HiveQueryTest {
	static boolean flag = false;
	public static void main(String[] args) {
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
		// String tablename = "username";

		// String sql = "show tables ";

		// String sql ="create table if not exists test(id int) " ;
		// String sql ="insert into table test values (5) " ;
		// String sql ="drop table test " ;

	}
}
