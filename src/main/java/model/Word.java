package model;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Класс представляющий загаданное слово
public class Word {
    private final String targetWord; //Загаданное слово
    private final char[] currentState; // Текущее состояние, массив символов
    private final Set<Character> guessedLetters; // Угаданные буквы

    //Конструктор класса, принимает параметром загаданное слово
    public Word(String targetWord) {
        this.targetWord = targetWord.toUpperCase(); // Приводим загаданное слово к верхнему регистру
        this.currentState = new char[targetWord.length()]; // Создаем массив длиной в загаданоое слово
        Arrays.fill(currentState,  Letter.UNGUESSED.getDisplayChar()); // Arrays.fill - удобный метод заполнения массива
        this.guessedLetters = new HashSet<>(); // Создаем пустое множество
    }

    // Метод угадывания буквы
    public boolean guessLetter(char letter){
        letter = Character.toUpperCase(letter);
        //Проверка, не угадывали ли мы уже эту букву
        if(guessedLetters.contains(letter)){
            return false;
        }
        // Такая буква уже есть
        boolean found = false;
        for(int i=0; i<currentState.length; i++){
            if(targetWord.charAt(i) == letter){
                currentState[i] = letter;
                found = true;
            }
        }
        // Добавляем угаданную букву в множество угаданных Set
        if(found){
            guessedLetters.add(letter);
        }
        return found;
    }

    public boolean isCompletelyGuessed(){
        //Проходим по символам текущего состояния
        for(char c : currentState){
            if(c == Letter.UNGUESSED.getDisplayChar()){ // Если находим "_" - слово пока не угаданно
                return false;
            }
        }
        return true;
    }

    public String getDisplayState(){
        StringBuilder sb = new StringBuilder();
        for(char c : currentState){
            sb.append(c).append(' '); //append добавляет в строку символ и повторным вызовом разделяет пробелом
        }
        // Переводим sb в стринговую
        return sb.toString().trim(); //Метод trim() удаляет пробельные символы в начале и конце строки
    }

    public Set<Character> getGuessedLetters() {
        return new HashSet<>(guessedLetters);
    }

    public String getTargetWord() {
        return targetWord;
    }

    public int getLength(){
        return this.targetWord.length();
    }
}
