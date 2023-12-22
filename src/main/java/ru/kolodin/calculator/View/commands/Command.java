package ru.kolodin.calculator.View.commands;

import ru.kolodin.calculator.View.ConsoleUI;

/**
 * Родительский класс для формирования пунктов меню
 */
public class Command {
    String description;
    ConsoleUI consoleUI;

    /**
     * Конструктор класса
     * @param consoleUI принимает консоль
     *
     */
    public Command(ConsoleUI consoleUI){
        this.consoleUI = consoleUI;
    }

    /**
     * Метод формирования текста пункта меню
     * @return возвращает строку пункта меню
     */
    public String getDescription(){
        return  description;
    }

    /**
     * Метод запуска на исполнение соответстующего пункта меню
     */
    public void execute(){

    }
}
