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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

    @WebServlet(name = "UsersServlet", urlPatterns = "/users")
    public class UsersServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            UsersDAO usersDAO = (UsersDAO) this.getServletContext().getAttribute("usersDAO");
            req.setAttribute("users",usersDAO.selectAll());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Users.jsp");
            requestDispatcher.forward(req, resp);
        }
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            UsersDAO usersDAO = (UsersDAO) this.getServletContext().getAttribute("usersDAO");
            Users user = new Users();
            if(req.getParameter("nickname")!="")
            {
                user.setNickname(req.getParameter("nickname"));
                user.setExtra_guard(req.getParameter("extra_guard")!=null);
                user.setNative_country(req.getParameter("native_country"));

                long currentTimeMillis = System.currentTimeMillis();
                Timestamp currentTimestamp = new Timestamp(currentTimeMillis);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = sdf.format(currentTimestamp);
                user.setRegistration_date(formattedDate);

                if(req.getParameter("balance")=="" ||req.getParameter("balance")=="Null") {
                    user.setBalance(0);
                }
                else user.setBalance(Float.parseFloat(req.getParameter("balance")));
                usersDAO.insert(user);
            }
            resp.sendRedirect("users");
        }
    }
