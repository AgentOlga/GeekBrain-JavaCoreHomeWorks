package ru.geekbrains.JavaCore;

import java.util.Arrays;

public class Lesson5HomeWork {
    public static void main(String[] args) {
        /*
        Реализовать сохранение данных в csv файл;
        Реализовать загрузку данных из csv файла. Файл читается целиком.
        Структура файла:
        Строка заголовок с набором столбцов
        Набор строк с целочисленными значениями
        Разделитель между столбцами - символ точка с запятой (;)
         */
        AppData appData = new AppData();

        String[] header = new String[] {"value1","value2","value3"};
        Integer[][] data = new Integer[3][3];
        for (int i = 0; i < 3; i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                data[i][i1] = i + i1;
            }
        }
        appData.setHeader(header);
        appData.setData(data);
        String fileName = "C:\\data.csv";
        System.out.println("Generating file: " + fileName);
        appData.save(fileName);

        AppData appData1 = new AppData();
        System.out.println("Reading file: " + fileName);
        appData1.load(fileName);

        System.out.println(Arrays.toString(appData1.getHeader()));
        System.out.println(Arrays.deepToString(appData1.getData()));
    }
}