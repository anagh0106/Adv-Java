package Cookie;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet{

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie c=new Cookie("Fname","");
		c.setMaxAge(0);
		res.addCookie(c);
	
		HttpSession session=req.getSession();
		session.invalidate(); // to destroy session
		
		res.sendRedirect("InputCookie.jsp");
	}
}
