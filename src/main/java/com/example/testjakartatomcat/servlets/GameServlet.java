package com.example.testjakartatomcat.servlets;

import com.example.testjakartatomcat.DAO.CategoryDAO;
import com.example.testjakartatomcat.DAO.GamesDAO;
import com.example.testjakartatomcat.Model.Games;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "GameServlet", urlPatterns = "/games")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GamesDAO gamesDAO = (GamesDAO) this.getServletContext().getAttribute("gamesDAO");
        req.setAttribute("games",gamesDAO.selectAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Games.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GamesDAO gamesDAO = (GamesDAO) this.getServletContext().getAttribute("gamesDAO");
        CategoryDAO categoryDAO = (CategoryDAO) this.getServletContext().getAttribute("categoryDAO");
        Games game = new Games();
        if(req.getParameter("title")!=""
                &&req.getParameter("publisher")!=""
                &&req.getParameter("developer")!=""
                &&(req.getParameter("category_id")==""
                ||categoryDAO.getCategory(Integer.parseInt(req.getParameter("category_id")))!=null))
        {
            if(req.getParameter("price")=="" ||req.getParameter("price")=="Null")game.setPrice(0);

            else game.setPrice(Integer.parseInt(req.getParameter("price")));

            game.setTitle(req.getParameter("title"));
            game.setPublisher(req.getParameter("publisher"));
            game.setDeveloper(req.getParameter("developer"));
            game.setAbout_game(req.getParameter("about_game"));
            game.setCategory_id(Integer.parseInt(req.getParameter("category_id")));
            gamesDAO.insert(game);
        }
        resp.sendRedirect("games");
    }
}
