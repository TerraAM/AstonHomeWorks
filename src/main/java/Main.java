import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Блок объявления и инициализации нужных переменных
		Main lesson_2 = new Main();
		Scanner scanner = new Scanner(System.in);
		int num;
		String inputLine;
		
		/*------------------------------------------------
		 * Пункт 1
		 * -----------------------------------------------*/
		System.out.println("Пункт 1:");
		lesson_2.printThreeWords();
		System.out.println();
		
		/*------------------------------------------------
		 * Пункт 2
		 * -----------------------------------------------*/
		System.out.println("Пункт 2:");
		lesson_2.checkSunSign();
		System.out.println();
		
		/*------------------------------------------------
		 * Пункт 3
		 * -----------------------------------------------*/
		System.out.println("Пункт 3:");
		lesson_2.printСolor();
		System.out.println();
		
		/*------------------------------------------------
		 * Пункт 4
		 * -----------------------------------------------*/
		System.out.println("Пункт 4:");
		lesson_2.compareNumbers();
		System.out.println();
		
		/*------------------------------------------------
		 * Пункт 5
		 * -----------------------------------------------*/
		System.out.print("Пункт 5:\n"
				+ "Введите два целых числа:\n"
				+ "A: ");
		int point5_fNum = scanner.nextInt();
		System.out.print("B: ");
		int point5_SNum = scanner.nextInt();
		System.out.println("Результат выполнения метода: " + lesson_2.isSumFrom10to20(point5_fNum, point5_SNum));
		System.out.println();
		
		/*------------------------------------------------
		 * Пункт 6
		 * -----------------------------------------------*/
		System.out.print("Пункт 6:\n"
				+ "Введите целое число: ");
		num = scanner.nextInt();
		System.out.println("Результат выполнения метода: " + lesson_2.isNumPositive(num));
		System.out.println();
		
		/*------------------------------------------------
		 * Пункт 7
		 * -----------------------------------------------*/
		System.out.print("Пункт 7:\n"
				+ "Введите целое число: ");
		num = scanner.nextInt();
		System.out.println("Результат выполнения метода: " + lesson_2.isNumNegative(num));
		System.out.println();
		
		/*------------------------------------------------
		 * Пункт 8
		 * -----------------------------------------------*/
		scanner.nextLine();
		System.out.print("Пункт 8:\n"
				+ "Введите строку: ");
		inputLine = scanner.nextLine();
		System.out.print("Введите кол-во повторений: ");
		num = scanner.nextInt();
		lesson_2.repeatLineNTimes(inputLine, num);
		System.out.println();
		
		/*------------------------------------------------
		 * Пункт 9
		 * -----------------------------------------------*/
		System.out.print("Пункт 9:\n"
				+ "Введите целое число: ");
		num = scanner.nextInt();
		System.out.println("Результат выполнения метода: " + lesson_2.isLeapYear(num));
		System.out.println();
		
		/*------------------------------------------------
		 * Пункт 10
		 * -----------------------------------------------*/
		System.out.println("Пункт 10:");
		lesson_2.arrayRevers0and1();
		System.out.println();
		
		/*------------------------------------------------
		 * Пункт 11
		 * -----------------------------------------------*/
		System.out.println("Пункт 11:");
		lesson_2.arrayFill1to100();
		System.out.println();
		
		/*------------------------------------------------
		 * Пункт 12
		 * -----------------------------------------------*/
		System.out.println("Пункт 12:");
		lesson_2.arrayChangeByCondition();
		System.out.println();
		
		/*------------------------------------------------
		 * Пункт 13
		 * -----------------------------------------------*/
		System.out.println("Пункт 13:");
		lesson_2.DoubleArrayDiagonalsTo1();
		System.out.println();
		
		/*------------------------------------------------
		 * Пункт 14
		 * -----------------------------------------------*/
		scanner.nextLine();
		System.out.print("Пункт 14:\n"
				+ "Введите два целых числа:\n"
				+ "len: ");
		int point14_len = scanner.nextInt();
		System.out.print("initialValue: ");
		int point14_initialValue = scanner.nextInt();
		lesson_2.arrayCreate(point14_len,point14_initialValue);
	}
	
	/* Пункт 1:
	 * Метод, который должен отпечатать в столбец три слова:
	 * Orange, Banana, Apple*/
	public void printThreeWords(){
		System.out.println("Orange\nBanana\nApple");
	}
	
	/* Пункт 2:
	 * Метод, в теле которого нужно было объявить и инициализировать две
	 * int переменные, потом проверить их сумму и вывести сообщение: 
	 * Сумма положительная/отрицательная*/
	public void checkSunSign() {
		//Блок объявления и инициализации
		int a = 10;
		int b = -9;
		int sum = a + b;
		
		//Условия проверки и вывод
		if (sum >=0 ) {
			System.out.println("Сумма положительная");
		} else {
			System.out.println("Сумма отрицательная");
		}
	}
	
	/* Пункт 3:
	 * Метод, в теле которого нужно было объявить и инициализировать
	 * int переменную value. В зависимости от ее значения вывести сообщение:
	 * value <=0: "Красный"
	 * 0 < value <= 100: "Желтый"
	 * value > 100: "Зеленый" */
	public void printСolor() {
		//Блок объявления и инициализации
		int value = 57;
		
		//Условия проверки и вывод
		if (value <= 0) {
			System.out.println("Красный");		
		}
		if (value > 0 && value <= 100) {
			System.out.println("Желтый");
		}
		if (value > 100) {
			System.out.println("Зеленый");
		}
	}
	
	/* Пункт 4:
	 * Метод, в теле которого нужно было объявить и инициализировать две
	 * int переменные. В зависимости от результат их сравнения вывести сообщение:
	 * a >= b: "a >= b"
	 * a < b: "a < b"*/
	public void compareNumbers() {
		//Блок объявления и инициализации
		int a = 13;
		int b = 64;
		
		//Условия проверки и вывод
		if (a >= b) {
			System.out.println("a >= b");
		} else {
			System.out.println("a < b");
		}
	}
	
	/* Пункт 5:
	 * Метод, который принимает два целых числа,
	 * потом проверяет входит ли их сумма в диапазон:
	 * 10 <= sum <= 20: вернуть true"
	 * Если не входит в диапозон: вернуть false*/
	public Boolean isSumFrom10to20(int fNum, int sNum) {
		//Блок объявления и инициализации
		int sum = fNum + sNum;
		
		//Условия проверки и вывод
		if (sum >= 10 && sum <=20) {
			return true;
		}
		return false;
	}
	
	/* Пункт 6:
	 * Метод, который принимает одно целое число,
	 * потом проверяет какое оно:
	 * num >= 0: вернуть true"
	 * num < 0: вернуть false*/
	public Boolean isNumPositive (int num) {
		return num >= 0 ? true : false; //Тернарный оператор для сокращения кода и вывода нужного ответа
	}
	
	/* Пункт 7:
	 * Метод, который принимает одно целое число,
	 * потом проверяет какое оно:
	 * num < 0: вернуть true"
	 * num >= 0: вернуть false*/
	public Boolean isNumNegative (int num) {
		return num < 0 ? true : false; //Тернарный оператор для сокращения кода и вывода нужного ответа
	}
	
	/* Пункт 8:
	 * Метод, который принимает одно целое число и строку,
	 * потом повторяет эту строку N раз*/
	public void repeatLineNTimes (String line, int n) {
		for(int i = 0; i<n;i++) {
			//Выполняем вывод информации %d для вывода цифры, %s для строки и %n для переноса на следующуюю строку
			System.out.printf("%d: %s%n",i+1,line); 
		}
	}
	
	/* Пункт 9:
	 * Метод, которые принимает одно целое число в виде года,
	 * потом проверяет его на высоконость:
	 * Каджый 4 и 400, каждый 100 исключение: вернуть true"
	 * Если не подходит под условие: вернуть false*/
	public Boolean isLeapYear (int year) {
		//Условия проверки и вывод
		if((year % 4 == 0) && (year % 100 != 0) && (year % 400 == 0)) {
			return true;
		}
		return false;
	}
	
	/* Пункт 10:
	 * Метод, в теле которого задан целочисленный массив.
	 * Задача: поменять 0 на 1 и 1 на 0*/
	public void arrayRevers0and1 () {
		//Блок объявления и инициализации
		int [] array = {0,1,0,1,0,1,0,1,0,0,0,1,0};
		
		//Блок вывода инфомрации о массиве
	    System.out.println("Изначальный массив:");
	    printIntArray(array);//Используем вспомогательный метод для вывода массива
		
	    //Цикл дял перебора элементов массива
		for(int i = 0;i < array.length;i++){
			//Условие для смены местами 0 и 1
			if (array[i] == 0) {
				array[i] = 1;
			} else {
				array[i] = 0;
			}
		}
		
		//Блок вывода инфомрации о массиве
		System.out.println("Измененный массив:");
	    printIntArray(array);//Используем вспомогательный метод для вывода массива
	}
	
	/* Пункт 11:
	 * Метод, в теле которого задан целочисленный массив.
	 * Задача: заполнить массив длинной 100, числами от 1 до 100*/
	public void arrayFill1to100 () {
		//Блок объявления и инициализации
		int [] array = new int[100];
		
		//Цикл для заполнения массива
		for(int i = 0;i < array.length;i++){
			array[i] = i+1;
		}
		
		//Блок вывода инфомрации о массиве
		System.out.println("Заполненный массив:");
	    printIntArray(array);//Используем вспомогательный метод для вывода массива
	}
	
	/* Пункт 12:
	 * Метод, в теле которого задан целочисленный массив.
	 * Задача: пройтись по массиву, изменить его значения пододящие под условие
	 * Условие: числа меньше 6 умножить на 2*/
	public void arrayChangeByCondition () {
		//Блок объявления и инициализации
		int [] array = {1,5,3,2,11,4,5,2,4,8,9,1};
		
		//Блок вывода инфомрации о массиве
		System.out.println("Изначальный массив:");
	    printIntArray(array);//Используем вспомогательный метод для вывода массива
		
	    //Цикл для перебора элементов массива
		for(int i = 0;i<array.length;i++){
			//Условие для умножения на 2 чисел меньше 6
			if(array[i] < 6) {
				array[i] *= 2;
			}
		}
		
		//Блок вывода инфомрации о массиве
		System.out.println("Измененный массив:");
	    printIntArray(array);//Используем вспомогательный метод для вывода массива
	}
	
	/* Пункт 13:
	 * Метод, в теле которого задан двумерный целочисленный массив.
	 * Задача: заполнить диагонали заполнить 1
	 * Условие: числа меньше 6 умножить на 2*/
	public void DoubleArrayDiagonalsTo1 () {
		//Блок объявления и инициализации
		int [][] array = new int [10][10];
		
		//Цикл для перебора строк двумерного массива
		for (int i = 0; i < array.length;i++) {
			//Цикл для перебора элементов строки двумерного массива
			for(int j = 0;j < array[i].length;j++) {
				//Условие для выделения левой диагонали
				if (j == i) {
					array[i][j] = 1;
				} else {
					//Условие для выделения правой диагонали
					if (j == (array[i].length - (1+i))) {
						array[i][j] = 1;
					} else {
						array[i][j] = 0;					
					}
				}
			}
		}
		
		System.out.println("Заполненный массив:");
		printIntDoubleArray(array);//Используем вспомогательный метод для вывода массива
	}
	
	/* Пункт 14:
	 * Метод, которые принимает два целочисленных числа
	 * Одно число определяет длину, другой значение для элементов*/
	public void arrayCreate (int len, int initialValue) {
		//Блок объявления и инициализации
		int [] array = new int[len];
		
		//Цикл для перебора элементов массива
		for(int i = 0;i < array.length;i++){
			array[i] = initialValue;
		}
		
		//Блок вывода инфомрации о массиве
		System.out.println("Заполненный массив:");
	    printIntArray(array);//Используем вспомогательный метод для вывода массива
	}
	
	/* Вспомогательный метод для 
	 * отображения целочисленных массивов*/
	public static void printIntArray(int [] array) {
		//Цикл для перебора элементов массива
		for (int num : array) {
			System.out.printf("%d ",num);
		}
		//Переводим на следующую строку
		System.out.println();
	}
	/* Вспомогательный метод для 
	 * отображения целочисленных массивов*/
	public static void printIntDoubleArray(int [][] array) {
		//Цикл для перебора строк двумерного массива
		for (int i = 0; i < array.length;i++) {
			//Обращаемся к вспомогательному методу перебора массива
			printIntArray(array[i]);
		}
	}
	
}
