package Cookie;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InputCookieServlet")
public class InputCookieServlet extends HttpServlet{
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		
//		boolean isError=false;
//		
//		if(fname==null || fname.trim().length()==0) {
//			isError=true;
//			req.setAttribute("fnameError", "Enter First Name");
//		}
//		if(lname==null || lname.trim().length()==0) {
//			isError=true;
//			req.setAttribute("lnameError", "Enter Last Name");
//		}
//		if(isError==true) {
//			req.getRequestDispatcher("InputCookie.jsp").forward(req, res);
//		}
		Cookie c=new Cookie("Fname", fname);
		Cookie c1=new Cookie("Lname",lname);
		
		res.addCookie(c);
		res.addCookie(c1);
		
		res.sendRedirect("InputCookie.jsp");
			
	}
}
