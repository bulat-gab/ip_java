package main;

import main.model.dao.impl.GroupDAOImpl;
import main.model.dao.impl.JournalDAOImpl;
import main.model.dao.impl.LessonDAOImpl;
import main.model.dao.impl.StudentDAOImpl;
import main.model.pojo.Group;
import main.model.pojo.Journal;
import main.model.pojo.Lesson;
import main.model.pojo.Student;
import main.services.Mailer;

/**
 * Created by admin on 19.04.2017.
 */
public class Main {
    public static void main(String[] args) {
//        GroupDAOImpl groupDAO = new GroupDAOImpl();
//        StudentDAOImpl studentDAO = new StudentDAOImpl();
//        LessonDAOImpl lessonDAO = new LessonDAOImpl();
//        JournalDAOImpl journalDAO = new JournalDAOImpl();
//
//        for (Group group :
//                groupDAO.getAll()) {
//            System.out.println(group.toString());
//        }
//        for (Student student :
//                studentDAO.getAll()) {
//            System.out.println(student.toString());
//        }
//        for (Lesson lesson :
//                lessonDAO.getAll()) {
//            System.out.println(lesson.toString());
//        }
//        for (Journal journal :
//                journalDAO.getAll()) {
//            System.out.println(journal.toString());
//        }

        Mailer mailer = new Mailer("loggerffi1", "loggerpwd");

        mailer.SendMail("loggerffi1@gmail.com", "TomcatApp", "App started", null);
    }
}
