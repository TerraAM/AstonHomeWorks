package main.java.lesson13.custom;//Определяет пакет, в котором находится файл

/*Блок импорта необходимых пакетов*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*Класс телефонной книги*/
public class PhoneBook {
	
    private HashMap<String, List<String>> phoneBook;//Поле хранения фамилий и списоков телефонов

    /*Конструктор*/
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    /*Метод для добавления номера телефона по фамилии*/
    public void add(String surname, String phoneNumber) {
        if (phoneBook.containsKey(surname)) {//Если фамилия уже есть в справочнике, добавляем телефон в существующий список
            phoneBook.get(surname).add(phoneNumber);
        } else {
            List<String> phoneNumbers = new ArrayList<>();//Если фамилия отсутствует, создаем новый список с телефоном
            phoneNumbers.add(phoneNumber);
            phoneBook.put(surname, phoneNumbers);
        }
    }

    /*Метод для получения списка телефонов по фамилии*/
    public List<String> get(String surname) {
        return phoneBook.getOrDefault(surname, new ArrayList<>());//Возвращаем список телефонов или null, если фамилии нет в справочнике
    }
}
