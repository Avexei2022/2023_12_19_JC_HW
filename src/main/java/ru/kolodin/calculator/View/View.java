package ru.kolodin.calculator.View;

/**
 * Интерфейс, требующий реализации показа пользователю входящего текста
 */
public interface View {

    /**
     * Функция для вывода пользователю входящей строки
     * @param text входящая строка
     */
    void printAnswer(String text);
}
