package Cookie;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AgeCookieServlet")
public class AgeCookieServlet extends HttpServlet{
	protected void service(HttpServletRequest req,HttpServletResponse res)
			throws ServletException, IOException {
		
		String age=req.getParameter("age");
		
		// Create Cookie
		Cookie c=new Cookie("age",age);
		
		res.addCookie(c);
		
		res.sendRedirect("AgeCookie.jsp");
		
	}
}
