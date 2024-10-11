package main.java.lesson11.animals;//Определяют пакет, в котором находится файл

/*Класс-наследник собаки от животного*/
public class Dog extends Animal{
	static int DogCount;//Статичное поле (для всех этих классов и его наследников, оно едино) подсчета кол-ва животных
	
	/*Реализация конструктора
	 * Animal(name) -> Dog(name)*/
	public Dog(String name) {
		super(name);
		DogCount++;
	}
	/*Переопределение метода бега для собаки от родителя*/
	@Override
	public void run(int dist) {
		if (dist < 0 || dist > 500) {//Собака может пробежать до 500 метров
			System.out.printf("%s не смог пробежать :(%n",name,dist);
		} else {
			System.out.printf("%s пробежал %d%n",name,dist);
		}
	}
	/*Переопределение метода плыть для собаки от родителя*/
	@Override
	public void swim(int dist) {
		if (dist < 0 || dist > 10) {//Собака может проплыть до 10 метров
			System.out.printf("%s не смог проплыть :(%n",name,dist);
		} else {
			System.out.printf("%s проплыл %d%n",name,dist);
		}
	}
	/*Метод для получения кол-ва собак*/
	public int getCount() {
		return DogCount;
	}
}
