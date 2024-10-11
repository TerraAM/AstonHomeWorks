package main.java.lesson11.animals;//Определяют пакет, в котором находится файл

/*Блок импорта необходимых классов*/
import main.java.lesson11.items.Bowl;

/*Класс-наследник кошки от животного*/
public class Cat extends Animal{
	static int CatCount;//Статичное поле (для всех этих классов и его наследников, оно едино) подсчета кол-ва животных
	int hunger;//Шкала голода (сколько еды нужно, что бы он стал сытым)
	
	/*Реализация конструктора
	 * Animal(name) -> Cat(name)*/
	public Cat(String name) {
		super(name);
		CatCount++;
	}
	/*Реализация конструктора
	 * Animal(name) -> Cat(name,hunger)*/
	public Cat(String name, int hunger) {
		super(name);
		this.hunger = hunger;
		CatCount++;
	}
	/*Переопределение метода бега для кошки от родителя*/
	@Override
	public void run(int dist) {
		if (dist < 0 || dist >200) {//Кот может пробежать до 200 метров
			System.out.printf("%s не смог пробежать :(%n",name,dist);
		} else {
			System.out.printf("%s пробежал %d%n",name,dist);
		}
	}
	/*Переопределение метода плаванья для кошки от родителя*/
	@Override
	public void swim(int dist) {
		System.out.printf("%s не умеет плавать :(%n",name);//Кот не умеет плавать (по условию)
	}
	/*Метод для получения кол-ва котов*/
	public int getCount() {
		return CatCount;
	}
	/*Метод кушать из миски*/
	public void eat(Bowl bowl) {
		if (bowl.take(hunger)) {
			hunger = 0;
		}
	}
	/*Метод для проверки голоден ли кот*/
	public boolean isHunger() {
		return !(hunger == 0);
	} 
}
