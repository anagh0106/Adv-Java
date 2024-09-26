package Cookie;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignUpUserServletCookie")
public class SignUpUserServletCookie extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		String user=req.getParameter("user");
		String mail=req.getParameter("mail");
		String pass=req.getParameter("pass");
		
		Cookie c1 = new Cookie("user", user);
        Cookie c2 = new Cookie("mail", mail);
        Cookie c3 = new Cookie("pass", pass);
        
        res.addCookie(c1);
        res.addCookie(c2);
        res.addCookie(c3);
        
        res.sendRedirect("SuccessLogin.jsp");
	}
}