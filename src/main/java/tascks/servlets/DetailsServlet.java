package tascks.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tascks.service.DBManager;

import java.io.IOException;

@WebServlet("/details")
public class DetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Long id = Long.parseLong(req.getParameter("id"));
        req.setAttribute("task", DBManager.findById(id));
        req.getRequestDispatcher("/details.jsp").forward(req, resp);
    }

}