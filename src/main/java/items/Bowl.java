package main.java.items;//Определяют пакет, в котором находится файл

/*Класс миски с едой*/
public class Bowl {
	
	int amount;//Поле кол-ва еды в миске
	
	/*Реализация пустого конструктора класса*/
	public Bowl() {}
	/*Реализация конструктора класса*/
	public Bowl(int amount) {
		if (amount >= 0) {//Защита от отрицательных полей
			this.amount += amount;		
		}
	}
	/*Метод взятия еды из миски*/
	public boolean take(int amount) {
		if (this.amount - amount >=0) {//Защита от отрицательных полей
			this.amount -= amount;//Вычитаем из миски еду
			return true;
		} else {
			return false;
		}
	}
	/*Метод наполнения миски*/
	public void fill(int amount) {
		if (amount > 0) {//Защита от отрицательных полей
			this.amount += amount;		
		}
	}
	/*Метод get для поля amount*/
	public int getAmount() {
		return amount;
	}
}
