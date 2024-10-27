package lesson17;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class PostmanRequestMethodsTest {

	private String baseURL = "https://postman-echo.com";
	
	@Test
	public void testGetRequest() {
		System.out.println("\nПроверка Get запроса");
		given()
			.log().all()
			.cookie("sails.sid=s%3Arkkk4dmbbbAPKE1LJDEVh_CE1lnGzBYE.w0Mk2D6Jjlv0QPcUlOSFTzpVrooJDylAA%2F%2F1d3ycPek")
			.when()
	            .get(baseURL + "/get")
	        .then()
	            .statusCode(200)
	            .assertThat()
	            .extract().response();
	}
	
	@Test
	public void testPostRawTextRequest() {
		System.out.println("\nПроверка Post запроса с телом");
		given()
			.log().all()
			.cookie("sails.sid=s%3Arkkk4dmbbbAPKE1LJDEVh_CE1lnGzBYE.w0Mk2D6Jjlv0QPcUlOSFTzpVrooJDylAA%2F%2F1d3ycPek")
			.contentType("application/json; charset=UTF-8")
	        .body("{\n    \"test\": \"Pup\"\n}")
		    .when()
		        .post(baseURL + "/post")
		    .then()
		    	.log().all()
		        .statusCode(200)
		        .assertThat()
		        .body("data.test", notNullValue())
		        .extract().response();
	}
	
	@Test
	public void testPostFormDataRequest() {
		System.out.println("\nПроверка Post запроса с формой");
		given()
			.log().all()
			.cookie("sails.sid=s%3Arkkk4dmbbbAPKE1LJDEVh_CE1lnGzBYE.w0Mk2D6Jjlv0QPcUlOSFTzpVrooJDylAA%2F%2F1d3ycPek")
			.contentType("application/x-www-form-urlencoded; charset=UTF-8")
		    .formParam("foo1", "bar1")
		    .formParam("foo2", "bar2")
		    .when()
		        .post(baseURL + "/post")
			.then()
				.log().all()
	        	.statusCode(200)
	        	.assertThat()
	            .body("form.foo1", equalTo("bar1"))
	            .body("form.foo2", equalTo("bar2"))
	            .extract().response();
	}
	
	@Test
	public void testPutRequest() {
		System.out.println("\nПроверка Put запроса");
		given()
			.log().all()
			.cookie("sails.sid=s%3Arkkk4dmbbbAPKE1LJDEVh_CE1lnGzBYE.w0Mk2D6Jjlv0QPcUlOSFTzpVrooJDylAA%2F%2F1d3ycPek")
			.contentType("text/plain; charset=UTF-8")
			.body("This is expected to be sent back as part of response body.")
			.when()
		        .put(baseURL + "/put")
			.then()
				.log().all()
	        	.statusCode(200)
	        	.assertThat()
	            .body("data", equalTo("This is expected to be sent back as part of response body."))
	            .extract().response();
	}
	
	@Test
	public void testPatchRequest() {
		System.out.println("\nПроверка Put запроса");
		given()
			.log().all()
			.cookie("sails.sid=s%3Arkkk4dmbbbAPKE1LJDEVh_CE1lnGzBYE.w0Mk2D6Jjlv0QPcUlOSFTzpVrooJDylAA%2F%2F1d3ycPek")
			.contentType("text/plain; charset=UTF-8")
			.body("This is expected to be sent back as part of response body.")
			.when()
		        .patch(baseURL + "/patch")
			.then()
				.log().all()
	        	.statusCode(200)
	        	.assertThat()
	            .body("data", equalTo("This is expected to be sent back as part of response body."))
	            .extract().response();
	}
	
	@Test
	public void testDeleteRequest() {
		System.out.println("\nПроверка Put запроса");
		given()
			.log().all()
			.cookie("sails.sid=s%3Arkkk4dmbbbAPKE1LJDEVh_CE1lnGzBYE.w0Mk2D6Jjlv0QPcUlOSFTzpVrooJDylAA%2F%2F1d3ycPek")
			.contentType("text/plain; charset=UTF-8")
			.body("This is expected to be sent back as part of response body.")
			.when()
		        .delete(baseURL + "/delete")
			.then()
				.log().all()
	        	.statusCode(200)
	        	.assertThat()
	            .body("data", equalTo("This is expected to be sent back as part of response body."))
	            .extract().response();
	}
}
