package day1;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class GitHub2 {
	@Test(enabled=true, description="Getting all Repositories")
	public void getAllRepo() {
		  
		  given()
		  .auth()
		  .oauth2("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")
		  .when()
		     .get("https://api.github.com/user/repos")
		  .then()
		    .log()
		    .body()
		    .statusCode(200)
		    .time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);
		  
	  }
	@Test(enabled=true, description="Adding Repositories")
  public void addRepository() {
	  JSONObject js=new JSONObject();
	  js.put("name", "tsl968-restAssured2");
	  js.put("description", "I am created by RestAssured");
	  js.put("homepage", "https://github.com/komalpitrubhakt");
	  
	  
	  given()
	  .auth()
	  .oauth2("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")
	  .header("Content-Type", "application/json")
	  .body(js.toJSONString())
	  .when()
	     .post("https://api.github.com/user/repos")
	  .then()
	    .log()
	    .body()
	    .statusCode(201)
	    .time(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS);
  }
}
