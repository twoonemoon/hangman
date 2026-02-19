package utils;

public class Validator {
    // Проверяет является ли переданный символ русским и отличным от нуля, а так же его длинну
    public static boolean isValidRussianLetter(String input) {
        if (input == null || input.length() != 1) {
            return false;
        }
        char c = input.toUpperCase().charAt(0); // CharAt, возвращает символ из строки по первому индексу
        return (c >= 'А' && c <= 'Я' || c == 'Ё'); // вернет true, если переданная буква русская
    }

    //Проверяет, является ли ответ утвердительным
    public static boolean isYes(String input) {
        String lower = input.toLowerCase().trim();
        return lower.equals("да") || lower.equals("yes") ||
                lower.equals("y") || lower.equals("д");
    }

    //Проверяет, является ли ответ отрицательным
    public static boolean isNo(String input) {
        String lower = input.toLowerCase().trim();
        return lower.equals("нет") || lower.equals("no") ||
                lower.equals("n") || lower.equals("н");
    }
}
