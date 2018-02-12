package main.threads;

import main.utils.StringUtil;
import main.implementation.IWordCounter;
import main.handlers.OtherWordCounterHandler;
import main.handlers.WordCounterHandler;

import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;


public class StringProcessingThread extends Thread {
    private static volatile boolean running = true;
    private static volatile LongAdder instanceNum = new LongAdder();
    private static final ConcurrentHashMap<String, LongAdder> map = new ConcurrentHashMap<>();
    private final String inputStr;

    public StringProcessingThread(String inputStr){
        if(StringUtil.containsInvalidCharacters(inputStr)){
            running = false;
        }
        instanceNum.increment();

        this.inputStr = inputStr;
    }

    public static boolean isRunning() {
        return running;
    }

    @Override
    public void run() {
        String[] words = inputStr.split("[^а-яА-Я]+");
        IWordCounter wordCounter;

        if(instanceNum.intValue() < 500) {
            wordCounter = (IWordCounter) Proxy.newProxyInstance(
                            IWordCounter.class.getClassLoader(),
                            new Class[]{IWordCounter.class},
                            new OtherWordCounterHandler());
        }
        else {
            wordCounter = (IWordCounter) Proxy.newProxyInstance(
                    IWordCounter.class.getClassLoader(),
                    new Class[]{IWordCounter.class},
                    new WordCounterHandler());
        }

        wordCounter.compute(words);
    }
    public static ConcurrentHashMap<String, LongAdder> getMap() {
        return map;
    }
}
