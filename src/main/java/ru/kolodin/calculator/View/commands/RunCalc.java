package ru.kolodin.calculator.View.commands;

import ru.kolodin.calculator.View.ConsoleUI;


/**
 * Класс формирующий текст пункта меню и соответствующую ему функцию
 */
public class RunCalc extends Command{

    /**
     * Конструктор класса
     * @param consoleUI принимает консоль
     * Формирует текст меню
     */
    public RunCalc(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Вычислить";
    }

    /**
     * Метод запуска вычислений
     */
    public void execute() {
        consoleUI.runCalc();
    }
}
