package cn.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.dao.XunwuDao;
import cn.method.GetMD5;
import cn.method.GetRandomString;
import cn.vo.User;
import cn.vo.Xunwu;

public class XunwuServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    // �ϴ�����
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 15; // 15MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 20; // 20MB
    

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		boolean check = false;
		User user = (User)request.getSession().getAttribute("loginUser");
		String phone = user.getPhone();
		String imgurl = null;
		String code = (String )request.getSession().getAttribute("code");
		// �����ϴ�����
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // �����ڴ��ٽ�ֵ - �����󽫲�����ʱ�ļ����洢����ʱĿ¼��
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // ������ʱ�洢Ŀ¼
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        List<FileItem> items=null;
        
        try {
            items=upload.parseRequest(request); //���ǰ̨�ύ��������Ϣ�����ࣺ�ļ���form��
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        Iterator<FileItem> itr=items.iterator();
        
        String[] a =new String[8];
        int b=0;
        while(itr.hasNext()){
            FileItem item=(FileItem)itr.next();
            if(item.isFormField()){
                //�Ǳ�����
                a[b] = item.getString("utf-8");
                b++;
                
            }else if(!"".equals(item.getName())){//����form�����ݶ����ļ��ϴ�
            	try{
            		 // ��������ļ��ϴ�ֵ
                    upload.setFileSizeMax(MAX_FILE_SIZE);
                      
                    // �����������ֵ (�����ļ��ͱ�����)
                    upload.setSizeMax(MAX_REQUEST_SIZE);
                    GetRandomString grs = new GetRandomString();
                    String rand = grs.getRandomString(15);
                    String uploadPath ="E:/Workspaces/find/WebRoot/upload/xunwu/"+phone;  //����Ŀ¼
                    String fileName1 = new File(item.getName()).getName();
                    String fileName2 = fileName1.replaceAll("\\(|\\)|\\{|\\}|%|#|~", "");
                    String fileName = rand + fileName2.substring(0,5)+".png";
                    String filePath = uploadPath + File.separator + fileName;
                    File uploadDir = new File(uploadPath);
                    if (!uploadDir.exists()) {
                        uploadDir.mkdir();
                    }
                    item.write(new File(filePath));
                    
                    imgurl = "/upload/xunwu/"+phone+ File.separator + fileName;
                    imgurl = imgurl.replaceAll("\\\\","/");
                    
                    
                }catch(Exception e){
                    e.printStackTrace();
                    check = true;
                    request.setAttribute("timsg", "ϵͳ����");
                }
            }
        }
		
		

		String title = a[0];
		String year = a[1];
		String month = a[2];
		String day = a[3];
		String place = a[4];
		String des = a[5];
		String con = a[6];
		String checkcode = a[7];
		String time = year+"-"+month+"-"+day;
		
		
		
		if("".equals(title)){
			request.setAttribute("timsg", "���ⲻ��Ϊ��");
			check = true;
		}
		
		if("".equals(place)){
			request.setAttribute("pmsg", "�ص㲻��Ϊ��");
			check = true;
		}
		if("".equals(des)){
			request.setAttribute("dmsg", "��������Ϊ��");
			check = true;
		}
		if("".equals(con)){
			request.setAttribute("cmsg", "��ϵ��ʽ����Ϊ��");
			check = true;
		}if("".equals(checkcode) || !checkcode.equals(code)){
			request.setAttribute("codemsg", "��֤�����");
			check = true;
		}
		
		if(check == true){
			request.setAttribute("title", title);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("day", day);
			request.setAttribute("place", place);
			request.setAttribute("des", des);
			request.setAttribute("con", con);
			request.getRequestDispatcher("/fbxwqs.jsp").forward(request, response);
			return;
		}
		

		
		
		
		Xunwu xw = new Xunwu();
		xw.setTitle(title);
		xw.setTime(time);
		xw.setPlace(place);
		xw.setDes(des);
		xw.setCon(con);
		xw.setImgurl(imgurl);
		xw.setPhone(phone);
		
		XunwuDao xunwuDao = new XunwuDao();
		boolean result = xunwuDao.addzl(xw);
		if(result){
			request.setAttribute("msg", "����Ѱ�����³ɹ���");
			request.getRequestDispatcher("/servlet/XWCaseListServlet").forward(request, response);
			return;
		}else{
			request.getRequestDispatcher("/fbxwqs.jsp").forward(request, response);
			return;
		} 
	}
}
