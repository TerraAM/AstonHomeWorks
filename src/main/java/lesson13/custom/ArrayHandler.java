package main.java.lesson13.custom;//Определяет пакет, в котором находится файл

/*Блок импорта необходимых пакетов*/
import java.util.HashMap;
import java.util.Map;

/*Класс обработки массива под необходимые условия*/
public class ArrayHandler {

	/*Метод получения коллеции уникальных слов и их кол-ва совпадения*/
	public Map<String, Integer> getWordFrequencies(String[] array){
		Map<String, Integer> hashMap = new HashMap<>();//Инициализация коллеции (Kay, Value) без совпадений
		
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
}
