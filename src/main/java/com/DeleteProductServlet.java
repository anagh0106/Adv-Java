package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String dburl = "jdbc:mysql://localhost:3306/royal";
        String user = "root";
        String pass = "root";
        String Classurl = "com.mysql.cj.jdbc.Driver";

        String pname = req.getParameter("pname");

        boolean isError = false;

        if (pname == null || pname.trim().length() == 0) {
            isError = true;
            req.setAttribute("PnameError", "Enter ProductName");
        }

        if (isError) {
            req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
            return;  // Stop further execution if there's an error
        }

        Connection c = null;
        PreparedStatement ps,ps1 = null;

        try {
            Class.forName(Classurl);
            c = DriverManager.getConnection(dburl, user, pass);
            String q = "delete from MyProducts where ProductName = ?";
            ps = c.prepareStatement(q);
            ps.setString(1, pname);
            ps.executeUpdate();
            ps1=c.prepareStatement("select * from myproducts");
            ResultSet rs=ps1.executeQuery();
            
            req.setAttribute("rs", rs);
           
            req.getRequestDispatcher("OutputOfDeleteProductName.jsp").forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}