/*
Вариант 1
 Необходимо разработать программу, которая получает на вход список ресурсов,
 содержащих текст, и считает общее количество вхождений (для всех ресурсов) каждого слова.
 Каждый ресурс должен быть обработан в отдельном потоке, текст не должен содержать инностранных символов,
 только кириллица, знаки препинания и цифры. Отчет должен строиться в режиме реального времени,
 знаки препинания и цифры в отчет не входят. Все ошибки должны быть корректно обработаны.
*/

/*
#задание ClassLoaders.
    Доработать программу парсинга списка ресурсов. Реализацию обработки вынести в отдельный jar-файл
    и подгружать в runtime используя собственный ClassLoader. Реализовать загрузку/смену jar «на лету»
    (без остановки обработки). Альтернативные реализации:
    Вариант 1:
    Считать общее количество вхождений (для всех ресурсов) каждого слова начинающегося с буквы «ч».
*/
package main;

import main.threads.LoggerThread;
import main.threads.StringProcessingThread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Main {
    final static File correctFile = new File("CorrectRandomText.txt");
    final static File incorrectFile = new File("IncorrectRandomText.txt"); // incorrect word: "Jава", line 556

    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tF %1$tT %4$s %2$s %5$s%6$s%n"); // Logger's time and hashmap contents will be on one line

        LoggerThread  loggerThread = new LoggerThread();
        loggerThread.start();

        long startTime = System.currentTimeMillis();

        try(FileReader fileReader = new FileReader(correctFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader)){

           bufferedReader.lines().forEach(Main::accept);
        } catch (IOException e) {
            e.printStackTrace();
            loggerThread.terminate();
            return;
        }

        long finishTime = System.currentTimeMillis();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        loggerThread.terminate();
        System.out.println("\nProcessing time: " + (finishTime - startTime) + " milliseconds");
    }

    private static void accept(String x) {
        new StringProcessingThread(x).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
