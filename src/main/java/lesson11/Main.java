package main.java.lesson11;//Определяют пакет, в котором находится файл

/*Блок импорта необходимых классов*/
import main.java.lesson11.animals.Animal;
import main.java.lesson11.animals.Cat;
import main.java.lesson11.animals.Dog;
import main.java.lesson11.items.Bowl;
import main.java.lesson11.figures.Rectangle;
import main.java.lesson11.figures.Triangle;
import main.java.lesson11.figures.Сircle;

/*Класс старта программы*/
public class Main {
	
	public static void main(String [] args) {
		
		/*---------Задание 1---------*/
		Cat cat1 = new Cat("Пупс");//Инициализация класса Cat
		/*Блок методов класса*/
		cat1.run(50);//Бег на дистанцию 50 метров (true)
		cat1.run(250);//Бег на дистанцию 250 метров (false)
		cat1.run(-50);//Бег на отрицательную дистанцию (false)
		cat1.swim(10);//Попытка заплыва (false)
		
		Dog dog1 = new Dog("Вупс");//Инициализация класса Dog
		dog1.run(250);//Бег на дистанцию 250 метров (true)
		dog1.run(550);//Бег на дистанцию 550 метров (false)
		dog1.run(-50);//Бег на отрицательную дистанцию (false)
		dog1.swim(9);//Заплыв на дистанцию 9 метров (true)
		dog1.swim(11);//Заплыв на дистанцию 11 метров (true)
		dog1.swim(-9);//Заплыв на отрицательную дистанцию (false)
		
		Animal cat2 = new Cat("Питомец кот");//Инициализация класса через его наследника (демонстрация принципа полиморфизма)
		Animal dog2 = new Dog("Питомец собака");//Инициализация класса через его наследника (демонстрация принципа полиморфизма)	
		
		System.out.println(cat2.getCount());//Вывод информации о кол-ве кошек
		System.out.println(dog2.getCount());//Вывод информации о кол-ве собак
		System.out.println(Animal.getAnimalCount());//Вывод информации о кол-ве животных
		
		/*---------Расширение задания 1---------
		 * Создание массива кошек (7 шт)*/
		Cat[] cats = { 
				new Cat("Пупс",13),//Конструктор с передачей имени и сколько ест кот
				new Cat("Мупс",9),
				new Cat("Вупс",10),
				new Cat("Бупс",11),
				new Cat("Тупс",8),
				new Cat("Рупс",5),
				new Cat("Купс",10)};
		
		Bowl bowl = new Bowl(50);//Создание миска на 50 единиц еды
		/*Кормим всех котов из миски*/
		for(Cat cat : cats) {
			cat.eat(bowl);
			System.out.printf("%s, голоден? %b%n",cat.getName(),cat.isHunger());//Проверяем, голодн ли кот
		}
		
		/*---------Задание 2---------*/
		Сircle circle = new Сircle(7);//Реализация класса "Круг" с передачей параметра радиуса
		Rectangle rectangle = new Rectangle(12,5);//Реализация класса "Прямоугольник" с передачей параметров сторон (a,b)
		Triangle triangle = new Triangle(5,12,7);//Реализация класса "Триугольник" с передачей параметров сторон (a,b,c)
		
		/*Блок вывода информации о площадях и перемитрах фигур*/
		System.out.println("\n-------Круг-------");
		System.out.printf("Периметр: %f%n",circle.perimeter());
		System.out.printf("Площадь: %f%n",circle.area());

		System.out.println("\n-------Прямоугольник-------");
		System.out.printf("Периметр: %f%n",rectangle.perimeter());
		System.out.printf("Площадь: %f%n",rectangle.area());
		
		System.out.println("\n-------Триугольник-------");
		System.out.printf("Периметр: %f%n",triangle.perimeter());
		System.out.printf("Площадь: %f%n",triangle.area());
		
	}
}
