package com.example.testjakartatomcat.servlets;

import com.example.testjakartatomcat.DAO.CategoryDAO;
import com.example.testjakartatomcat.DAO.GamesDAO;
import com.example.testjakartatomcat.DAO.LibraryDAO;
import com.example.testjakartatomcat.DAO.UsersDAO;
import com.example.testjakartatomcat.DBSQL.DBConnect;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);

        DBConnect con = new DBConnect();
        LibraryDAO libraryDAO = new LibraryDAO(con.connect());
        GamesDAO gamesDAO = new GamesDAO(con.connect());
        UsersDAO usersDAO = new UsersDAO(con.connect());
        CategoryDAO categoryDAO = new CategoryDAO(con.connect());
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("libraryDAO",libraryDAO);
        sc.setAttribute("gamesDAO",gamesDAO);
        sc.setAttribute("usersDAO",usersDAO);
        sc.setAttribute("categoryDAO",categoryDAO);
    }
}
