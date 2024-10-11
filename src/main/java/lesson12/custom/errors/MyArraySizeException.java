package main.java.lesson12.custom.errors;//Определяет пакет, в котором находится файл

//Класс ошибки формата данных элемента массива, наслденик от главного класса ошибок Exception
public class MyArraySizeException extends Exception {

	private static final long serialVersionUID = 8851668214364540548L;//Нужен для контроля версии класса (что бы была совместимасть даже после изменения)

	//Конструктор класса
	public MyArraySizeException(String message) {
        super(message);//Вызываем конструктор родителя
	}
	
}