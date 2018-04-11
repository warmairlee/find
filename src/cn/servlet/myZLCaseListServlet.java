package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dao.CaseDao;
import cn.vo.User;
import cn.vo.Zhaoling;

public class myZLCaseListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User user = (User)request.getSession().getAttribute("loginUser");
		String phone = user.getPhone();
		String title = request.getParameter("title");
		String year1 = request.getParameter("year1");
		String month1 = request.getParameter("month1");
		String day1 = request.getParameter("day1");
		String year2 = request.getParameter("year2");
		String month2 = request.getParameter("month2");
		String day2 = request.getParameter("day2");
		String place = request.getParameter("place");
		String tmp = request.getParameter("curPage");
		if(title==null){
			title = "";
		}
		if(year1==null){
			year1 = "2014";
		}
		if(month1==null){
			month1 = "1";
		}
		if(day1==null){
			day1 = "1";
		}
		if(year2==null){
			year2 = "2018";
		}
		if(month2==null){
			month2 = "12";
		}
		if(day2==null){
			day2 = "31";
		}
		if(place==null){
			place = "";
		}
		if(tmp==null){
			 tmp="1";
		}  
	    int curPage = Integer.parseInt(tmp); 
	    String time1 = year1+"-"+month1+"-"+day1;
		String time2 = year2+"-"+month2+"-"+day2;
		CaseDao caseDao = new CaseDao();
		int pageCount = caseDao.findmyZLPageCount(phone);
		if(curPage>pageCount){
			curPage=pageCount;
		}
	    List<Zhaoling> list = caseDao.findmyZLCaseByKey(title.trim(), time1.trim(),time2.trim(),place.trim(),curPage,phone.trim());
		request.setAttribute("list",list);
		request.setAttribute("point","1");
		request.setAttribute("pageCount",pageCount);
		request.setAttribute("curPage",curPage);
		request.setAttribute("title",title);
		request.setAttribute("time1",time1);
		request.setAttribute("time2",time2);
		request.setAttribute("place",place);
		
		request.getRequestDispatcher("/myzl.jsp").forward(request, response);
	}

}
