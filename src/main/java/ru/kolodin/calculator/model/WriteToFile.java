package ru.kolodin.calculator.model;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Класс записи результатов в файл
 */
public class WriteToFile {

    String file_name;
    private final FileWriter fw;

    /**
     * Конструктор класса
     * @throws IOException пробрасывает ошибки чтения записи в файл
     * Название файла постоянно зашитою
     */
    public WriteToFile() throws IOException {
        file_name = "CalcHistory.txt";
        fw =new FileWriter(file_name, true);

    }

    /**
     * Метод дозаписи входящей строки в файл
     * @param result входящая строка результата вычислений
     * @throws IOException проброс исключения выше
     * Вначале строки записывает текущую дату и время
     */
    public void AddNewCalc(String result) throws IOException{
        Date date_time = new Date();
        fw.append(date_time.toString());
        fw.append(" -> ");
        fw.append(result);
        fw.append("\n");
        fw.flush();
    }

    /**
     * Метод возвращения имени файла
     * @return возвращает имя файла
     */
    public String getFileName(){
        return file_name;
    }
}
