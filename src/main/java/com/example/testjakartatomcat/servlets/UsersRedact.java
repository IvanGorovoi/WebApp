package com.example.testjakartatomcat.servlets;

import com.example.testjakartatomcat.DAO.UsersDAO;
import com.example.testjakartatomcat.Model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UsersRedact", urlPatterns = "/usersRedact")
public class UsersRedact extends HttpServlet {
    Users user1;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        UsersDAO usersDAO = (UsersDAO) this.getServletContext().getAttribute("usersDAO");
        user1 = usersDAO.getUser(Integer.parseInt(req.getParameter("id")));
        if(user1==null){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req, resp);
        }
        req.setAttribute("user", user1);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/UsersRedact.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersDAO usersDAO = (UsersDAO) this.getServletContext().getAttribute("usersDAO");
        Users user = new Users();
        user.setId(user1.getId());
        user.setNickname(req.getParameter("nickname"));
        user.setNative_country(req.getParameter("native_country"));
        user.setRegistration_date(req.getParameter("registration_date"));
        user.setExtra_guard(req.getParameter("extra_guard")!=null);
        user.setBalance(Float.parseFloat(req.getParameter("balance")));
        usersDAO.redact(user);
        resp.sendRedirect("users");
    }
}

