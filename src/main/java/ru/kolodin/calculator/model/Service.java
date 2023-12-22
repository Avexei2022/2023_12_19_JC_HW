package ru.kolodin.calculator.model;


import java.io.IOException;

/**
 * Сервисвный класс основной (серверной) части прогараммы
 */
public class Service {

    private final Calc calc;


    /**
     * Констрктор класса
     * создает единственный экземляр класса калькулятор
     */
    public Service(){
        calc = new Calc();
    }

    /**
     * Метод передачи в калькулятор числа А
     * @param s входящая строка
     * @return возращает правду если калькулятор принял чило А
     * и возращает ложь в случае некорректности поступивших данных
     */
    public boolean setNumA(String s) {
        return calc.setNumA(s);
    }


    /**
     * Метод передачи в калькулятор числа В
     * @param s входящая строка
     * @return возращает презентеру правду если калькулятор принял чило В
     * и возращает ложь в случае некорректности поступивших данных
     */
    public boolean setNumB(String s) {
        return calc.setNumB(s);
    }

    /**
     * Метод передачи в калькулятор знака математической операции
     * @param s входящая строка
     * @return возращает презентеру правду если калькулятор принял знак
     * и возращает ложь в случае некорректности поступивших данных
     */
    public boolean setSign(String s) {
        return calc.setSign(s);
    }

    /**
     * Метод запроса у калькулятора результатов вычисления
     * @return возвращает презентеру строку с результатами вычислений
     * Записывает результат в файл.
     */
    public String getResult() {
        StringBuilder message = new StringBuilder();
        String result = calc.getResult();
        message.append(result);
        try {
            WriteToFile wf = new WriteToFile();
            wf.AddNewCalc(result);
            message.append("\nРезультат записан в файл ");
            message.append(wf.getFileName());
        } catch (IOException e) {
            message.append("\n Ошибка записи в файл: ");
            message.append(e.getMessage());
        }
        return message.toString();
    }
}
