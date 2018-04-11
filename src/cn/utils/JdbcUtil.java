package cn.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	/**获取数据库连接
	 * @return 数据库连接的Connection对象
	 */
	public static Connection getConn(){
		Connection conn=null;
		try {
			//1、加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2、获取数据库连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/find", 
					"root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**关闭数据库连接的相关对象
	 * @param conn：数据库连接对象
	 * @param pstat：预编译sql语句之后产生PreparedStatement对象
	 * @param rs：查询的结果集
	 */
	public static void close(Connection conn,PreparedStatement pstat,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstat!=null){
			try {
				pstat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(getConn());
	}
}
