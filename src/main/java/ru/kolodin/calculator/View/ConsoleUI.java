package ru.kolodin.calculator.View;

import ru.kolodin.calculator.presenter.Presenter;

import java.util.Scanner;

/**
 * Класс консольного взаимодействия с пользователем
 */
public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "\nВы ввели неверное значение";
    private final Scanner scanner;
    private boolean run;
    private final Presenter presenter;
    private final Menu menu;
    String user_string;

    /**
     * Конструктор класса
     * Читает клавиатуру пользователя
     * Взаимодействует с посредником - презентером
     * Создает экземпляр Меню
     * Содержит логику запуска программы, ее работы в цикле и завершения.
     */
    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        run = true;
        menu = new Menu(this);
        user_string = "";
    }

    /**
     * Метод работы программы в цикле до ее завершения пользователем
     * Выводит в консоль информацию о названии программы при запуске,
     * а также сообщение о закрытии программы
     * Выводит текст меню вначале запуска программы и по окончаниии каждого цикла вычислений
     */
    public void run() {
        System.out.println("\nПРОСТОЙ КАЛЬКУЛЯТОР.\n");
        while (run){
            System.out.println(menu.printMenu());
            execute();
        }
        System.out.println("\nКАЛЬКУЛЯТОР ЗАКРЫТ.\n");
    }

    /**
     * Метод исполнения пукнта меню, введенного пользователем с клавиатуры.
     * Запрашивает у пользователя цифру пункта меню.
     * Запускает метод проверки введенных пользователем данных.
     * Запкскает функцию, соответствующую выбору пользователя.
     */
    private void execute(){
        System.out.print("Введите цифру соответствующего пункта меню: ");
        String string = scanner.nextLine();
        if (checkIntegerInput(string)){
            int numCommand = Integer.parseInt(string);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    /**
     * Метод проверки введеных пользоватем данных на соответствие пунктам меню.
     * @param numCommand цифра, введенная пользоватем, для проверки
     * @return правда или ложь
     */
    private boolean checkCommand(int numCommand){
        int size = menu.getSize();
        if (numCommand <= size && numCommand > 0){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    /**
     * Метод запроса у пользователя данных для вычислений и вывода результатов
     * Запрашивает у пользователя числа для вычислений и знак математической операции.
     * Направляет введенные данные презентеру для проверки.
     * Повторно запрашивает ввод данных при их неправильном вводе.
     * Запрашивает у презентера вывод результатов в консоль
     */
    public void runCalc() {
        boolean flag = false;
        while (!flag){
            System.out.print("\nВведите число A: ");
            flag = presenter.setNumA(scanner.nextLine());
            if (!flag) inputError();
        }
        while (flag){
            System.out.print("\nВведите знак арифметической операции (+ - * /): ");
            flag = !presenter.setSign(scanner.nextLine());
            if (flag) inputError();
        }
        while (!flag){
            System.out.print("\nВведите число B: ");
            flag = presenter.setNumB(scanner.nextLine());
            if (!flag) inputError();
        }
        presenter.getResult();

    }

    /**
     * Метод завершения программы при выборе пользователя
     */
    public void exit() {
        run = false;
    }

    /**
     * Метод вывода в консоль сообщения о неверном вводе данных
     */
    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    /**
     * Метод вывода в консоль сообщения программы
     * @param text входящая строка
     */
    @Override
    public void printAnswer(String text) {
        System.out.println(text);

    }

    /**
     * Метод проверки строки на соответствие числу
     * @param string
     * @return
     */
    private boolean checkIntegerInput(String string){
        if (string.matches("\\d+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }
}
