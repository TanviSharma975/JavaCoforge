package RestAPITesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getUser2{
  @Test
  public void getUser() {
	  RestAssured.baseURI="https://api.restful-api.dev/objects?id=3&id=5&id=10";
	  RestAssured.given().when()
			  .get("/objects")
			  .then()
			  .statusCode(404)
			 .log().all();
  }
}
