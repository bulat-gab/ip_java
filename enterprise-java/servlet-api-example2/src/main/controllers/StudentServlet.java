package main.controllers;

import main.model.pojo.Student;
import main.services.StudentService;
import main.services.StudentServiceImpl;
import main.services.UserServiceImpl;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 20.04.2017.
 */
public class StudentServlet extends HttpServlet {
    static {
        PropertyConfigurator.configure(LoginServlet.class.getClassLoader().getResource("log4j.properties"));
    }

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    private static StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("StudentServlet doGet");

        String idToEdit = (String)req.getSession().getAttribute("idToEdit");
        if(idToEdit != null){
            boolean validationFailed = false;
            long id = -1001;
            try {
                id = Long.parseLong(idToEdit);
            } catch (NumberFormatException ex){
                LOGGER.debug("StudentServlet doGet idToEdit = " + idToEdit);
                validationFailed = true;
            }

            if (id < -1000)
                validationFailed = true;

            if(validationFailed){
                resp.sendRedirect(req.getContextPath() + "/error");
                return;
            }

            Student student = null;
            if(id>0){
                student = studentService.getById(id);
            }

            if (student != null) {
                req.setAttribute("name", student.getName());
                req.setAttribute("age", student.getAge());
                req.setAttribute("groupId", student.getGroupId());
            } else {

                req.setAttribute("name", "");
                req.setAttribute("age", "");
                req.setAttribute("groupId", "");
            }

            getServletContext().getRequestDispatcher("/editStudent.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/listStudents");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("StudentServlet doPost");

        String idToEdit = (String)req.getSession().getAttribute("idToEdit");

        LOGGER.debug("StudentServlet doPost, id =" + idToEdit);

        boolean validationFailed = false;

        if(idToEdit != null){
            long id = -1;
            try {
                id = Long.parseLong(idToEdit);
            } catch (NumberFormatException ex){
                LOGGER.debug("StudentServlet doGet idToEdit = " + idToEdit);
                validationFailed = true;
            }

            if (id < -1)
                return;

            Student student = null;
            if(id>0){
                student = studentService.getById(id);
            }


            LOGGER.debug("StudentServlet doPost, student =" + student);

            String name = req.getParameter("name");
            String age = req.getParameter("age");
            String groupId = req.getParameter("groupId");


            LOGGER.debug("StudentServlet doPost, name =" + name);
            LOGGER.debug("StudentServlet doPost, age =" + age);
            LOGGER.debug("StudentServlet doPost, groupId =" + groupId);

            if((name==null)||(name.length()==0)||(age==null)||(groupId==null)){
                resp.sendRedirect(req.getContextPath() + "/error");
                return;
            }

            long ageValue = 0;
            try {
                ageValue =  Long.parseLong(age);
            } catch (NumberFormatException ex){
                LOGGER.debug("StudentServlet doGet age = " + age);
                validationFailed = true;
            }

            if (ageValue < 1)
                validationFailed = true;

            long groupIDValue = 0;
            try {
                groupIDValue = Long.parseLong(groupId);
            } catch (NumberFormatException ex){
                LOGGER.debug("StudentServlet doGet groupID = " + groupId);
                validationFailed = true;
            }

            if (groupIDValue < 1)
                validationFailed = true;

            if (validationFailed) {
                resp.sendRedirect(req.getContextPath() + "/error");
                return;
            }

            studentService.save(id, name, ageValue, groupIDValue);

            resp.sendRedirect(req.getContextPath() + "/listStudents");
        } else {
            resp.sendRedirect(req.getContextPath() + "/error");
        }


//
//        LOGGER.debug("id = " + id);
//        LOGGER.debug("name = " + name);
//        LOGGER.debug("age = " + age);
//        LOGGER.debug("groupID = " + groupID);
    }
}
