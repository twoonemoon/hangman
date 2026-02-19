package game;
// Хранит текущее состояние игры

import model.Word;

import java.util.HashSet;
import java.util.Set;

public class GameState {
    private final Word word;
    private final Set<Character> wrongLetters; // Ошибочные буквы
    private int mistakes; // Количество ошибок
    private boolean gameOver; // Проигрышь
    private boolean won; // Победа

    //Конструктор для состояния игры
    public GameState(Word word) {
        this.word = word;
        this.wrongLetters = new HashSet<>();
        this.mistakes = 0;
        this.gameOver = false;
        this.won = false;
    }

    public void processGuess(char letter) {
        letter = Character.toUpperCase(letter); // Приводим переданную букву к верхнему регистру

        // Проверяем является ли переданная отгаданная буква последней отгаданной
        if (word.guessLetter(letter)) {
            // Слово угадано полностью
            if (word.isCompletelyGuessed()) {
                won = true;
                gameOver = true;
            }
        } else {
            if (!wrongLetters.contains(letter)) {  // Если массив с неудачными буквами не содержит переданную, добавляем его туда
                wrongLetters.add(letter);
                mistakes++;

                // Если превысили количество ошибок, игра закончена
                if (mistakes >= 6) {
                    gameOver = true;
                }

            }
        }
    }

    // Геттеры для всех состояний класса
    public Word getWord() {
        return word;
    }

    public boolean isWon() {
        return won;
    }

    public int getMistakes() {
        return mistakes;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public Set<Character> getWrongLetters() {
        return wrongLetters;
    }
}
