package lesson16.pages;//Определяет пакет, в котором находится файл

/*Блок импорта необходимых пакетов*/
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*Класс для управления модальными окнами
 * Реализован только для куки, может расширяться в дальнейшем*/
public class ModalWindow {

	public Coockie coockie;//Поле с внутренним классом для обработки модальных окон связанных с куки
	public PaymentFrame paymentFrame;
	
	private WebDriver driver;//Поле для получения сайта, на котором происходит поиск
	private WebDriverWait driverWait;
	
	/*Конструктор класса
	 * В нем происходит инициализация необходимого внутреннего класса*/
	public ModalWindow(WebDriver driver) {
		this.driver = driver;//Задаем сайт поиска
		coockie = new Coockie();
		paymentFrame = new PaymentFrame();
		driverWait = new WebDriverWait(driver, 3);
	}
	
	public void setWebDriver (WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getWebDriver () {
		return driver;
	}
	
	/*Внутренний класс для обработки модальных окон куки*/
	public class Coockie{
		
		/*Блок полей с тектом*/
		private final String acceptText = "Принять";
		private final String rejectedText = "Отклонить";
		
		/*Блок полей с навигацией по By*/
		private By acceptButton = By.xpath("//button[text()='" + acceptText + "']");
		private By rejectedButton = By.xpath("//button[text()='" + rejectedText + "']");
		
		/*Метод принятия кук*/
		public void accept() {
			action(acceptButton);//Передаем в метод действия нужную нам кнопку для поиска
		}
		
		/*Метод отклонения кук*/
		public void reject() {
			action(rejectedButton);//Передаем в метод действия нужную нам кнопку для поиска
		}
		
		private void action(By byXmlElement) {
			try {
	            // Попробуем найти кнопку "Принять" и нажать её
	            WebElement cookiesButton = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cookie"))).findElement(byXmlElement);;
	            // Если кнопка отображается, кликаем по ней
	            if (cookiesButton.isDisplayed()) {
	                cookiesButton.click();
	                System.out.println("Баннер cookie пройден");
	            }
	        } catch (Exception e) {
	            System.out.println("Баннер cookie не найден");
	        }
		}
	}
	
	/*Внутренний класс для обработки модального окона способа оплаты*/
	public class PaymentFrame{
		
		private String rootIframeName = "bepaid-iframe";//Поле с названием фрейма модального окна
		
		//Метод для проверки текста в Label
		public boolean areLabelsHaveText(Map<String, String> expectedLabels) {
		    
			System.out.println("Пытаемся поменять рабочий фрейм...");
			//Ожидание переключения на нужный фрейм
		    driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className(rootIframeName)));
		    System.out.println("Меняем фрейм на: " + rootIframeName);

		    boolean allMatch = true;//Переменная для проверки всех совпадений текста label с ожидаемым текстом
		    //Цикл дял перебора всех полученных label
		    for (Map.Entry<String, String> entry : expectedLabels.entrySet()) {
		        
		    	//Задание переменных
		    	String className = entry.getKey();
		        String expectedText = entry.getValue();
		        
		        String actualText = getLabelTextByClass(className);
		        boolean match = actualText.equals(expectedText);//Сравнение текста с ожидаемым
		        allMatch &= match;//Сравниваем с итоговым значением

		        System.out.printf("(Class: %s) %s (Результат: %s) : %b%n", className, expectedText, actualText, match);
		    }

		    driver.switchTo().defaultContent();//Вовращение на изначальный фрейм
		    return allMatch;
		}

		private String getLabelTextByClass(String className) {
			//Получение текста от элемента по классу
		    return driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className))).getText();
		}
		
		public boolean areAllImagesDisplayedCorrectly() {
			driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className(rootIframeName)));
	        //Локатор для всех картинок
	        List<WebElement> images = driver.findElements(By.cssSelector(".cards-brands__container img, .cards-brands_random img"));
	        
	        //Проверка отображения и наличия src у каждой картинки
	        for (WebElement image : images) {
	            if (!image.isDisplayed() || image.getAttribute("src") == null) {
	                return false;  //Если картинка не отображается или src отсутствует, возвращаем false
	            }
	        }
	        
	        //Проверка картинок с изменяющимся opacity
	        List<WebElement> animatedImages = driver.findElements(By.cssSelector(".cards-brands_random img"));
	        for (int i = 0; i < 5; i++) {  // 5 проверок с задержкой
	            for (WebElement animatedImage : animatedImages) {
	                String opacity = animatedImage.getCssValue("opacity");
	                if (Double.parseDouble(opacity) == 0) {
	                    return false;  //Если opacity = 0, возвращаем false
	                }
	            }
	        }
	        
	        driver.switchTo().defaultContent();
		    return true;  //Если все проверки пройдены, возвращаем true
		}
		
		public boolean areAmountCompare(String expectedAmount) {
			
			driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className(rootIframeName)));
			    
		    //Форматируем ожидаемую сумму до двух знаков после запятой
		    String formattedExpectedAmount = String.format("%.2f BYN", Double.parseDouble(expectedAmount)).replace(',', '.');
		    
		    //Находим элемент <span> с суммой
		    WebElement amountSpan = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pay-description__cost span")));
		    String spanText = amountSpan.getText().trim();
		    
		    //Находим кнопку <button> с суммой
		    WebElement payButton = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-page__card button")));
		    String buttonText = payButton.getText().trim();
		    
		    //Проверяем, что сумма в обоих элементах соответствует ожидаемой
		    boolean spanMatches = spanText.equals(formattedExpectedAmount);
		    boolean buttonMatches = buttonText.contains(formattedExpectedAmount);
		    
		    System.out.printf("Сумма в <span>: %s, ожидаемая: %s - %b%n", spanText, formattedExpectedAmount, spanMatches);
		    System.out.printf("Сумма в <button>: %s, ожидаемая: %s - %b%n", buttonText, formattedExpectedAmount, buttonMatches);

		    return spanMatches && buttonMatches;
		}
	}
}
