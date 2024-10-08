package main.java.figures;//Определяют пакет, в котором находится файл

/*Импортируем необходимые интерфейсы*/
import main.java.interfaces.*;

/*Класс прямоугольника реализующий интерфейсы*/
public class Rectangle implements IPerimeter, IArea, IColorfill {

	/*Блок с приватными полями*/
	double a,b;//Поля значений для сторон
	String BackGroundColor;//Поле цвета фона
	String BorderColor;//Поле цвета границ

	/*Реализация пустого конструктора класса*/
	public Rectangle() {}
	/*Реализация конструктора класса*/
	public Rectangle(double a,double b) {
		if (a > 0) {//Защита от отрицательных и нулевых полей
			this.a = a;			
		}
		if (b > 0) {//Защита от отрицательных и нулевых полей
			this.b = b;			
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

	/*Метод get для зачения одной из сторон*/
	public double getA() {
		return a;
	}
	/*Метод set для зачения одной из сторон*/
	public void setA(double a) {
		if (a >= 0) {
			this.a = a;			
		}
	}
	/*Метод get для зачения одной из сторон*/
	public double getB() {
		return b;
	}
	/*Метод set для зачения одной из сторон*/
	public void setB(double b) {
		if (b >= 0) {
			this.b = b;			
		}
	}
	/*Переопределение метода для вычисления площади фигуры*/
	@Override
	public double area() {
		return a * b;
	}

	/*Переопределение метода для вычисления периметра фигуры*/
	@Override
	public double perimeter() {
		return (a + b) * 2;
	}
	
}
