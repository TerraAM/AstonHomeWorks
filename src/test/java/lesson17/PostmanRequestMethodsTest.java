package lesson17;//Определяет пакет, в котором находится файл

/*Подключение необходимых библиотек*/
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*Класс тестов запросов от PostMan echo*/
public class PostmanRequestMethodsTest {

	private String baseURL = "https://postman-echo.com";//Определение базового URL для API, с которым мы будем работать
	
	//Объявление теста проверки get запроса
	@DisplayName("Проверка Get запроса")
	@Test
	public void testGetRequest() {
	    //Используем метод given() для настройки начальных параметров запроса
	    given()
	        .log().all()//Логируем все детали запроса для отладки
	        .cookie("sails.sid=s%3Arkkk4dmbbbAPKE1LJDEVh_CE1lnGzBYE.w0Mk2D6Jjlv0QPcUlOSFTzpVrooJDylAA%2F%2F1d3ycPek")//Добавляем куку для сессии
	        .when()
	            .get(baseURL + "/get")//Выполняем get-запрос к указанному URL
	        .then()
	            .statusCode(200)//Проверяем, что статус ответа равен 200 (ОК)
	            .assertThat()//Указываем, что будем делать утверждения на основании ответа
	            .extract().response();//Извлекаем ответ для последующего анализа
	}

	//Объявление теста проверки post запроса
	@DisplayName("Проверка Post запроса")
	@Test
	public void testPostRawTextRequest() {
	    System.out.println("\nПроверка Post запроса с телом");
	    given()
	        .log().all()//Логируем все детали запроса
	        .cookie("sails.sid=s%3Arkkk4dmbbbAPKE1LJDEVh_CE1lnGzBYE.w0Mk2D6Jjlv0QPcUlOSFTzpVrooJDylAA%2F%2F1d3ycPek")//Добавляем куку для сессии
	        .contentType("application/json; charset=UTF-8")//Указываем тип содержимого как json
	        .body("{\n    \"test\": \"Pup\"\n}")//Устанавливаем тело запроса в формате json
	        .when()
	            .post(baseURL + "/post")//Выполняем post-запрос к указанному URL
	        .then()
	            .log().all()//Логируем детали ответа
	            .statusCode(200)//Проверяем, что статус ответа равен 200 (ОК)
	            .assertThat()//Указываем, что будем делать утверждения на основании ответа
	            .body("data.test", notNullValue())//Проверяем, что поле "test" не равно null
	            .extract().response();//Извлекаем ответ для последующего анализа
	}

	//Объявление теста для проверки post запроса с формой
	@Test
	public void testPostFormDataRequest() {
	    System.out.println("\nПроверка Post запроса с формой");
	    given()
	        .log().all()//Логируем все детали запроса
	        .cookie("sails.sid=s%3Arkkk4dmbbbAPKE1LJDEVh_CE1lnGzBYE.w0Mk2D6Jjlv0QPcUlOSFTzpVrooJDylAA%2F%2F1d3ycPek")//Добавляем куку для сессии
	        .contentType("application/x-www-form-urlencoded; charset=UTF-8")//Указываем тип содержимого как form-urlencoded
	        .formParam("foo1", "bar1")//Добавляем параметр формы "foo1"
	        .formParam("foo2", "bar2")//Добавляем параметр формы "foo2"
	        .when()
	            .post(baseURL + "/post")//Выполняем post-запрос к указанному URL
	        .then()
	            .log().all()//Логируем детали ответа
	            .statusCode(200)//Проверяем, что статус ответа равен 200 (ОК)
	            .assertThat()//Указываем, что будем делать утверждения на основании ответа
	            .body("form.foo1", equalTo("bar1"))//Проверяем, что значение "foo1" соответствует "bar1"
	            .body("form.foo2", equalTo("bar2"))//Проверяем, что значение "foo2" соответствует "bar2"
	            .extract().response();//Извлекаем ответ для последующего анализа
	}

	// Объявление теста для проверки put запроса
	@Test
	public void testPutRequest() {
	    System.out.println("\nПроверка Put запроса");
	    given()
	        .log().all()//Логируем все детали запроса
	        .cookie("sails.sid=s%3Arkkk4dmbbbAPKE1LJDEVh_CE1lnGzBYE.w0Mk2D6Jjlv0QPcUlOSFTzpVrooJDylAA%2F%2F1d3ycPek") // Добавляем куку для сессии
	        .contentType("text/plain; charset=UTF-8")//Указываем тип содержимого как текст
	        .body("This is expected to be sent back as part of response body.")//Устанавливаем тело запроса
	        .when()
	            .put(baseURL + "/put")//Выполняем put-запрос к указанному URL
	        .then()
	            .log().all()//Логируем детали ответа
	            .statusCode(200)//Проверяем, что статус ответа равен 200 (ОК)
	            .assertThat()//Указываем, что будем делать утверждения на основании ответа
	            .body("data", equalTo("This is expected to be sent back as part of response body."))//Проверяем, что возвращаемое поле "data" соответствует ожидаемому тексту
	            .extract().response();//Извлекаем ответ для последующего анализа
	}

	//Объявление теста для проверки patch запроса
	@Test
	public void testPatchRequest() {
	    System.out.println("\nПроверка Patch запроса");
	    given()
	        .log().all() //Логируем все детали запроса
	        .cookie("sails.sid=s%3Arkkk4dmbbbAPKE1LJDEVh_CE1lnGzBYE.w0Mk2D6Jjlv0QPcUlOSFTzpVrooJDylAA%2F%2F1d3ycPek")//Добавляем куку для сессии
	        .contentType("text/plain; charset=UTF-8")//Указываем тип содержимого как текст
	        .body("This is expected to be sent back as part of response body.")//Устанавливаем тело запроса
	        .when()
	            .patch(baseURL + "/patch")//Выполняем patch-запрос к указанному URL
	        .then()
	            .log().all()//Логируем детали ответа
	            .statusCode(200)//Проверяем, что статус ответа равен 200 (ОК)
	            .assertThat()//Указываем, что будем делать утверждения на основании ответа
	            .body("data", equalTo("This is expected to be sent back as part of response body."))//Проверяем, что возвращаемое поле "data" соответствует ожидаемому тексту
	            .extract().response();//Извлекаем ответ для последующего анализа
	}

	//Объявление теста для проверки delete запроса
	@Test
	public void testDeleteRequest() {
	    System.out.println("\nПроверка Delete запроса");
	    given()
	        .log().all()//Логируем все детали запроса
	        .cookie("sails.sid=s%3Arkkk4dmbbbAPKE1LJDEVh_CE1lnGzBYE.w0Mk2D6Jjlv0QPcUlOSFTzpVrooJDylAA%2F%2F1d3ycPek")//Добавляем куку для сессии
	        .contentType("text/plain; charset=UTF-8")//Указываем тип содержимого как текст
	        .body("This is expected to be sent back as part of response body.")//Устанавливаем тело запроса
	        .when()
	            .delete(baseURL + "/delete")//Выполняем delete-запрос к указанному URL
	        .then()
	            .log().all()//Логируем детали ответа
	            .statusCode(200)//Проверяем, что статус ответа равен 200 (ОК)
	            .assertThat()//Указываем, что будем делать утверждения на основании ответа
	            .body("data", equalTo("This is expected to be sent back as part of response body."))//Проверяем, что возвращаемое поле "data" соответствует ожидаемому тексту
	            .extract().response();//Извлекаем ответ для последующего анализа
	}
}
