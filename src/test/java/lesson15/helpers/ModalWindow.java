package lesson15.helpers;//Определяет пакет, в котором находится файл

/*Блок импорта необходимых пакетов*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*Класс для управления модальными окнами
 * Реализован только для куки, может расширяться в дальнейшем*/
public class ModalWindow {

	public Coockie coockie;//Поле с внутренним классом для обработки модальных окон связанных с куки
	
	/*Конструктор класса
	 * В нем происходит инициализация необходимого внутреннего класса*/
	public ModalWindow() {
		coockie = new Coockie();
	}
	
	/*Внутренний класс для обработки модальных окон куки*/
	public class Coockie{
		
		/*Блок полей с тектом*/
		private final String acceptText = "Принять";
		private final String rejectedText = "Отклонить";
		
		/*Блок полей с навигацией по By*/
		private By acceptButton = By.xpath("//button[text()='" + acceptText + "']");
		private By rejectedButton = By.xpath("//button[text()='" + rejectedText + "']");
		
		private WebDriver driver;//Поле для получения сайта, на котором происходит поиск
		
		/*Метод принятия кук*/
		public void accept(WebDriver driver) {
			this.driver = driver;//Задаем сайт поиска
			action(acceptButton);//Передаем в метод действия нужную нам кнопку для поиска
		}
		
		/*Метод отклонения кук*/
		public void rejected(WebDriver driver) {
			this.driver = driver;//Задаем сайт поиска
			action(rejectedButton);//Передаем в метод действия нужную нам кнопку для поиска
		}
		
		public void action(By byXmlElement) {
			try {
	            // Попробуем найти кнопку "Принять" и нажать её
	            WebElement cookiesButton = driver.findElement(byXmlElement);
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
}
