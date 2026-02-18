package model;
//
public enum Letter {
    UNGUESSED('_'),
    GUESSED('\0');

    private final char displayChar;     //поле enum

    //конструктор для enum'а
    Letter(char displayChar) {
        this.displayChar = displayChar;
    }

    // getter для символа отображения
    public char getDisplayChar() {
        return displayChar;
    }
}
