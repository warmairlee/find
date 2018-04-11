 package cn.servlet;

import java.io.File;
import java.io.IOException;
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
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.dao.ZhaolingDao;
import cn.method.GetRandomString;
import cn.vo.User;
import cn.vo.Zhaoling;

public class ZhaolingServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    // �ϴ�����
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

	
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
            items=upload.parseRequest(request); //���ǰ̨�ύ��������Ϣ�����ࣺ�ļ���form����
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        Iterator<FileItem> itr=items.iterator();
        
        String[] a =new String[8];
        int b=0;
        while(itr.hasNext()){
            FileItem item=(FileItem)itr.next();
            if(item.isFormField()){
                //�Ǳ�������
                a[b] = item.getString("utf-8");
                b++;
                
            }else if(!"".equals(item.getName())){//����form�������ݶ����ļ��ϴ�
            	try{
            		 // ��������ļ��ϴ�ֵ
                    upload.setFileSizeMax(MAX_FILE_SIZE);
                    // �����������ֵ (�����ļ��ͱ�������)
                    upload.setSizeMax(MAX_REQUEST_SIZE);
                    //�ϴ���Ӳ�̵�һ������·��
                    GetRandomString grs = new GetRandomString();
                    String rand = grs.getRandomString(15);
                    String uploadPath ="E:/Workspaces/find/WebRoot/upload/zhaoling/"+phone;  //����Ŀ¼
                    String fileName1 = new File(item.getName()).getName();
                    String fileName2 = fileName1.replaceAll("\\(|\\)|\\{|\\}|%|#|~", "");
                    String fileName = rand + fileName2.substring(0,5)+".png";
                    String filePath = uploadPath + File.separator + fileName;
                    imgurl = "/upload/zhaoling/"+phone+ File.separator + fileName ;
                    imgurl = imgurl.replaceAll("\\\\", "/");
                    File uploadDir = new File(uploadPath);
                    if (!uploadDir.exists()) {
                        uploadDir.mkdir();
                    }
                    item.write(new File(filePath));
                    
                    
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
			request.getRequestDispatcher("/fbzlqs.jsp").forward(request, response);
			return;
		}
		
		
		Zhaoling zl = new Zhaoling();
		zl.setTitle(title);
		zl.setTime(time);
		zl.setPlace(place);
		zl.setDes(des);
		zl.setCon(con);
		zl.setImgurl(imgurl);
		zl.setPhone(phone);
		
		ZhaolingDao zhaolingDao = new ZhaolingDao();
		boolean result = zhaolingDao.addzl(zl);
		if(result){
			request.setAttribute("msg", "�����������³ɹ���");
			request.getRequestDispatcher("/servlet/ZLCaseListServlet").forward(request, response);
			return;
		}else{
			request.getRequestDispatcher("/fbzlqs.jsp").forward(request, response);
			return;
		}
	}
}