package main.threads;

import java.util.logging.Logger;

public class LoggerThread extends Thread {
    private final static Logger LOGGER = Logger.getLogger(LoggerThread.class.getName());
    private volatile boolean running = true;

    public void terminate() {
        running = false;
    }

    @Override
    public void run() {
        while (StringProcessingThread.isRunning() && running) {
            StringBuilder sb = new StringBuilder();
            StringProcessingThread.getMap().forEach((k, v) -> sb.append("(").append(k).append(":").append(v).append(")  "));

            LOGGER.info(sb.toString());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!StringProcessingThread.isRunning())
            LOGGER.info("Illegal string has been detected. Stopping all threads...");
    }
}
