package com.example.testjakartatomcat.servlets;

import com.example.testjakartatomcat.DAO.GamesDAO;
import com.example.testjakartatomcat.DAO.LibraryDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GameDelete", urlPatterns = "/gameDelete")
public class GameDelete extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GamesDAO gamesDAO = (GamesDAO) this.getServletContext().getAttribute("gamesDAO");
        LibraryDAO libraryDAO = (LibraryDAO) this.getServletContext().getAttribute("libraryDAO");
        if(libraryDAO.getNumsUsers(Integer.parseInt(req.getParameter("id")))==0){
            gamesDAO.delete(Integer.parseInt(req.getParameter("id")));
        }
        resp.sendRedirect("games");
    }
}
