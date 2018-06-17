package main.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class TextGenerator {
    private static final int size = 1000;

    private static final String[] words = {"Я", "Люблю", "Маму",
            "14", "88", ",",
            "..", ".", "Инннополис",
            "Море", "Волнуется", "раз",
            "два", "человек", "Джава", "!",
            "LOL", "Jава"};

    public static ArrayList<String> generateCorrectRandomText(){
        ArrayList<String> text = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();

            Random rand = new Random(System.currentTimeMillis());
            while(sb.length() < 1000){


                sb.append(words[rand.nextInt(words.length -2 )]).append(" ");
            }

            text.add(sb.toString());
        }

        return text;
    }

    public static ArrayList<String> generateRandomText(){
        ArrayList<String> text = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();

            Random rand = new Random(System.currentTimeMillis());
            while(sb.length() < 1000){


                sb.append(words[rand.nextInt(words.length )]).append(" ");
            }

            text.add(sb.toString());
        }

        return text;
    }

    public static ArrayList<String>  generateSpecifiedText(){
        ArrayList<String> text = new ArrayList<>();


        // 333 Lines with 1000 "Иннополис" words
        for (int line = 0; line < size/3; line++) {
            StringBuilder sb = new StringBuilder();

            int i = 0;
            while (i++ < 1000) {
                sb.append(words[8]).append(" ");
            }

            text.add(sb.toString());
        }

        // 333 Lines with 500 "Море" words
        for (int line = size/3; line <  size/3 * 2; line++) {
            StringBuilder sb = new StringBuilder();

            int i = 0;
            while (i++ < 500) {
                sb.append(words[9]).append(" ");
            }

            text.add(sb.toString());
        }


        // 334 Lines with 100 "Джава" words
        for (int line = size/3 * 2; line <  size; line++) {
            StringBuilder sb = new StringBuilder();

            int i = 0;
            while (i++ < 100) {
                sb.append(words[14]).append(" ");
            }

            sb.append(",.");
            text.add(sb.toString());
        }


        return text;
    }

    public static void saveTextToFile(ArrayList<String> text, String fileName){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))){
            for (int i = 0; i < size; i++) {
                bufferedWriter.write(text.get(i));
                bufferedWriter.newLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
