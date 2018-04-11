package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dao.CaseDao;
import cn.vo.Zhaoling;

public class ZLCaseInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num = request.getParameter("num");
		CaseDao caseDao = new CaseDao();
		Zhaoling zl = caseDao.findZLCaseByNum(num);
		request.setAttribute("zl",zl);
		request.getRequestDispatcher("/zlcaseinfo.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}