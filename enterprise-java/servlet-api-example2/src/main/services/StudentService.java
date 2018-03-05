package main.services;

import main.model.pojo.Student;

import java.util.List;

/**
 * Created by admin on 19.04.2017.
 */
public interface StudentService {
    List<Student> getAllStudents();

    void deleteById(Long id);

    Student getById(Long id);

    void save(long id, String name, long age, long groupID);
}
