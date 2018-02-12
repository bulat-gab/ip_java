package main.implementation;

import main.threads.StringProcessingThread;

import java.util.concurrent.atomic.LongAdder;

public class WordCounter implements IWordCounter {
    public synchronized void compute(String[] words) {
        for (String word : words) {
            if (!StringProcessingThread.isRunning())
                return;
            if (word.equals(""))
                continue;

            StringProcessingThread.getMap().computeIfAbsent(word, v -> new LongAdder()).increment();
        }
    }
}
