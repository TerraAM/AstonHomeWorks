package main.java.lesson12;//Определяет пакет, в котором находится файл

/*Блок импорта необходимых классов*/
import main.java.lesson12.custom.ArrayHandler;//Класс обработки массива (проверки размерности и сложения всех элементов)
import main.java.lesson12.custom.errors.MyArrayDataException;//Класс ошибки на не совпадение типа (ожидали число, получили строку (прим.: "asda"))
import main.java.lesson12.custom.errors.MyArraySizeException;//Класс ошибки на рамер массива (прим.: ожидали 4х4, получили 3х3)

/*Класс старта программы*/
public class Main {

	public static void main(String [] args) {
		
		ArrayHandler handler = new ArrayHandler();//Инициализация класса для метода обработки массива
		
		/*Инициализация подходящго под условия двумерного массива*/
		String[][] correctArray = {
	            {"2", "5", "5", "3"},
	            {"4", "2", "3", "4"},
	            {"4", "3", "2", "4"},
	            {"3", "5", "5", "2"}
	        };

		/*Инициализация неподходящго под условия двумерного массива по рамеру*/
        String[][] incorrectArraySize = {
            {"1", "1", "1"},
            {"1", "1", "1"},
            {"1", "1", "1"}
        };

        /*Инициализация неподходящго под условия двумерного массива содержащего строки*/
        String[][] incorrectArrayData = {
            {"1", "1", "1", "1"},
            {"1", "pup", "1", "1"},
            {"1", "1", "1", "1"},
            {"1", "1", "pip", "1"}
        };
		
        /*Блок try catch для правильного массива*/
		try {
			int sum;//Переменная для получения суммы
			sum = handler.getArraySum(correctArray);//Проверка метода с подходящим массивом
			System.out.println("Сумма элементов: " + sum);//Вывод, прим.: "Сумма элементов: 12"
		} catch (MyArraySizeException | MyArrayDataException e) {}
        
        try {  
        	handler.getArraySum(incorrectArraySize); //Ошибка размера массива
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());//Вывод в консоль организован как ошибка (красным цветом) при помощи .err
        }

        try {
        	handler.getArraySum(incorrectArrayData); //Ошибка данных в массиве
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());//Вывод в консоль организован как ошибка (красным цветом) при помощи .err
        }
	}
}
