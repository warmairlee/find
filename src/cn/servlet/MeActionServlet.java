package cn.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.dao.UserDao;
import cn.vo.User;

public class MeActionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 15; // 15MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 20; // 20MB

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		boolean check =false;
		User user = (User)request.getSession().getAttribute("loginUser");
		String phone = user.getPhone();
		String userheadp = user.getHeadp();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory .setSizeThreshold(MEMORY_THRESHOLD);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List<FileItem> items = null;
		
		try {
			items=upload.parseRequest(request); //获得前台提交过来的信息，两类：文件、form表单
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		Iterator<FileItem> itr = items.iterator();
		
		String[] a = new String [3];
		int b = 0;
		while(itr.hasNext()){
			FileItem item = (FileItem)itr.next();
			if(item.isFormField()){//是表单数据
				a[b] = item.getString("utf-8");
				b++;
			}if("".equals(item.getName())){
				check = true;
			}if(!"".equals(item.getName())){
				try {
					upload.setFileSizeMax(MAX_FILE_SIZE);
				    upload.setFileSizeMax(MAX_REQUEST_SIZE);
				    String uploadPath = "E:/Workspaces/find/WebRoot/upload/user/"+phone+"headp";
				    System.out.println(uploadPath);
				    String fileName1 = new File(item.getName()).getName();
				    String fileName2 = fileName1.replaceAll("\\(|\\)|\\{|\\}|%|#|~", "");
				    String fileName = fileName2.substring(0,10);
				    String filePath = uploadPath + File.separator + fileName;
				    userheadp = "/upload/user"+File.separator+phone+"headp" + File.separator + fileName;
				    userheadp = userheadp.replaceAll("\\\\", "/");//数据库保存路径
				    File uploadDir = new File(uploadPath);
				    if (!uploadDir.exists()) {
                        uploadDir.mkdir();
                    }
				    item.write(new File(filePath));
				    check = true;
				    } catch (Exception e) {
					    e.printStackTrace();
				    }
				}
			}
				
		String nickname = a[0];
		String email = a[1];
		String ag = a[2];
		UserDao userdao = new UserDao();
		boolean check2 = userdao.updateInfo(phone,nickname,email,ag,userheadp);
		if(check2 && check){
			user.setAutograph(ag);
			user.setEmail(email);
			user.setNickname(nickname);
			user.setHeadp(userheadp);
			request.setAttribute("loginUser", user);
			request.setAttribute("agmsg", "修改基本信息成功！");
			request.getRequestDispatcher("/me.jsp").forward(request, response);
			return;
		}
		else{
			request.setAttribute("agmsg", "修改基本信息失败！");
			request.getRequestDispatcher("/me.jsp").forward(request, response);
			return;
		}
	}

}
