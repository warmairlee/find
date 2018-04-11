package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.vo.User;

public class IsLoginZLServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		User user = (User)request.getSession().getAttribute("loginUser");
		if(user==null){
			request.setAttribute("msg", "ÇëÏÈµÇÂ¼£¡");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}if(user!=null){
			request.getRequestDispatcher("/fbzlqs.jsp").forward(request, response);
			return;
		}
	}

}
