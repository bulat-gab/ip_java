package ru.stc.worker;

import ru.stc.loader.MyLoader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class WorkerInvHandler implements InvocationHandler {
//    private Object worker;
//    private MyLoader myLoader;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object worker;
         MyLoader myLoader;
//        if (worker == null) {
//            if (myLoader == null) {
                myLoader = new MyLoader();
//            }
            worker = myLoader
                    .loadClass("ru.stc.worker.WorkerA")
                    .newInstance();
//        }

        return method.invoke(worker, args);
    }
}
