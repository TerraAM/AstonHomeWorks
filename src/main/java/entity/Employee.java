package main.java.entity; //Определяют пакет, в котором находится файл

import java.math.BigDecimal; //Импортируем конкретный тип для денежного формата

/*Класс описывающий сотрудника*/
public class Employee {
	
	/*Блок приватных полей класса*/
	private String name;//ФИО
	private String role;//Должность
	private String email;//Почта
	private String phone;//Телефон
	private BigDecimal salary;//Зарплата
	private int age;//Возраст
	
	/*Пустой конструктор*/
	public Employee() {
	}
	
	/*Конструктор с передачей значений для всех полей класса*/
	public Employee(String name, String role, String email,
			String phone,BigDecimal salary,int age) {
		this.name = name;//Указываем при помощи this., что параметру Этого класса присваиваеи значение передаваемой переменной
		this.role = role;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.age = age;
	}
	
	/*Переопределяем метод класса-родителя Object,
	 * тем самым редактируя вывод этого класса в виде строки*/
	@Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +//Для того, что бы закрыть(при помощи " ' ") поле с информацией (прим.: ...email='olga.smirnova@mail.com'...), можно написать "'" или '\''
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary='" + salary + '\'' +
                ", age=" + age +
                '}';
    }
}
