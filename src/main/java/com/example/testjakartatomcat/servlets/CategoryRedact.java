package com.example.testjakartatomcat.servlets;

import com.example.testjakartatomcat.DAO.CategoryDAO;
import com.example.testjakartatomcat.Model.Category;
import jakarta.validation.constraints.Null;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategoryRedact", urlPatterns = "/categoryRedact")
public class CategoryRedact extends HttpServlet {
    Category cat;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        CategoryDAO categoryDAO = (CategoryDAO) this.getServletContext().getAttribute("categoryDAO");
        cat = categoryDAO.getCategory(Integer.parseInt(req.getParameter("id")));
        if(cat==null){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req, resp);
        }
        req.setAttribute("category", cat);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/CategoryRedact.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDAO categoryDAO = (CategoryDAO) this.getServletContext().getAttribute("categoryDAO");
        Category category = new Category();
        category.setId(cat.getId());
        category.setTitle(req.getParameter("title"));
        category.setSingleplayer(req.getParameter("singleplayer")!=null);
        category.setMultiplayer(req.getParameter("multiplayer")!=null);
        category.setNot_for_all(req.getParameter("not_for_all")!=null);
        categoryDAO.redact(category);
        resp.sendRedirect("category");
    }
}

