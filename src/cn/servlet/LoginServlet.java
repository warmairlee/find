package cn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dao.UserDao;
import cn.vo.User;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		String checkcode = request.getParameter("checkcode");
		String code = (String )request.getSession().getAttribute("code");
		boolean check = false;
		if(phone==null || "".equals(phone)){
			request.setAttribute("pmsg", "用户名不能为空！");
			check = true;
		}if(pwd==null || "".equals(pwd)){
			request.setAttribute("pwmsg", "密码不能为空");
			check = true;
		}if(checkcode==null || "".equals(checkcode) || !checkcode.equals(code)){
			request.setAttribute("codemsg", "验证码错误");
			check = true;
		}
		if(check){
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		UserDao userDao = new UserDao();
		User user = userDao.login(phone,pwd);
		if(user!=null){
			request.getSession().setAttribute("loginUser", user);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			request.setAttribute("pmsg", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
