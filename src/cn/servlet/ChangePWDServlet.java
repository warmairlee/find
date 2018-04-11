package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dao.UserDao;
import cn.vo.User;

public class ChangePWDServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String pwd1 = request.getParameter("pwd1");
		String pwd2 = request.getParameter("pwd2");
		String pwd3 = request.getParameter("pwd3");
		User user = (User)request.getSession().getAttribute("loginUser");
		String phone = user.getPhone();
		String pwd  = user.getPwd();
		if (!pwd1.equals(pwd) || pwd1 == null || "".equals(pwd1)){
			request.setAttribute("msg1", "ԭ�������");
			request.getRequestDispatcher("/changepwd.jsp").forward(request, response);
			return;
		}if("".equals(pwd2) || pwd2 == null){
			request.setAttribute("msg2", "�����벻��Ϊ�գ�");
			request.getRequestDispatcher("/changepwd.jsp").forward(request, response);
			return;
		}if("".equals(pwd3) || pwd3 == null){
			request.setAttribute("msg2", "ȷ�����벻��Ϊ�գ�");
			request.getRequestDispatcher("/changepwd.jsp").forward(request, response);
			return;
		}if(!pwd2.equals(pwd3)){
			request.setAttribute("msg2", "��������ȷ�����벻һ�£�");
			request.getRequestDispatcher("/changepwd.jsp").forward(request, response);
			return;
		}if(pwd1.equals(pwd2)){
			request.setAttribute("msg2", "��������ԭ����һ�£�");
			request.getRequestDispatcher("/changepwd.jsp").forward(request, response);
			return;
		}else{
			UserDao userDao = new UserDao();
			boolean check = userDao.changePWD(phone, pwd2);
			if(check){
				request.setAttribute("msg", "�����޸ĳɹ��������µ�¼");
				request.getSession().removeAttribute("loginUser");
				request.getSession().invalidate();
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}
		}
		
	}
}
