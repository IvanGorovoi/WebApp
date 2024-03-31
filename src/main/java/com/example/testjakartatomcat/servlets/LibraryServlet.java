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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@WebServlet(name = "LibraryServlet", urlPatterns = "/library")
public class LibraryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LibraryDAO libraryDAO = (LibraryDAO) this.getServletContext().getAttribute("libraryDAO");
        req.setAttribute("library",libraryDAO.selectAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Library.jsp");
        requestDispatcher.forward(req, resp);
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Library library = new Library();
        if(req.getParameter("game_id")!=""&&req.getParameter("user_id")!=""){
            library.setGame_id(Integer.parseInt(req.getParameter("game_id")));
            library.setUser_id(Integer.parseInt(req.getParameter("user_id")));
            if(req.getParameter("activity")!="")library.setActivity(Float.parseFloat(req.getParameter("activity")));
            else library.setActivity(0.0f);

            long currentTimeMillis = System.currentTimeMillis();
            Timestamp currentTimestamp = new Timestamp(currentTimeMillis);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = sdf.format(currentTimestamp);
            library.setPurchare_date(formattedDate);

            LibraryDAO libraryDAO = (LibraryDAO) this.getServletContext().getAttribute("libraryDAO");
            libraryDAO.insert(library);
        }
        resp.sendRedirect("library");
    }
}
