package main.java.lesson11.animals;//Определяют пакет, в котором находится файл

/*Абстрактный класс родитель для животных*/
public abstract class Animal {
	String name;//Поле имени
	static int AnimalCount;//Статичное поле (для всех этих классов и его наследников, оно едино) подсчета кол-ва животных
	
	public abstract void run(int dist);//Указание абстрактного метода(без тела), необходимого для реализации в классе-каследнике
	public abstract void swim(int dist);//Указание абстрактного метода(без тела), необходимого для реализации в классе-каследнике
	
	/*Реализация конструктора*/
	public Animal(String name) {
		this.name = name;
		AnimalCount++;
	}
	
	/*get для поля name*/
	public String getName() {
		return name;
	}
	/*set для поля name*/
	public void setName(String name) {
		this.name = name;
	}
	/*Метод для получения кол-ва животных*/
	public int getCount() {
		return AnimalCount;
	}
	/*Метод для получения кол-ва всех классов Animal и его классов наследника животных*/
	public static int getAnimalCount() {
		return AnimalCount;
	}
}
