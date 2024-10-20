package test.java.lesson14_junit5;//Определяет пакет, в котором находится файл

/*Блок импорта необходимых пакетов*/
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/*Блок импорта необходимых классов*/
import main.java.lesson14_junit5.custom.Factorial;

/*Класс проверки факториала*/
public class FactorialTest {

	private Factorial fact;//Объект Factorial будет использоваться во всех тестах

	/*Этот метод будет выполняться перед каждым тестом и 
	 * инициализировать объект Factorial*/
    @BeforeEach
    public void setUp() {
        //arrange
    	fact = new Factorial();
    }
    
    /* Параметризованный тест, проверяющий различные входные 
     * значения и ожидаемые результаты*/
    @ParameterizedTest
    @CsvSource({
        "0, 1",   // Факториал 0 = 1
        "1, 1",   // Факториал 1 = 1
        "5, 120", // Факториал 5 = 120
        "10, 3628800" // Факториал 10 = 3628800
    })
    
    public void testFactorial(int input, int expected) {
        //act
        var result = fact.calculate(input);
        //assert
        assertEquals(expected, result);
    }

    /*Тест, проверяющий выброс исключения при 
     * передаче отрицательного числа*/
    @Test
    public void testFactorialThrowsExceptionForNegativeNumber() {
        //assert + act
        assertThrows(IllegalArgumentException.class, () -> fact.calculate(-1));
        /*Ожидаем исключение IllegalArgumentException при передаче отрицательного числа*/
    }
	
	
}
