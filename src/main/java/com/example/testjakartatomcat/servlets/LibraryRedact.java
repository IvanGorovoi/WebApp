package com.example.testjakartatomcat.servlets;

import com.example.testjakartatomcat.DAO.LibraryDAO;
import com.example.testjakartatomcat.Model.Library;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LibraryRedact", urlPatterns = "/libraryRedact")
public class LibraryRedact extends HttpServlet {
    public Library libr;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LibraryDAO libraryDAO = (LibraryDAO) this.getServletContext().getAttribute("libraryDAO");
        Library library = libraryDAO.getLibrary(Integer.parseInt(req.getParameter("game_id")),Integer.parseInt(req.getParameter("user_id")));
        if(library==null){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req, resp);
        }
        req.setAttribute("lib", library);
        this.libr = library;
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/LibraryRedact.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LibraryDAO libraryDAO = (LibraryDAO) this.getServletContext().getAttribute("libraryDAO");
        Library library = new Library();
        library.setGame_id(libr.getGame_id());
        library.setUser_id(libr.getUser_id());
        library.setActivity(Float.parseFloat(req.getParameter("activity")));
        library.setPurchare_date(req.getParameter("purchare_date"));
        libraryDAO.redact(library);
        resp.sendRedirect("library");
    }
}