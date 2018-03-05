package ru.stc.day0303;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.stc.api.Worker;

public class Main {
    public static void main(String[] args) {
        ApplicationContext c = new AnnotationConfigApplicationContext(MyConfiguration.class);

        Worker worker = c.getBean(Worker.class);

        worker.doSomeWork(2);
    }
}
