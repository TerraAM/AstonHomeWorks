package lesson15;//Определяет пакет, в котором находится файл

/*Блок импорта необходимых статичных пакетов*/
import static org.assertj.core.api.Assertions.assertThat;

/*Блок импорта необходимых пакетов*/
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import lesson15.helpers.ModalWindow;

/*Класс теста блока онлайн пополнения (mts.by)*/
public class MTSOnlinePaymentTest {

	    WebDriver driver;//Объявляем объект WebDriver для управления браузером
	    //Объявляем объект modalWindowChrome для управления модальными окнами
	    ModalWindow modalWindowChrome = new ModalWindow();
	    
	    /*Этот метод будет выполняться перед всеми тестами*/
	    @BeforeAll
	    static void setupClass() {
	    	/*Инициализация WebDriverManager, чтобы 
	    	 * загрузить и настроить WebDriver (в данном случае ChromeDriver)*/
	        WebDriverManager.chromedriver().setup();
	        
	    }

	    /*Этот метод будет выполняться перед каждым тестом*/
	    @BeforeEach
	    void setupTest() {
	        driver = new ChromeDriver();//Создаем новый экземпляр браузера Chrome перед каждым тестом
	        driver.get("https://mts.by");//Открываем сайт MTS.by
	        //Вызываем метод для принятия куки, если на сайте появляется баннер с предложением принять их
	        modalWindowChrome.coockie.accept(driver);
	    }

	    /*Этот метод будет выполняться после каждого теста*/
	    @AfterEach
	    void teardown() {
	        driver.quit();//Закрываем браузер после выполнения теста, чтобы не перегружать память
	    }
	    
	    /*Тест для проверки названия блока "Онлайн пополнение без комиссии"*/
	    @Test
	    void checkBlockTitle() {
	    	System.out.println("\nПроверка названия блока:");
	    	//Находим элемент заголовка блока по селектору CSS
	        WebElement blockTitle = driver.findElement(By.cssSelector(".pay__wrapper h2"));
	        
	        //Получаем текст заголовка, заменяя символы новой строки пробелами, и удаляем лишние пробелы
	        String titleText = blockTitle.getText().replace("\n", " ").trim();
	        System.out.println("Полученное сообщение: " + titleText);
	        
	        //Проверяем, что текст заголовка соответствует ожидаемому значению
	        assertThat(titleText).isEqualTo("Онлайн пополнение без комиссии");
	    }

	    /*Тест для проверки наличия логотипов платёжных систем*/
	    @Test
	    void checkPaymentSystemLogos() {
	    	System.out.println("\nПроверка наличи логотипов:");
	    	//Задаем массив с названиеями платежных систем
	        String[] expectedAltTexts = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
	        
	        //Проходим по каждому значению в массиве и проверяем наличие соответствующего логотипа на странице
	        for (String altText : expectedAltTexts) {
	        	
	        	// Находим элемент изображения по его атрибуту alt
	            WebElement logo = driver.findElement(By.xpath("//img[@alt='" + altText + "']"));
	            //Проверяем, что логотип отображается на странице
	            assertThat(logo.isDisplayed()).isTrue();
	            
	            System.out.printf("%s: %b%n",altText,logo.isDisplayed());//Логируем информацию
	        
	        }
	    }

	    /*Тест для проверки ссылки "Подробнее о сервисе"*/
	    @Test
	    void checkMoreInfoButton() {
	    	System.out.println("\nПроверка ссылки 'Подробнее о сервисе':");
	    	//Находим ссылку с текстом "Подробнее о сервисе" на странице
	    	WebElement moreInfoButton = driver.findElement(By.linkText("Подробнее о сервисе"));
	        
	    	//Проверяем, что ссылка отображается на странице
	    	assertThat(moreInfoButton.isDisplayed()).isTrue();
	        moreInfoButton.click();
	        
	        //Проверяем, что после клика открывается правильная страница по URL
	        assertThat(driver.getCurrentUrl()).contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/");
	    }

	    /*Тест для проверки формы "Услуги связи"*/
	    @Test
	    void checkFormSubmissionForConnection() {

	    	System.out.println("\nПроверка работы формы 'Услуги связи':");
	        //Выбираем "Услуги связи", хотя он выбран по умолчанию
	        WebElement serviceOption = driver.findElement(By.cssSelector("select#pay"));
	        assertThat(serviceOption.getAttribute("value")).isEqualTo("Услуги связи");

	        /*Блок заполнения полей*/
	        WebElement phoneField = driver.findElement(By.id("connection-phone"));
	        phoneField.sendKeys("297777777");
	        WebElement sumField = driver.findElement(By.id("connection-sum"));
	        sumField.sendKeys("10");
	        WebElement emailField = driver.findElement(By.id("connection-email"));
	        emailField.sendKeys("test@example.com");

	        //Нажимаем "Продолжить"
	        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection button[type='submit']"));
	        continueButton.click();

	        //Проверка результата (для примера — проверка, что форма не осталась открытой)
	        WebElement form = driver.findElement(By.id("pay-connection"));
	        assertThat(form.isDisplayed()).isTrue(); //В зависимости от логики сайта, проверку можно изменить
	    }

}
