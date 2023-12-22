package ru.kolodin.calculator.View;

import ru.kolodin.calculator.View.commands.Command;
import ru.kolodin.calculator.View.commands.Exit;
import ru.kolodin.calculator.View.commands.RunCalc;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс создающий меню для консольного взаимодействия с пользователем
 */
public class Menu {
    private  final List<Command> commandList;

    /**
     * Конструктор класса Меню формирующий строку меню для вывода в консоль
     * @param consoleUI
     */
    public Menu(ConsoleUI consoleUI){
        commandList = new ArrayList<>();
        commandList.add(new RunCalc(consoleUI));
        commandList.add(new Exit(consoleUI));
    }

    /**
     * метод формирования строки меню
     * @return возврат строки меню
     */
    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nМеню:\n");
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    /**
     * Метод выбора пукнта меню
     * @param choice цифра пункта меню введенная пользователем
     */
    public void execute(int choice){
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    /**
     * Метод получения количества пунктов меню
     * @return количество пунктов меню
     */
    public int getSize(){
        return commandList.size();
    }
}
