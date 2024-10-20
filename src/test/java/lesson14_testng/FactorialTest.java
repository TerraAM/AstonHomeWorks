package test.java.lesson14_testng;//Определяет пакет, в котором находится файл

/*Блок импорта необходимых пакетов*/
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*Блок импорта необходимых классов*/
import main.java.lesson14_testng.custom.Factorial;

/*Класс проверки факториала*/
public class FactorialTest {

    private Factorial fact;//Объект Factorial будет использоваться во всех тестах

    /*Этот метод будет выполняться перед каждым тестом и 
	 * инициализировать объект Factorial*/
    @BeforeMethod
    public void setUp() {
    	//arrange
        fact = new Factorial();
    }

    /* DataProvider для передачи различных входных 
     * значений и ожидаемых результатов*/
    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][]{
            {0, 1},       // Факториал 0 должен быть 1
            {1, 1},       // Факториал 1 должен быть 1
            {5, 120},     // Факториал 5 должен быть 120
            {10, 3628800} // Факториал 10 должен быть 3628800
        };
    }

    /* Тест с использованием DataProvider для проверки вычисления факториала*/
    @Test(dataProvider = "factorialData")
    public void testFactorial(int input, int expected) {
        // act
        var result = fact.calculate(input);
        // assert
        assertEquals(result, expected);
    }

    /* Тест для проверки выброса исключения при передаче отрицательного числа*/
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialThrowsExceptionForNegativeNumber() {
        // act
        fact.calculate(-1);
        /*Ожидаем исключение IllegalArgumentException при передаче отрицательного числа*/
    }
}
