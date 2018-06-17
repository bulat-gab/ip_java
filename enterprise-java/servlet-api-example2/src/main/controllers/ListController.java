package main.controllers;

import main.services.StudentService;
import main.services.StudentServiceImpl;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 19.04.2017.
 */
public class ListController extends HttpServlet {
    static {
        PropertyConfigurator.configure(LoginServlet.class.getClassLoader().getResource("log4j.properties"));
    }

    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

    private static StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setAttribute("value", "Hello, Student!");
        LOGGER.debug("ListController doGet");

        req.setAttribute("list", studentService.getAllStudents());

        getServletContext().getRequestDispatcher("/listStudents.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("ListController doPost");

        String idToDelete = req.getParameter("idToDelete");
        String idToEdit = req.getParameter("idToEdit");

        if(idToDelete != null){
            boolean validationFailed = false;
            long id = -1;
            try {
                id = Long.parseLong(idToDelete);
            } catch (NumberFormatException ex){
                LOGGER.debug("ListController doPost idToDelete = " + idToDelete);
                validationFailed = true;
            }

            if (id < 0)
                validationFailed = true;

            if(validationFailed){
                resp.sendRedirect(req.getContextPath() + "/error");
                return;
            }

            studentService.deleteById(id);

            req.setAttribute("list", studentService.getAllStudents());
            getServletContext().getRequestDispatcher("/listStudents.jsp").forward(req, resp);
        }
        if(idToEdit != null){
            req.getSession().setAttribute("idToEdit", idToEdit);
            resp.sendRedirect(req.getContextPath() + "/editStudent");
        }
    }


}
