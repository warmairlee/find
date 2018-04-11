package cn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dao.UserDao;
import cn.vo.User;

public class RegistServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		String pwd2 = request.getParameter("pwd2");
		String nickname = request.getParameter("nickname");
		String checkcode = request.getParameter("checkcode");
		String code = (String )request.getSession().getAttribute("code");
		boolean check = false;
		if(phone==null || "".equals(phone)){
			request.setAttribute("pmsg","手机号不得为空");
			check = true;
		}
		if(pwd==null || "".equals(pwd)){
			request.setAttribute("pwdmsg","密码不得为空");
			check = true;
		}
		if(pwd2==null || "".equals(pwd2)){
			request.setAttribute("pwd2msg","确认密码不得为空");
			check = true;
		}
		if(!pwd.equals(pwd2)){
			request.setAttribute("pwd2msg","确认密码不一致");
			check = true;
		}
		if(nickname==null || "".equals(nickname)){
			request.setAttribute("nmsg","昵称不得为空");
			check = true;
		}if(checkcode==null || "".equals(checkcode) || !checkcode.equals(code)){
			request.setAttribute("codemsg","验证码错误");
			check = true;
		}
		
		if(check){
			request.setAttribute("phone", phone);
			request.setAttribute("nickname", nickname);
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		
		UserDao userDao = new UserDao();
		
		boolean isHave = userDao.IsHave(phone);
		if(isHave){
			request.setAttribute("pmsg", "用户已经存在！");
			request.setAttribute("phone", phone);
			request.setAttribute("nickname", nickname);
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}
		
		User user = new User();
		user.setPhone(phone);
		user.setPwd(pwd);
		user.setNickname(nickname);
		
		boolean result = userDao.addUser(user);
		if(result){
			request.setAttribute("msg", "注册成功！现在您可以登录 “去找找” 平台！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		}
			
	}

}
