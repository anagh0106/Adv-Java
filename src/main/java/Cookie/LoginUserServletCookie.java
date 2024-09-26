package Cookie;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginUserServletCookie")
public class LoginUserServletCookie extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {

        Cookie usercookie = null;
        Cookie passcookie = null;
        Cookie[] cookies = req.getCookies();

        // Check if the cookies already exist
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("user".equals(cookie.getName())) {
                    usercookie = cookie;
                }
                if ("pass".equals(cookie.getName())) {
                    passcookie = cookie;
                }
            }
        }

        // If either cookie is missing, redirect to the sign-up page
        if (usercookie == null || passcookie == null) {
            res.sendRedirect("SignUpUser.jsp");
        } else {
            // Otherwise, retrieve the username and password from the request
            String user = req.getParameter("user");
            String pass = req.getParameter("pass");

            // Create new cookies with the user and pass
            Cookie c1 = new Cookie("user", user);
            Cookie c2 = new Cookie("pass", pass);

            // Add cookies to the response
            res.addCookie(c1);
            res.addCookie(c2);

            // Redirect to the success page
            res.sendRedirect("SuccessLogin.jsp");
        }
    }
}
