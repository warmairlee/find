package cn.servlet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;

public class CheckCodeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		response.setContentType("image/jpeg");
		OutputStream out = response.getOutputStream();
		try{
			response.setHeader("programa","no-cache");
			response.setHeader("Cache-Control","no-cache");
			response.setDateHeader("Exoieres",0);
			BufferedImage image=new BufferedImage(50,18,BufferedImage.TYPE_INT_RGB);
			Graphics g = image.getGraphics();
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, 50, 18);
			g.setColor(Color.LIGHT_GRAY);
			g.drawRect(0, 0, 50, 18);
			String str="23456789abcdefghijkmnpqrstuvwxyz";
			String code="";
			for(int i=0; i<4;i++)
			{
				int k=(int )(Math.random()*32);
				char c=str.charAt(k);
				code+=c;
			}
			
			HttpSession session=request.getSession();
			session.setAttribute("code", code);
			g.setColor(Color.BLACK);
			Font font = new Font("DIALOG",Font.ITALIC,15);
			g.setFont(font);
			g.drawString(code,3,15);
			ImageIO.write(image, "JPEG", out);
			out.flush();
			out.close();
		}finally{out.close();}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		doGet(request,response);
	}

}
