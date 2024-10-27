package lesson16;//Определяет пакет, в котором находится файл

/*Блок импорта необходимых статичных пакетов*/
import static org.assertj.core.api.Assertions.assertThat;

/*Блок импорта необходимых пакетов*/
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson16.pages.MTSOnlinePaymentPage;

/*Класс теста блока онлайн пополнения (mts.by)*/
public class MTSOnlinePaymentTest {

	    /*Блок задания полей*/
	    private WebDriver driver;
	    private MTSOnlinePaymentPage mtsOnlinePaymentPage;
	    private String pathMoreInfo = "/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
	    private String titleOnlinePayment = "Онлайн пополнение без комиссии";
	    private String[] expectedAltTexts = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
	    private String phone = "297777777"; 
	    private String sum = "10";
	    private String email = "test@example.com";
	
	    //Задание стартовых настроек перед всеми классами
	    @BeforeAll
	    static void setupClass() {
	        WebDriverManager.chromedriver().setup();
	    }
	
	    //Задание настроек перед каждым тестом
	    @BeforeEach
	    void setupTest() {
	        driver = new ChromeDriver();
	        driver.get("https://mts.by");
	        mtsOnlinePaymentPage = new MTSOnlinePaymentPage(driver);
	        mtsOnlinePaymentPage.rejectCookies();
	    }
	
	    //Задание настроек после завершения каждого теста
	    @AfterEach
	    void teardown() {
	        driver.quit();
	    }
	
	    //Тест проверки названия блока 'Онлайн пополнение без комиссии'
	    @DisplayName("Проверка названия блока")
	    @Test
	    void checkBlockTitle() {
	        assertThat(mtsOnlinePaymentPage.getBlockTitle()).isEqualTo(titleOnlinePayment);
	    }
	
	    //Тест проверки наличия логотипов платежных систем
	    @DisplayName("Проверка наличия логотипов платежных систем")
	    @Test
	    void checkPaymentSystemLogos() {
	        assertThat(mtsOnlinePaymentPage.areAllLogosDisplayed(expectedAltTexts)).isTrue();
	    }
	
	    //Тест проверка ссылки 'Подробнее о сервисе'
	    @DisplayName("Проверка ссылки 'Подробнее о сервисе'")
	    @Test
	    void checkMoreInfoButton() {
	        assertThat(mtsOnlinePaymentPage
	        							   .clickMoreInfoButton()
	        							   .getCurrentUrl())
	        							   .contains(pathMoreInfo);
	    }
	
	    //Тест проверки работы формы 'Услуги связи'
	    @DisplayName("Проверка работы формы 'Услуги связи':")
	    @Test
	    void checkFormSubmissionForConnection() {
	        assertThat(mtsOnlinePaymentPage
	        							   .fillConnectionForm(phone, sum, email)
	        							   .submitConnectionForm()
	        							   .isConnectionFormDisplayed()).isTrue();
	    }
	    
	    //Тест проверки placeholder для формы 'Услуги связи'
	    @DisplayName("Проверка placeholder для формы 'Услуги связи'")
	    @Test
	    void checkConnectionPlaceholders() {
	        assertThat(mtsOnlinePaymentPage.checkConnectionPlaceholders()).isTrue();
	    }

	    //Тест проверки placeholder для формы 'Домашний интернет'
	    @DisplayName("Проверка placeholder для формы 'Домашний интернет'")
	    @Test
	    void checkInternetPlaceholders() {
	        assertThat(mtsOnlinePaymentPage.checkInternetPlaceholders()).isTrue();
	    }

	    //Тест проверки placeholder для формы 'Рассрочка'
	    @DisplayName("Проверка placeholder для формы 'Рассрочка'")
	    @Test
	    void checkInstalmentPlaceholders() {
	        assertThat(mtsOnlinePaymentPage.checkInstalmentPlaceholders()).isTrue();
	    }

	    //Тест проверки placeholder для формы 'Задолженность'
	    @DisplayName("Проверка placeholder для формы 'Задолженность'")
	    @Test
	    void checkArrearsPlaceholders() {
	        assertThat(mtsOnlinePaymentPage.checkArrearsPlaceholders()).isTrue();
	    }
	    
	    //Тест проверки текста в незаполненных полях модального окна оплаты
	    @DisplayName("Модальное окно оплаты. Проверка текста в незаполненных полях")
	    @Test
	    void checkPaymentFrameLabelsText() {
	        assertThat(mtsOnlinePaymentPage
	        							   .fillConnectionForm(phone, sum, email)
	        							   .submitConnectionForm()
	        							   .checkPaymentFrameLabelsText()).isTrue();
	    }
	    
	    //Тест проверки отображения логотипов банковских компаний модального окна оплаты
	    @DisplayName("Модальное окно оплаты. Проверка отображения логотипов банковских компаний:")
	    @Test
	    void checkPaymentFrameImg() {
	        assertThat(mtsOnlinePaymentPage
	        							   .fillConnectionForm(phone, sum, email)
	        							   .submitConnectionForm()
	        							   .checkPaymentFrameImg()).isTrue();
	    }
	    
	    //Тест проверки отображения суммы на окне и на кнопке модального окна оплаты
	    @DisplayName("Модальное окно оплаты. Проверка отображения суммы на окне и на кнопке:")
	    @Test
	    void checkPaymentFrameAmount() {
	        assertThat(mtsOnlinePaymentPage
	        							   .fillConnectionForm(phone, sum, email)
	        							   .submitConnectionForm()
	        							   .checkAmount(sum)).isTrue();
	    }
}
