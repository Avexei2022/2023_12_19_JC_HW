package ru.kolodin.calculator;

import ru.kolodin.calculator.View.ConsoleUI;

/**
 * Основной класс приложения. Создает консольное взаимодействие с пользователем.
 * Запускает приложение - Простой Калькулятор.
 * Результаты вычислений сохраняются в файл.
 */
public class Main {

    /**
     * Точка входа в программу.
     *
     * @param args аргументы командной строки не предусмотрены.
     */
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.run();
    }
}
