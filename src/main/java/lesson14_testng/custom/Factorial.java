package main.java.lesson14_testng.custom;//Определяет пакет, в котором находится файл

/*Класс операций с факториалом*/
public class Factorial {

	/*Рекурсивный метод вычисления факториала*/
	public int calculate (int number) throws IllegalArgumentException {
		if (number < 0) {//Факториал вычисляет натуральные числа
			throw new IllegalArgumentException();//Выбрасывает ошибку
		}
		if (number == 0) {//Факториал 0 = 1
			return 1;
		}
		return number * calculate(number - 1);//Рекурсия (вызов метода самого себя)
	}
}
