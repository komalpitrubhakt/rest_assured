package day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class openWeatherAPI {
  @Test
  public void getWeather() {
	  
	  /*
	   * Given =precondition like content type,authentication
	   * when= user perform something
	   * then= expected outcome from system
	   * */
	  
	  RestAssured.given()
	             .when() 
	                .get("http://api.openweathermap.org/data/2.5/weather?q=Pune&appid=3bca6b8f84bf9a5f744e8d992e19d238")
	             .then()
	                .log()
	                .body()
	                .statusCode(200);
  }
  
  @Test(enabled=false, description="Getting weather API information Generally")
  public void getWeatherInfo2() {
	 Response res = RestAssured.given()
             .when() 
               .get("http://api.openweathermap.org/data/2.5/weather?q=Pune&appid=3bca6b8f84bf9a5f744e8d992e19d238");
			         
	System.out.println(res.prettyPrint());
	  System.out.println(res.getTime());
	  System.out.println(res.getStatusCode());
	  System.out.println(res.getContentType());
  }
  
  @Test(enabled=true, description="Getting weather API information Generally")
  public void getWeatherInfo3() {
	  
	  Map<String,String> param=new HashMap<String,String>();
	  param.put("q", "Pune");
	  param.put("appid", "3bca6b8f84bf9a5f744e8d992e19d238");
	  
	  
	  
	  
	 RestAssured.given()
			         //.queryParam("q","Mumbai")
			         //.queryParam("appid", "3bca6b8f84bf9a5f744e8d992e19d238")
	               .params(param)
			       .when()
			           .get("http://api.openweathermap.org/data/2.5/weather")
			       .then()
			          .log()
			          .body()
			          .statusCode(200);
  }
}
