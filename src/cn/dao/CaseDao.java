package cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.tag.common.core.SetSupport;


import cn.utils.JdbcUtil;
import cn.vo.Xunwu;
import cn.vo.Zhaoling;

public class CaseDao {
	
	Connection conn = null;
	PreparedStatement pstat = null;
	ResultSet rs = null;
//∑÷“≥
	
    public static final int PAGESIZE = 9;
    
    public int findXWPageCount(){
    	int pageCount = 0;
    	conn = JdbcUtil.getConn();
    	String sql = "select * from xunwu";
    	try {
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			rs.last();
			int size = rs.getRow();
			pageCount = (size%PAGESIZE==0)?(size/PAGESIZE):(size/PAGESIZE+1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstat, rs);
		}
    	return pageCount;
    }
    
    public int findmyXWPageCount(String phone){
    	int myPageCount = 0;
    	conn = JdbcUtil.getConn();
    	String sql = "select * from xunwu where phone =?";
    	try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, phone);
			rs = pstat.executeQuery();
			rs.last();
			int size = rs.getRow();
			myPageCount = (size%PAGESIZE==0)?(size/PAGESIZE):(size/PAGESIZE+1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstat, rs);
		}
    	return myPageCount;
    }
    
    public int findZLPageCount(){
    	int pageCount = 0;
    	conn = JdbcUtil.getConn();
    	String sql = "select * from zhaoling";
    	try {
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			rs.last();
			int size = rs.getRow();
			pageCount = (size%PAGESIZE==0)?(size/PAGESIZE):(size/PAGESIZE+1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstat, rs);
		}
    	return pageCount;
    }
	
    public int findmyZLPageCount(String phone){
    	int myPageCount = 0;
    	conn = JdbcUtil.getConn();
    	String sql = "select * from zhaoling where phone =?";
    	try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, phone);
			rs = pstat.executeQuery();
			rs.last();
			int size = rs.getRow();
			myPageCount = (size%PAGESIZE==0)?(size/PAGESIZE):(size/PAGESIZE+1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstat, rs);
		}
    	return myPageCount;
    }
	
//—∞ŒÔ	
	public List<Xunwu> findXWCaseByKey(String title,String time1,String time2,String place,int curPage){
		List<Xunwu> list = new ArrayList<Xunwu>();
		String sql = "select * from xunwu where title like ? and time >= ? and time <= ? and place like ? order by num desc limit "+PAGESIZE*(curPage-1)+","+PAGESIZE;
		conn = JdbcUtil.getConn();
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, "%"+title+"%");
			pstat.setString(2, time1);
			pstat.setString(3, time2);
			pstat.setString(4, "%"+place+"%");
			rs = pstat.executeQuery();
			while(rs.next()){
				Xunwu xw = new Xunwu();
				xw.setNum(rs.getString("num"));
				xw.setTitle(rs.getString("title"));
				xw.setTime(rs.getString("time"));
				xw.setPlace(rs.getString("place"));
				xw.setImgurl(rs.getString("imgurl"));
				xw.setDes(rs.getString("des"));
				xw.setCon(rs.getString("contact"));
				list.add(xw);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstat, rs);
		}
		return list;
	}
	
	public List<Xunwu> findmyXWCaseByKey(String title,String time1,String time2,String place,int curPage,String phone){
		List<Xunwu> list = new ArrayList<Xunwu>();
		String sql = "select * from xunwu where title like ? and time >= ? and time <= ? and place like ? and phone = ? order by num desc limit "+PAGESIZE*(curPage-1)+","+PAGESIZE;
		conn = JdbcUtil.getConn();
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, "%"+title+"%");
			pstat.setString(2, time1);
			pstat.setString(3, time2);
			pstat.setString(4, "%"+place+"%");
			pstat.setString(5, phone);
			rs = pstat.executeQuery();
			while(rs.next()){
				Xunwu xw = new Xunwu();
				xw.setNum(rs.getString("num"));
				xw.setTitle(rs.getString("title"));
				xw.setTime(rs.getString("time"));
				xw.setPlace(rs.getString("place"));
				xw.setImgurl(rs.getString("imgurl"));
				xw.setDes(rs.getString("des"));
				xw.setCon(rs.getString("contact"));
				list.add(xw);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstat, rs);
		}
		return list;
	}
	
	
	public Xunwu findXWCaseByNum(String num) {
		String sql = "select * from xunwu left outer join user on xunwu.phone = user.phone where num = ?";
		conn = JdbcUtil.getConn();
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, num);
			rs = pstat.executeQuery();
			if(rs.next()){
				Xunwu xw = new Xunwu();
				xw.setTitle(rs.getString("title"));
				xw.setTime(rs.getString("time"));
				xw.setImgurl(rs.getString("imgurl"));
				xw.setPlace(rs.getString("place"));
				xw.setDes(rs.getString("des"));
				xw.setCon(rs.getString("contact"));
				xw.setPhone(rs.getString("phone"));
				xw.setNickname(rs.getString("nickname"));
				return xw;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn,pstat,rs);
		}
		return null;
	}
	
	
//’–¡Ï	
	public List<Zhaoling> findZLCaseByKey(String title,String time1,String time2,String place,int curPage){
		List<Zhaoling> list = new ArrayList<Zhaoling>();
		String sql = "select * from zhaoling where title like ? and time >= ? and time <= ? and place like ? order by num desc limit "+PAGESIZE*(curPage-1)+","+PAGESIZE;
		conn = JdbcUtil.getConn();
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, "%"+title+"%");
			pstat.setString(2, time1);
			pstat.setString(3, time2);
			pstat.setString(4, "%"+place+"%");
			rs = pstat.executeQuery();
			while(rs.next()){
				Zhaoling zl = new Zhaoling();
				zl.setNum(rs.getString("num"));
				zl.setTitle(rs.getString("title"));
				zl.setTime(rs.getString("time"));
				zl.setPlace(rs.getString("place"));
				zl.setImgurl(rs.getString("imgurl"));
				zl.setDes(rs.getString("des"));
				zl.setCon(rs.getString("contact"));
				list.add(zl);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstat, rs);
		}
		return list;
	}
	
	
	public List<Zhaoling> findmyZLCaseByKey(String title,String time1,String time2,String place,int curPage,String phone){
		List<Zhaoling> list = new ArrayList<Zhaoling>();
		String sql = "select * from zhaoling where title like ? and time >= ? and time <= ? and place like ? and phone = ? order by num desc limit "+PAGESIZE*(curPage-1)+","+PAGESIZE;
		conn = JdbcUtil.getConn();
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, "%"+title+"%");
			pstat.setString(2, time1);
			pstat.setString(3, time2);
			pstat.setString(4, "%"+place+"%");
			pstat.setString(5, phone);
			rs = pstat.executeQuery();
			while(rs.next()){
				Zhaoling zl = new Zhaoling();
				zl.setNum(rs.getString("num"));
				zl.setTitle(rs.getString("title"));
				zl.setTime(rs.getString("time"));
				zl.setPlace(rs.getString("place"));
				zl.setImgurl(rs.getString("imgurl"));
				zl.setDes(rs.getString("des"));
				zl.setCon(rs.getString("contact"));
				list.add(zl);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstat, rs);
		}
		return list;
	}
	
	public Zhaoling findZLCaseByNum(String num) {
		String sql = "select * from zhaoling left outer join user on zhaoling.phone = user.phone where num = ?";
		conn = JdbcUtil.getConn();
		try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, num);
			rs = pstat.executeQuery();
			if(rs.next()){
				Zhaoling zl = new Zhaoling();
				zl.setTitle(rs.getString("title"));
				zl.setTime(rs.getString("time"));
				zl.setImgurl(rs.getString("imgurl"));
				zl.setPlace(rs.getString("place"));
				zl.setDes(rs.getString("des"));
				zl.setCon(rs.getString("contact"));
				zl.setPhone(rs.getString("phone"));
				zl.setNickname(rs.getString("nickname"));
				return zl;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn,pstat,rs);
		}
		return null;
	}
}
