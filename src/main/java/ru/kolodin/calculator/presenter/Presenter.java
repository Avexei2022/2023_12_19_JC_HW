package ru.kolodin.calculator.presenter;

import ru.kolodin.calculator.View.View;
import ru.kolodin.calculator.model.Service;

/**
 * Класс посредник между консольной частью и основной программой.
 */
public class Presenter {
    private final View view;
    private final Service service;

    /**
     * Конструктор класса
     * @param view принимает консольный интерфейс
     * создает экземпляр основной части программы
     */
    public Presenter(View view){
        this.view = view;
        this.service = new Service();
    }

    /**
     * Метод передачи введенного пользоватем числа А в программу
     * @param s принимет строку
     * @return возвращает правду если число принято прграммой
     * или возращает ложь если введенные данные некорректны.
     */
    public boolean setNumA(String s) {
        return service.setNumA(s);

    }

    /**
     * Метод передачи введенного пользоватем знака математической операции в программу
     * @param s принимет строку
     * @return возвращает правду если знак принят прграммой
     * или возращает ложь если введенные данные некорректны.
     */
    public boolean setSign(String s) {
        return service.setSign(s);
    }

    /**
     * Метод передачи введенного пользоватем числа В в программу
     * @param s принимет строку
     * @return возвращает правду если число принято прграммой
     * или возращает ложь если введенные данные некорректны.
     */
    public boolean setNumB(String s) {
        return service.setNumB(s);

    }

    /**
     * Метод запроса у программы результатов вычислений и вывода их в консоль
     */
    public void getResult() {
        String info = service.getResult();
        view.printAnswer(info);
    }
}
