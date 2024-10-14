package main.java.lesson13;//Определяет пакет, в котором находится файл

/*Блок импорта необходимых пакетов*/
import java.util.Map;

/*Блок импорта необходимых классов*/
import main.java.lesson13.custom.ArrayHandler;
import main.java.lesson13.custom.PhoneBook;

/*Класс старта программы*/
public class Main {

	public static void main (String [] args) {
		
		ArrayHandler handler = new ArrayHandler();//Инициализация класса для метода обработки массива
		
		/*Инициализация списка слов для проверки работы методов класса handler*/
		String[] words = {
			    "apple", "apple", "apple", //3
			    "banana", "banana", "banana", //3
			    "orange", "orange", // 2
			    "grape", "grape", // 2
			    "peach", "peach", // 2
			    "kiwi", "kiwi", // 2
			    "melon", // 1
			    "pear", // 1
			    "plum",  // 1
			    "lemon" // 1
			};
		
		/*Вывод списка уникальных слов*/
		System.out.println("Список уникальных слов:");
		for(String word : handler.getUnicWords(words)) {
			System.out.println(word);
		}
		
		/*Вывод коллекции уникальных слов с их кол-вом совпадения*/
		System.out.println("Коллекция уникальных слов c кол-вом совпадений:");
		for(Map.Entry<String, Integer> el : handler.getWordFrequencies(words).entrySet()) {
			System.out.println(el.getKey()+" : "+el.getValue());
		}
		
		PhoneBook phoneBook = new PhoneBook();//Инициализация класса телефонной книги
        
        /*Добавление номеров телефонов*/
        phoneBook.add("Pupkov", "123-456");
        phoneBook.add("Pupkov", "789-012");
        phoneBook.add("Dupkov", "345-678");

        /* Получение списка телефонов*/
        System.out.printf("Телефоны %s: %s%n","Pupkov",phoneBook.get("Pupkov"));
        System.out.printf("Телефоны %s: %s%n","Dupkov",phoneBook.get("Dupkov"));
        System.out.printf("Телефоны %s: %s%n","Vupkov",phoneBook.get("Vupkov"));
	}
}
