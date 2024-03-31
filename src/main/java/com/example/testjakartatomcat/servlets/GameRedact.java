package com.example.testjakartatomcat.servlets;

import com.example.testjakartatomcat.DAO.GamesDAO;
import com.example.testjakartatomcat.Model.Games;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GameRedact", urlPatterns = "/gameRedact")
public class GameRedact extends HttpServlet {
    public Games game;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GamesDAO gamesDAO = (GamesDAO) this.getServletContext().getAttribute("gamesDAO");
        Games game = gamesDAO.getGame(Integer.parseInt(req.getParameter("id")));
        if(game==null){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req, resp);
        }
        req.setAttribute("game", game);
        this.game = game;
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/GamesRedact.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GamesDAO gamesDAO = (GamesDAO) this.getServletContext().getAttribute("gamesDAO");
        Games g = new Games();
        g.setId(game.getId());
        g.setPrice(Integer.parseInt(req.getParameter("price")));
        g.setCategory_id(Integer.parseInt(req.getParameter("category_id")));
        g.setPublisher(req.getParameter("publisher"));
        g.setTitle(req.getParameter("title"));
        g.setDeveloper(req.getParameter("developer"));
        g.setAbout_game(req.getParameter("about_game"));
        gamesDAO.redact(g);
        resp.sendRedirect("games");
    }
}