package hive;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class QueryHiveUtils {
	private static Connection conn = JDBCToHiveUtils.getConnnection();
	private static PreparedStatement ps;
	private static ResultSet rs = null;

	public static void getAll(String tablename) {
		String sql = "select * from " + tablename;
		System.out.println(sql);
		try {
			ps = JDBCToHiveUtils.prepare(conn, sql);
			rs = ps.executeQuery();
			int columns = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columns; i++) {
					System.out.print(rs.getString(i));
					System.out.print("\t\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void count(String sql) {
		System.out.println(sql);
		try {
			ps = JDBCToHiveUtils.prepare(conn, sql);
			rs = ps.executeQuery();
			System.out.println("--------执行成功！--------"+rs.wasNull());
			int columns = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columns; i++) {
					System.out.print("The "+Integer.toString(i)+" output is: "+rs.getString(i));
					System.out.print("\n");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean opeart(String sql) {
		System.out.println(sql);
		boolean flag = false;
		try {
			ps = JDBCToHiveUtils.prepare(conn, sql);
			int isOk = ps.executeUpdate(sql);
			System.out.println(isOk);
			if (isOk > 1){
				System.out.println("-------- "+isOk+" + 操作执行成功 --------");
				flag=true;
				};
//			int columns = rs.getMetaData().getColumnCount();
//			while (rs.next()) {
//				for (int i = 1; i <= columns; i++) {
//					System.out.print("The "+Integer.toString(i)+" output is: "+rs.getString(i));
//					System.out.print("\n");
//				}
//				System.out.println();
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
}