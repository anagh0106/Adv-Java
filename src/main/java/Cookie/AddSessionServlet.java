package Cookie;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddSessionServlet")
public class AddSessionServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	String fname=req.getParameter("fname");
	
	HttpSession session=req.getSession();
	session.setAttribute("fnamesession", fname);
	res.sendRedirect("ViewSession.jsp");
	
	}
}
