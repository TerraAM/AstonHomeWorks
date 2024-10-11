package main.java.lesson11.figures;//Определяют пакет, в котором находится файл

/*Импортируем необходимые интерфейсы*/
import main.java.lesson11.interfaces.IPerimeter;
import main.java.lesson11.interfaces.IArea;
import main.java.lesson11.interfaces.IColorfill;

/*Класс триугольника реализующий интерфейсы*/
public class Сircle implements IPerimeter, IArea, IColorfill{

	/*Блок с приватными полями*/
	double radius;//Поле значения радиуса
	String BackGroundColor;//Поле цвета фона
	String BorderColor;//Поле цвета границ
	
	/*Реализация пустого конструктора класса*/
	public Сircle() {}
	/*Реализация конструктора класса*/
	public Сircle(double radius) {
		if (radius > 0) {//Защита от отрицательных и нулевых полей
			this.radius = radius;			
		}
	}
	
	/*Переопределение get метода интерфейса для цвета фона*/
	@Override
	public String getBackGroundColor() {
		return BackGroundColor;
	}

	/*Переопределение set метода интерфейса для цвета фона*/
	@Override
	public void setBackGroundColor(String color) {
		BackGroundColor = color;
	}

	/*Переопределение get метода интерфейса для цвета границ*/
	@Override
	public String getBorderColor() {
		return BorderColor;
	}

	/*Переопределение set метода интерфейса для цвета границ*/
	@Override
	public void setBorderColor(String color) {
		BorderColor = color;
	}
	
	/*Метод get для значения радиуса*/
	public double getRadius() {
		return radius;
	}
	
	/*Метод set для значения радиуса*/
	public void setRadius(double radius) {
		if (radius >= 0) {
			this.radius = radius;			
		}
	}
	
	/*Метод get для диаметра*/
	public double getDiameter() {
		return radius * 2;
	}
	
	/*Переопределение метода для вычисления площади фигуры*/
	@Override
	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	/*Переопределение метода для вычисления периметра фигуры*/
	@Override
	public double perimeter() {
		return 2 * Math.PI * radius;
	}
}
