package main.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    static public boolean containsInvalidCharacters(String string){
        Pattern pattern = Pattern.compile("[^а-яА-Я\\d\\s.,!?-]+");
        Matcher matcher = pattern.matcher(string);

        return matcher.find();
    }
}
