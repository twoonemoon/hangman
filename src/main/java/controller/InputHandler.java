package controller;

import utils.Validator;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public  InputHandler(){
        this.scanner = new Scanner(System.in);
    }

    public char getLetterFromUser(){
        while(true){
            System.out.println("\n Введите букву: ");
            String input = scanner.nextLine();

            if(input.isEmpty()){
                System.out.println("\n Вы ничего не ввели"); // проверка пустого ввода
                continue;
            }
            if(!Validator.isValidRussianLetter(input)){
                System.out.println("\n Вы пишите не на русском"); //проверка на славянина
                continue;
            }

            return input.toUpperCase().charAt(0);
        }


    }

    /**
     * Спрашиваем, хочет ли пользователь сыграть еще раз
     * return true если да, false если нет
     */
    public boolean askForReplay(){
        while(true){
            System.out.println("\n Хотели бы сыграть еще ?");
            String answer = scanner.nextLine();
            if(Validator.isYes(answer)){
                return true;
            } else if(Validator.isNo(answer)){
                return false;
            } else {
                System.out.println("\n Проверь, ответ должен быть 'да' или 'нет'");
            }
        }
    }

    public void close(){
        scanner.close();
    }
}
