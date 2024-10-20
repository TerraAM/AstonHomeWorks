package main.java.lesson14_testng;//Определяет пакет, в котором находится файл

/*Блок импорта необходимых классов*/
import main.java.lesson14_testng.custom.Factorial;

public class Main {

	public static void main (String [] args) {
		
		var factorial = new Factorial();//Инициализация класса факториала
		
		/*Блок вывода различных факториалов*/
		System.out.printf("%d! = %d%n",5,factorial.calculate(5));//Факториал 5 = 120
		System.out.printf("%d! = %d%n",1,factorial.calculate(1));//Факториал 1 = 1
		System.out.printf("%d! = %d%n",0,factorial.calculate(0));//Факториал 0 = 1
		System.out.printf("%d! = %d%n",-4,factorial.calculate(-4));//Факториал -4 = !Ошибка (NumberFormatException)
	
	}
}
