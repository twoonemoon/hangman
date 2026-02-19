package view;

import game.GameState;
import model.Word;

import java.util.Set;
import java.util.stream.Collectors;

public class HangmanNew {
    private final static String[] HANGMAN_STAGES = {
            // 0 ошибок
            """
          +---+
          |   |
              |
              |
              |
              |
        =========""",
            // 1 ошибка
            """
          +---+
          |   |
          O   |
              |
              |
              |
        =========""",
            // 2 ошибки
            """
          +---+
          |   |
          O   |
          |   |
              |
              |
        =========""",
            // 3 ошибки
            """
          +---+
          |   |
          O   |
         /|   |
              |
              |
        =========""",
            // 4 ошибки
            """
          +---+
          |   |
          O   |
         /|\\  |
              |
              |
        =========""",
            // 5 ошибок
            """
          +---+
          |   |
          O   |
         /|\\  |
         /    |
              |
        =========""",
            // 6 ошибок
            """
          +---+
          |   |
          O   |
         /|\\  |
         / \\  |
              |
        ========="""
    };

    public void showWelcome() {
        System.out.println("\n\uD83C\uDFAE Добро пожаловать в игру Виселица");
        System.out.println("======================================");
    }

    public void showGameState(GameState state) {
        // Показываем виселицу
        System.out.println("\n" + HANGMAN_STAGES[state.getMistakes()]);

        Word word = state.getWord();
        System.out.println("Слово: " + word.getDisplayState());
        if(!state.getWrongLetters().isEmpty()) {
            System.out.println("❌ Ошибочные буквы: " + state.getWrongLetters());
        }

        if(word.getGuessedLetters().isEmpty()) {
            System.out.println("✅ Угаданные буквы: " + word.getGuessedLetters());
        }

        // Показываем оставшиеся попытки
        System.out.println("Осталось попыток: " + (6 - state.getMistakes()));
    }


    public void showGameResult(GameState state) {
        System.out.println("\n" + HANGMAN_STAGES[state.getMistakes()]);
        System.out.println("======================================");

        if (state.isWon()) {
            System.out.println("ПОБЕДА! Вы угадали слово!");
        } else {
            System.out.println("ПОРАЖЕНИЕ!");
        }

        System.out.println("Загаданное слово: " + state.getWord().getTargetWord());
        System.out.println("Количество ошибок: " + state.getMistakes());
        System.out.println("======================================");
    }

    /**
     * Показывает произвольное сообщение
     */
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Форматирует множество букв для отображения
     * @param letters множество букв
     * @return строка с буквами через пробел
     */
    private String formatLetters(Set<Character> letters) {
        // Используем Stream API для сортировки и объединения
        return letters.stream()
                .sorted() // Сортируем
                .map(String::valueOf) // Преобразуем char в String
                .collect(Collectors.joining(" ")); // Объединяем через пробел
    }


}
