package cn.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	/**��ȡ���ݿ�����
	 * @return ���ݿ����ӵ�Connection����
	 */
	public static Connection getConn(){
		Connection conn=null;
		try {
			//1���������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			//2����ȡ���ݿ�����
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/find", 
					"root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**�ر����ݿ����ӵ���ض���
	 * @param conn�����ݿ����Ӷ���
	 * @param pstat��Ԥ����sql���֮�����PreparedStatement����
	 * @param rs����ѯ�Ľ����
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
