package ru.geekbrains.JavaCore;
import java.io.IOException;
import java.util.ArrayList;

/**
 *  Homework #4
 *
 * @author Olga Philippova
 * @version 05.04.2022
 */
public class Lesson4 {

        static final String FILE_NAME1 = "C://Lesson4Homework4.txt";
        static final String FILE_NAME2 = "Lesson4Homework4.txt";

        /**
         * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список
         * уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое
         * слово.
         * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
         */

        public static void main(String[] args) {
            // first homework item
            ArrayList<String> wordArray = new ArrayList<String>();
            wordArray = ArrayOperation.fillTheArray(wordArray);
            System.out.println(wordArray + "\n");
            ArrayOperation.printUniqueWords(wordArray);
            wordArray.clear();
            try {
                wordArray = ArrayOperation.fillTheArrayFromFile(wordArray, FILE_NAME2);

            } catch (IOException e) {
                System.out.println("Failed to fill array from file!\n");
            }
            try {
                wordArray = ArrayOperation.fillTheArrayFromFile(wordArray, FILE_NAME1);
            } catch (IOException e) {
                System.out.println("Failed to fill array from file!\n");
            }
            System.out.println(wordArray + "\n");
            ArrayOperation.printUniqueWords(wordArray);
            // second homework item
            PhoneBook phonebook = new PhoneBook();

            phonebook.add(2304578, "Pitt");
            phonebook.add(5678794, "Smith");
            phonebook.add(3456783, "Andersen");
            phonebook.add(3456278, "Pitt");
            phonebook.add(9786053, "Jolie");
            phonebook.add(6475893, "Jolie");

            phonebook.get("Pitt");
            phonebook.get("Andersen");
            phonebook.get("Jolie");
            phonebook.get("Christensen");
        }
}

