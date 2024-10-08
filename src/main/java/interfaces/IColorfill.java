package main.java.interfaces;//Определяют пакет, в котором находится файл

/*Интерфейс для цветов фона и границ*/
public interface IColorfill {
	
	/*Задание пустого get метода цвета фона для обязательной реализации*/
	String getBackGroundColor();
	/*Задание пустого set метода цвета фона для обязательной реализации*/
	void setBackGroundColor(String color);
	/*Задание пустого get метода цвета границ для обязательной реализации*/
	String getBorderColor();
	/*Задание пустого set метода цвета границ для обязательной реализации*/
	void setBorderColor(String color);
	
}
