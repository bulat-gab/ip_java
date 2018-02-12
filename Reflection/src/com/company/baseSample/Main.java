package com.company.baseSample;

import com.company.baseSample.model.InnoStudent;
import com.company.baseSample.model.Student;
import com.company.baseSample.utils.ReflectionInvoker;
import com.company.baseSample.utils.ReflectionPrinter;
import com.company.baseSample.utils.ReflectionSetter;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        InnoStudent innoStudent =
                new InnoStudent("shock content",
                                3,
                                'a',
                                "no hymn",
                                12,
                                12000);

        //ReflectionPrinter.printClass(student.getClass());
        //ReflectionPrinter.printClass(InnoStudent.class);
        //ReflectionPrinter.printClass(innoStudent.getClass());

        ReflectionSetter.setFieldValue(
                "new Secret",
                innoStudent,
                "secret",
                innoStudent.getClass());

        System.out.println(ReflectionSetter.getFieldValue(innoStudent,
                                                         "secret",
                                                        innoStudent.getClass()));

        ReflectionInvoker.invokeMethodWithOutArgs(innoStudent,
                                                  innoStudent.getClass(),
                                        "saySecret");
    }
}
