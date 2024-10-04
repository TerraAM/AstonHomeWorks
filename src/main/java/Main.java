package main.java; //Определяют пакет, в котором находится файл

import java.math.BigDecimal; //Импортируем конкретный тип для денежного формата

import main.java.entity.*; //Импортируем все классы из указанной директории

/*Класс старта программы*/
public class Main
{
    public static void main( String[] args )
    {
    	/*Задаем массив из 5 объектов класса Employee*/
        Employee [] personal = {
        		new Employee("Иван Сергеевич Петров","Техник","ivan.petrov@mail.com","+79123456789",new BigDecimal(45000),40),//Не создавая лишних переменных, создаем переменную(BigDecimal) в конструктор при создании объекта
        		new Employee("Ольга Николаевна Смирнова","Бухгалтер","olga.smirnova@mail.com","+79134567890",new BigDecimal(50000),40),
        		new Employee("Алексей Андреевич Сидоров","Менеджер по продажам","alexey.sidorov@mail.com","+79145678901",new BigDecimal(55000),40),
        		new Employee("Мария Павловна Иванова","Секретарь","maria.ivanova@mail.com","+79156789012",new BigDecimal(35000),40),
        		new Employee("Дмитрий Викторович Васильев","Инженер","dmitry.vasilyev@mail.com","+79167890123",new BigDecimal(60000),40),
        };
        
        /*Перебираем все элементы массива*/
        for(Employee emp : personal) {
        	System.out.println(emp); //Простой вывод данных об обекте (выполняется при помощи переобределенного класса toString)
        }
        
        System.out.println();//Дабавлен перенос строки, для того, что бы было удобнее просматривать информацию
        
        
        Park park = new Park("Сказочный мир", "Москва");//Объявляем и инициализируем объект класса Park через конструктор с параметрами
        
        /*Создаем для него аттракционы*/
        park.addAttraction("Американские горки", "10:00 - 18:00", new BigDecimal(300));
        park.addAttraction("Колесо обозрения", "09:00 - 20:00", new BigDecimal(150.));
        park.addAttraction("Дом с привидениями", "11:00 - 22:00", new BigDecimal(250));
        
        System.out.println(park);//Выводим информацию о парке
    }
}
