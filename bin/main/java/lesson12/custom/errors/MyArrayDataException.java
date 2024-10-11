package main.java.lesson12.custom.errors;//Определяет пакет, в котором находится файл

//Класс ошибки формата данных элемента массива, наслденик от главного класса ошибок Exception
public class MyArrayDataException extends Exception{
	
	private static final long serialVersionUID = 9043070217069408347L;//Нужен для контроля версии класса (что бы была совместимасть даже после изменения)

	//Конструктор класса
	public MyArrayDataException(String message) {
        super(message);//Вызываем конструктор родителя
	}
}
