package lesson16.pages;//Определяет пакет, в котором находится файл

/*Блок импорта необходимых пакетов*/
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

/*Класс для обработки страницы онлайн оплаты*/
public class MTSOnlinePaymentPage {


	//Элементы страницы
	private WebDriver driver;
	private ModalWindow modalWindow;
	private By blockTitle = By.cssSelector(".pay__wrapper h2");
	private By moreInfoButton = By.linkText("Подробнее о сервисе");
	private By connectionPhoneField = By.id("connection-phone");
	private By connectionSumField = By.id("connection-sum");
	private By connectionEmailField = By.id("connection-email");
	private By continueButton = By.cssSelector("#pay-connection button[type='submit']");
	private By connectionForm = By.id("pay-connection");

    //Конструктор для инициализации WebDriver
    public MTSOnlinePaymentPage(WebDriver driver) {
        this.driver = driver;
        modalWindow = new ModalWindow(driver);
    }

    //Метод для принятия cookies
    @Step
    public MTSOnlinePaymentPage acceptCookies() {
        modalWindow.coockie.accept();
        return this;
    }
    
    //Метод для отказа от cookies
    @Step
    public MTSOnlinePaymentPage rejectCookies() {
        modalWindow.coockie.reject();
        return this;
    }

    //Получение текста заголовка блока
    @Step
    public String getBlockTitle() {
    	Allure.step("Полученное сообщение: " + driver.findElement(blockTitle).getText().replace("\n", " ").trim());
        return driver.findElement(blockTitle).getText().replace("\n", " ").trim();
    }

    //Проверка отображений логотипов по alt тексту
    @Step
    public boolean areAllLogosDisplayed(String[] expectedAltTexts) {
        boolean allMatch = true;//Переменная для проверки всех совпадений текста label с ожидаемым текстом
        //Цикл дял перебора всех полученных данных
        String message = "";
        for (String altText : expectedAltTexts) {
            WebElement logo = null;
            try {
                logo = driver.findElement(By.xpath("//img[@alt='" + altText + "']"));
                boolean isDisplayed = logo.isDisplayed();
                message = String.format("Логотип с alt=%s отображается: %b%n", altText, isDisplayed);
                allMatch &= isDisplayed;
            } catch (NoSuchElementException e) {
            	message = String.format("Логотип с alt=%s не найден %n", altText);
                allMatch = false;
            } finally {
            	Allure.step(message);
            }
        }
        return allMatch;
    }

    //Проверка и клик по кнопке "Подробнее о сервисе"
    @Step
    public MTSOnlinePaymentPage clickMoreInfoButton() {
        driver.findElement(moreInfoButton).click();
        Allure.step("Результат перехода по ссылке: " + getCurrentUrl());
        return this;
    }

    //Получение текущего URL страницы
    @Step
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    //Метод для заполнения формы "Услуги связи"
    @Step
    public MTSOnlinePaymentPage fillConnectionForm(String phone, String sum, String email) {
        driver.findElement(connectionPhoneField).sendKeys(phone);
        driver.findElement(connectionSumField).sendKeys(sum);
        driver.findElement(connectionEmailField).sendKeys(email);
        String message = String.format("Заполнение даннными:%n"
				 + "Тел.: %s%n"
				 + "Сум.: %s%n"
				 + "Почта: %s%n",phone,sum,email);
        Allure.step(message);
        return this;
    }

    //Нажатие кнопки "Продолжить" для отправки формы
    @Step
    public MTSOnlinePaymentPage submitConnectionForm() {
        driver.findElement(continueButton).click();
        return this;
    }

    //Проверка видимости формы после отправки
    @Step
    public boolean isConnectionFormDisplayed() {
        return driver.findElement(connectionForm).isDisplayed();
    }
    
    //Проверка placeholder-ов
    @Step
    public boolean checkPlaceholders(Map<String, String> expectedPlaceholders) {
        boolean allMatch = true;//Переменная для проверки всех совпадений текста label с ожидаемым текстом
        //Цикл дял перебора всех полученных данных
        for (Map.Entry<String, String> entry : expectedPlaceholders.entrySet()) {
            String id = entry.getKey();
            String expectedPlaceholder = entry.getValue();
            
            String actualPlaceholder = driver.findElement(By.id(id)).getAttribute("placeholder");
            boolean match = expectedPlaceholder.equals(actualPlaceholder);
            allMatch &= match;

            String message = String.format("(Id: %s) %s (Результат: %s) : %b%n", id, expectedPlaceholder, actualPlaceholder, match);
            Allure.step(message);
        }

        return allMatch;
    }
    
    //Проверка текста пустых полей вкладки 'Услуги связи'
    @Step
    public boolean checkConnectionPlaceholders() {
    	Map<String, String> expectedPlaceholders = new HashMap<>();
    	expectedPlaceholders.put("connection-phone", "Номер телефона");
    	expectedPlaceholders.put("connection-sum", "Сумма");
    	expectedPlaceholders.put("connection-email", "E-mail для отправки чека");

    	return checkPlaceholders(expectedPlaceholders);
    }

    //Проверка текста пустых полей вкладки 'Домашний интернет'
    @Step
    public boolean checkInternetPlaceholders() {
    	Map<String, String> expectedPlaceholders = new HashMap<>();
    	expectedPlaceholders.put("internet-phone", "Номер абонента");
    	expectedPlaceholders.put("internet-sum", "Сумма");
    	expectedPlaceholders.put("internet-email", "E-mail для отправки чека");

    	return checkPlaceholders(expectedPlaceholders);
    }

    //Проверка текста пустых полей вкладки 'Рассрочка'
    @Step
    public boolean checkInstalmentPlaceholders() {
    	Map<String, String> expectedPlaceholders = new HashMap<>();
    	expectedPlaceholders.put("score-instalment", "Номер счета на 44");
    	expectedPlaceholders.put("instalment-sum", "Сумма");
    	expectedPlaceholders.put("instalment-email", "E-mail для отправки чека");

    	return checkPlaceholders(expectedPlaceholders);
    }

    //Проверка текста пустых полей вкладки 'Задолженность'
    @Step
    public boolean checkArrearsPlaceholders() {
    	Map<String, String> expectedPlaceholders = new HashMap<>();
    	expectedPlaceholders.put("score-arrears", "Номер счета на 2073");
    	expectedPlaceholders.put("arrears-sum", "Сумма");
    	expectedPlaceholders.put("arrears-email", "E-mail для отправки чека");

    	return checkPlaceholders(expectedPlaceholders);
    }
    
    //Проверка текста пустых полей модального окна оплаты
    @Step
    public boolean checkPaymentFrameLabelsText() {
    	Map<String, String> expectedLabels = new HashMap<>();
    	expectedLabels.put("ng-tns-c46-1", "Номер карты");
    	expectedLabels.put("ng-tns-c46-4", "Срок действия");
    	expectedLabels.put("ng-tns-c46-5", "CVC");
    	expectedLabels.put("ng-tns-c46-3", "Имя держателя (как на карте)");
    	
    	return modalWindow.paymentFrame.areLabelsHaveText(expectedLabels);
    }
    
    //Проверка лого платежных систем в модальном окне
    @Step
    public boolean checkPaymentFrameImg() {
    	return modalWindow.paymentFrame.areAllImagesDisplayedCorrectly();
    }
    
    //Проверка суммы оплаты на модальном окне
    @Step
    public boolean checkAmount(String sum) {
    	return modalWindow.paymentFrame.areAmountCompare(sum);
    }
}
