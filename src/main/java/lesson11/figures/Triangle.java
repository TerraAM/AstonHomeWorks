package main.java.lesson11.figures;//Определяют пакет, в котором находится файл

/*Импортируем необходимые интерфейсы*/
import main.java.lesson11.interfaces.IPerimeter;
import main.java.lesson11.interfaces.IArea;
import main.java.lesson11.interfaces.IColorfill;

/*Класс триугольника реализующий интерфейсы*/
public class Triangle implements IPerimeter, IArea, IColorfill{

	/*Блок с приватными полями*/
	double a,b,c;//Поля значений для сторон
	String BackGroundColor;//Поле цвета фона
	String BorderColor;//Поле цвета границ
	
	/*Реализация пустого конструктора класса*/
	public Triangle() {}
	/*Реализация конструктора класса*/
	public Triangle(double a, double b,double c) {
		if (a > 0) {//Защита от отрицательных и нулевых полей
			this.a = a;		
		}
		if (b > 0) {//Защита от отрицательных и нулевых полей
			this.b = b;
		}
		if (c > 0) {//Защита от отрицательных и нулевых полей
			this.c = c;
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
	
	/*Метод get для зачения одной из сторон*/
	public double getC() {
		return c;
	}
	
	/*Метод set для зачения одной из сторон*/
	public void setC(double c) {
		if (c >= 0) {
			this.c = c;			
		}
	}

	/*Переопределение метода для вычисления площади фигуры*/
	@Override
	public double area() {
		double p = perimeter()/2;
		return Math.sqrt(p * (p-a) * (p - b) * (p - c));
	}

	/*Переопределение метода для вычисления периметра фигуры*/
	@Override
	public double perimeter() {
		return a + b + c;
	}

}
