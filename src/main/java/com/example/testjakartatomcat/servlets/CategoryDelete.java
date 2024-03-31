package com.example.testjakartatomcat.servlets;

import com.example.testjakartatomcat.DAO.CategoryDAO;
import com.example.testjakartatomcat.DAO.GamesDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategoryDelete", urlPatterns = "/categoryDelete")
public class CategoryDelete extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDAO categoryDAO = (CategoryDAO) this.getServletContext().getAttribute("categoryDAO");
        GamesDAO gamesDAO = (GamesDAO) this.getServletContext().getAttribute("gamesDAO");
        if(categoryDAO.getCategory(Integer.parseInt(req.getParameter("id")))!=null
                &&gamesDAO.getNumsCategory(Integer.parseInt(req.getParameter("id")))==0){
            categoryDAO.delete(Integer.parseInt(req.getParameter("id")));
        }
        resp.sendRedirect("category");
    }
}
