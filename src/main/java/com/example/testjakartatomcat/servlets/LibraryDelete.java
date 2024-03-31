package com.example.testjakartatomcat.servlets;

import com.example.testjakartatomcat.DAO.LibraryDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LibraryDelete", urlPatterns = "/libraryDelete")
public class LibraryDelete extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LibraryDAO libraryDAO = (LibraryDAO) this.getServletContext().getAttribute("libraryDAO");
        libraryDAO.delete(Integer.parseInt(req.getParameter("game_id")),Integer.parseInt(req.getParameter("user_id")));
        resp.sendRedirect("library");
    }
}
