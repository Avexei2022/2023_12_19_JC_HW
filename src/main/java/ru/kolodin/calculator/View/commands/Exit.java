package ru.kolodin.calculator.View.commands;

import ru.kolodin.calculator.View.ConsoleUI;

/**
 * Класс формирующий текст пункта меню и соответствующую ему функцию
 */
public class Exit extends Command{

    /**
     * Конструктор класса
     * @param consoleUI принимает консоль
     * Формирует текст пункта меню
     */
    public Exit(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Выход из программы";
    }

    /**
     * Метод запкска пункта меню
     */
    public void execute() {
        consoleUI.exit();
    }
}
