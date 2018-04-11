package cn.dao;

import java.sql.*;

import cn.utils.JdbcUtil;
import cn.vo.Zhaoling;


public class ZhaolingDao {
	
	Connection conn = null;
	PreparedStatement pstat = null;
	ResultSet rs = null;
	
	public  boolean addzl(Zhaoling zl){
		
		String sql = "insert into zhaoling(title,time,place,des,contact,imgurl,phone) values(?,?,?,?,?,?,?)";
		conn = JdbcUtil.getConn();
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, zl.getTitle());
			pstat.setString(2, zl.getTime());
			pstat.setString(3, zl.getPlace());
			pstat.setString(4, zl.getDes());
			pstat.setString(5, zl.getCon());
			pstat.setString(6, zl.getImgurl());
			pstat.setString(7, zl.getPhone());
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
