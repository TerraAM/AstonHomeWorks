package main.java.lesson12.custom;//Определяет пакет, в котором находится файл

/*Блок импорта необходимых классов*/
import main.java.lesson12.custom.errors.MyArrayDataException;//Класс ошибки на не совпадение типа (ожидали число, получили строку (прим.: "asda"))
import main.java.lesson12.custom.errors.MyArraySizeException;//Класс ошибки на рамер массива (прим.: ожидали 4х4, получили 3х3)

/*Класс обработки массива*/
public class ArrayHandler {

	/*Метод проверки массива на подходимость условиям задачи
	 * К обявлению метода добавляется throws с ошибка, делается это для показа,
	 * что этот метод может выкинуть определенные ошибки*/
	public int getArraySum(String [][] array) throws MyArraySizeException,MyArrayDataException{
			
		if (array.length != 4 || array[0].length != 4) {//Условие на проверку размерности вводимого массива
				throw new MyArraySizeException("Размер массива должен быть 4x4. Получен: " 
						+ array.length + "x" + (array.length > 0 ? array[0].length : 0));//Задание сообщения для ошбики
			}
			int sum = 0;//Инициализация переменной для получения суммы
	
	        // Проверка элементов массива и их сумма
	        for (int i = 0; i < array.length; i++) {
	            for (int j = 0; j < array[i].length; j++) {
	                try {
	                    sum += Integer.parseInt(array[i][j]);//Конвертируем String элемент в int
	                } catch (NumberFormatException e) {//Если конвертация не прошла, обрабатываем полученную ошибку
	                    throw new MyArrayDataException("Ошибка в элементе [" + i + "][" + j + "]: " + array[i][j]);//Задание сообщения для ошбики
	                }
	            }
	        }
	
	        // Возвращаем сумму элементов
	        return sum;
		}

	
}
