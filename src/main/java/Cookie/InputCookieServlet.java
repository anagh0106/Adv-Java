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

		Cookie c=new Cookie("Fname", fname);
		res.addCookie(c);
		res.sendRedirect("InputCookie.jsp");
			
	}
}
