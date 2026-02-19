package utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

// Загружает слова для игры
public class WordLoader {
    private static final String[] DEFAULT_WORDS =
            {"КРУАССАН", "ТОПОР", "МЫШЦЫ", "ТРАНЗИСТОР",
                    "КАБАН", "ПУЛЕМЕТ", "РАБОТА", "ЯГОДА",
                    "МАШИНА", "НОУТБУК", "ДОТА", "ПОДВЫПОДВЕРТ",
                    "МЯСОЕД", "ВЕЛОСИПЕД", "ЯНТАРЬ", "КАРБЮРАТОР",
                    "МУЗЫКА", "МАРТЫШКА", "ОБЕЗЬЯНА", "ГУГЛ",
                    "БРАУЗЕР", "ПРОГРАММА", "СИСТЕМА", "МАЙНКРАФТ"};

    private final Random random; // Генератор случайных чисел

    public WordLoader() {
        this.random = new Random();
    }

    public String getRandomWord(){
        return DEFAULT_WORDS[random.nextInt(DEFAULT_WORDS.length)]; // Случайный слово
    }

    public List<String> getAllWords(){
        return Arrays.asList(DEFAULT_WORDS);
    }

}
