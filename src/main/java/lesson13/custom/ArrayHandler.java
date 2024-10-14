package main.java.lesson13.custom;//Определяет пакет, в котором находится файл

/*Блок импорта необходимых пакетов*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Класс обработки массива под необходимые условия*/
public class ArrayHandler {

	/*Метод получения коллеции уникальных слов и их кол-ва совпадения*/
	public HashMap<String, Integer> getWordFrequencies(String[] array){
		HashMap<String, Integer> hashMap = new HashMap<>();//Инициализация коллеции (Kay, Value) без совпадений
		
		/*Пробегаемся по массиву слов*/
		for(String key : array) {
			if (hashMap.containsKey(key)) {//Если есть такое слово, добавляем к его Value единицу
				hashMap.put(key,hashMap.get(key) + 1);
			} else { //Если нет, создаем элемент
				hashMap.put(key, 1);
			}
		}
		
		return hashMap;//Выводим результат
	}
	
	/*Метод получения списка уникальных слов*/
	public List<String> getUnicWords(String[] array){
		HashMap<String, Integer> hashMap = getWordFrequencies(array);//Инициализация коллеции, получаем значение из предыдущего метода
		List<String> list = new ArrayList<>();//Инициализация списка
		
		/*Пробегаемся по коллеции HashMap*/
		for(Map.Entry<String, Integer> el : hashMap.entrySet()) {
			list.add(el.getKey());//Добавляем элементы в список
		}
		
		return list;//Выводим результат
	}
}
