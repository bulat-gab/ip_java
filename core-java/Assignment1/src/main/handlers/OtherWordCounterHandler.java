package main.handlers;

import main.loaders.WordCounterLoader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class OtherWordCounterHandler implements InvocationHandler {
    private Object worker = null;
    private WordCounterLoader myLoader = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (worker == null) {
            if (myLoader == null) {
        myLoader = new WordCounterLoader();
            }
        worker = myLoader
                .loadClass("main.implementation.OtherWordCounter")
                .newInstance();
        }

        return method.invoke(worker, args);
    }
}
