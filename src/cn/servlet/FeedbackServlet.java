package cn.servlet;


import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.utils.JdbcUtil;


public class FeedbackServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String des = request.getParameter("des");
		boolean check = false;
		if(title==null || "".equals(title)){
			request.setAttribute("tmsg", "请输入标题");
			check = true;
		}
		if(des==null || "".equals(des)){
			request.setAttribute("dmsg", "请输入内容");
			check = true;
		}
		if(check){
			request.setAttribute("title", title);
			request.setAttribute("des", des);
			request.getRequestDispatcher("/feedback.jsp").forward(request, response);
			return;
		}
		
		
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs =null;
		int row = 0;
		conn = JdbcUtil.getConn();
		try {
			pstat = conn.prepareStatement("insert into feedback(phone,title,des) values(?,?,?)");
			pstat.setString(1, "test");
			pstat.setString(2, title);
			pstat.setString(3, des);
			row = pstat.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstat, rs);
		}
		if(row>0){
			request.setAttribute("msg", "提交成功，感谢您的反馈！"); 
			request.getRequestDispatcher("/feedback.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/feedback.jsp").forward(request, response);
		}
	}

}
