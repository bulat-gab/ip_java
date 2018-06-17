package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gab on 05.Mar.2018
 */
@WebServlet(name = "hello", urlPatterns = {"/1"})
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("qwe", 10);
        getServletContext().getRequestDispatcher("/page.jsp").forward(req, resp);
    }
}