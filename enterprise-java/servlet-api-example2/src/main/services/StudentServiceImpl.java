package main.services;

import main.controllers.LoginServlet;
import main.model.dao.impl.StudentDAOImpl;
import main.model.dao.interfaces.StudentDAO;
import main.model.pojo.Student;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.List;

/**
 * Created by admin on 19.04.2017.
 */
public class StudentServiceImpl implements StudentService {
    static {
        PropertyConfigurator.configure(LoginServlet.class.getClassLoader().getResource("log4j.properties"));
    }

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    public static StudentDAO studentDAO = new StudentDAOImpl();

    public List<Student> getAllStudents(){
        return studentDAO.getAll();
    }

    @Override
    public void deleteById(Long id) {
        //LOGGER.debug("deleteById = " + id);

        Student student = studentDAO.getById(id);

        //LOGGER.debug("got student with id = " + student.getId());

        studentDAO.delete(student);
    }

    @Override
    public Student getById(Long id) {
        return studentDAO.getById(id);
    }

    @Override
    public void save(long id, String name, long age, long groupID) {
        Student student = new Student(id, name, age, groupID);

        studentDAO.save(student);
    }
}
