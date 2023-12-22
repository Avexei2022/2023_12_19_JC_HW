package ru.kolodin.calculator.model;

/**
 * Основной (серверный) класс калькулятора
 */
public class Calc {
    private String operator;
    private double num_a;
    private double num_b;

    /**
     * Конструктор калькулятора для проверки вводимых данных и вычисления результата
     */
    public Calc(){
    }

    /**
     * Метод установки числа А, с проверкой строки, введенноой пользователем
     * @param s_num_a строка, введеная пользователем
     * @return Возвращает правду, если число А установлено,
     * или возвращает ложь, если введенная пользователем строка не может быть преобразована в число
     */
    public boolean setNumA(String s_num_a){
        boolean flag = false;
        try {
            this.num_a = Float.parseFloat(s_num_a);
            flag = true;
        } catch (Exception ignore){
        }
        return flag;
    }

    /**
     * Метод установки арифметического оператора, с проверкой строки, введенноой пользователем
     * @param operator Принимает на ввод строку для проверки
     * @return Возвращает правду, если число оператор установлен,
     * или возвращает ложь, если введенная пользователем строка не соответствует операторам
     */
    public boolean setSign(String operator){
        boolean flag = false;
        if (operator.equals("+") || operator.equals("-")
                || operator.equals("*") || operator.equals("/")) {
            this.operator = operator;
            flag = true;
        }
        return flag;
    }

    /**
     * Метод установки числа B, с проверкой строки, введенноой пользователем
     * @param s_num_b строка, введеная пользователем
     * @return Возвращает правду, если число B установлено,
     * или возвращает ложь, если введенная пользователем строка не может быть преобразована в число,
     * а также в случае попытки деления на ноль
     */
    public boolean setNumB(String s_num_b){
        boolean flag = false;
        try {
            this.num_b = Float.parseFloat(s_num_b);
            if (!(operator.equals("/") && num_b == 0)){
                flag = true;
            }
        } catch (Exception ignore){
        }
        return flag;
    }

    /**
     * Метод вычисления результата
     * @return Возвращает строку результата
     */
    public String getResult() {
        double num_c = 0;
        switch (operator) {
            case "+": num_c = num_a + num_b;
                break;
            case "-": num_c = num_a - num_b;
                break;
            case "*": num_c = num_a * num_b;
                break;
            case "/": num_c = num_a / num_b;
                break;
        }
        return String.format("Результат: %f %s %f = %f", num_a, operator, num_b, num_c);
    }

}
