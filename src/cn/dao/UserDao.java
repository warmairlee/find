package cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.utils.JdbcUtil;
import cn.vo.User;

public class UserDao {
	Connection conn=null;
	PreparedStatement pstat = null;
	ResultSet rs = null;
//用户登录	
	public User login(String phone, String pwd) {
		
		User user = null;
		
		conn = JdbcUtil.getConn();
		try {
			pstat = conn.prepareStatement("select * from user where phone=? and password=?");
			pstat.setString(1, phone);
			pstat.setString(2, pwd);
			rs = pstat.executeQuery();
			if(rs.next()){
				user = new User();
				user.setPhone(rs.getString("phone"));
				user.setPwd(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setEmail(rs.getString("email"));
				user.setHeadp(rs.getString("headp"));
				user.setAutograph(rs.getString("autograph"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstat, rs);
		}
		
		return user;
	}
	
//添加用户	
	public boolean addUser(User user) {
		String sql = "insert into user(phone,password,nickname,email) values(?,?,?,?)";
		conn = JdbcUtil.getConn();
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getPhone());
			pstat.setString(2, user.getPwd());
			pstat.setString(3, user.getNickname());
			pstat.setString(4, user.getEmail());
			int row = pstat.executeUpdate();
			return row>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstat, rs);
		}
		return false;
	}
	
//是否存在用户	
	public boolean IsHave(String phone){
		String sql = "select * from user where phone=?";
		conn = JdbcUtil.getConn();
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, phone);
			rs = pstat.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstat, rs);
		}
		
		return false;
		
	}
	
//修改信息
	public boolean updateInfo(String phone,String nickname,String email,String at,String headp){
		conn = JdbcUtil.getConn();
		String sql = "update  user set nickname = ? , email = ? , autograph = ? , headp = ? where phone = ?";
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, nickname);
			pstat.setString(2, email);
			pstat.setString(3, at);
			pstat.setString(4, headp);
			pstat.setString(5, phone);
			int row = pstat.executeUpdate();
			return row>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstat, rs);
		}
		return false;
		
	}
	
	//修改密码
    public boolean changePWD(String phone ,String pwd){
    	conn = JdbcUtil.getConn();
    	String sql = "update user set password = ? where phone = ?";
    	try {
    		pstat = conn.prepareStatement(sql);
			pstat.setString(1, pwd);
			pstat.setString(2, phone);
			int row = pstat.executeUpdate();
			return row>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return false;
    }	
}

