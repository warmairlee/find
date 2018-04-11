package cn.dao;

import java.sql.*;

import cn.utils.JdbcUtil;
import cn.vo.Xunwu;


public class XunwuDao {
	
	Connection conn = null;
	PreparedStatement pstat = null;
	ResultSet rs = null;
	
	public  boolean addzl(Xunwu xw){
		
		String sql = "insert into xunwu(title,time,place,des,contact,imgurl,phone) values(?,?,?,?,?,?,?)";
		conn = JdbcUtil.getConn();
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, xw.getTitle());
			pstat.setString(2, xw.getTime());
			pstat.setString(3, xw.getPlace());
			pstat.setString(4, xw.getDes());
			pstat.setString(5, xw.getCon());
			pstat.setString(6, xw.getImgurl());
			pstat.setString(7, xw.getPhone());
			int row = pstat.executeUpdate();
			return row>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstat, rs);
		}
		return false;
	}
}