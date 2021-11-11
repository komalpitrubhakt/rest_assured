package day1;

import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.*;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class GitHubExample {
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
}
