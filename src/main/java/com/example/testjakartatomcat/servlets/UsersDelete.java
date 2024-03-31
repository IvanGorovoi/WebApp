package com.example.testjakartatomcat.servlets;

import com.example.testjakartatomcat.DAO.GamesDAO;
import com.example.testjakartatomcat.DAO.LibraryDAO;
import com.example.testjakartatomcat.DAO.UsersDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UsersDelete", urlPatterns = "/usersDelete")
public class UsersDelete extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersDAO usersDAO = (UsersDAO) this.getServletContext().getAttribute("usersDAO");
        LibraryDAO libraryDAO = (LibraryDAO) this.getServletContext().getAttribute("libraryDAO");
        if(libraryDAO.getNumsGames(Integer.parseInt(req.getParameter("id")))==0){
            usersDAO.delete(Integer.parseInt(req.getParameter("id")));
        }
        resp.sendRedirect("users");
    }
}
