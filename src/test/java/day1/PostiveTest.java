package day1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PostiveTest {
	
	String _id;
  @Test(enabled=true, description="For getting all contact list")
  public void getAllContactList() {
	  
	  given()
	  .when()
	    .get("http://3.13.86.142:3000/contacts/")
	  .then()
	     .log()
	     .body()
	     .statusCode(200);
	  
	  
  }
  
  @Test(enabled=true, description="Adding contact")
  public void  addContact() {
	  JSONObject loc= new JSONObject();
	  loc.put("city", "Pune");
	  loc.put("country", "India");
	  
	  JSONObject emp= new JSONObject();
	  emp.put("jobTitle", "Automation tester");
	  emp.put("company", "LTI");
	  
	  JSONObject ob= new JSONObject();
	  ob.put("firstName", "Mayank");
	  ob.put("lastName", "Sharma");
	  ob.put("email", "asmith@thinkingtester.com");
	  ob.put("location", loc);
	  ob.put("employer", emp);
	  
	  _id =given()
			  .header("Content-Type", "application/json")
			  .body(ob.toJSONString())
			.when()
			   .post("http://3.13.86.142:3000/contacts/")
			.then()
			  .log()
			  .body()
			  .statusCode(200)
			  .extract()
			  .jsonPath()
			  .get("_id");
	 System.out.println("ID is " +_id);
  }
  
  @Test(enabled=true, dependsOnMethods="addContact",description="Getting specific contact")
  public void getSpecificContact() {
	  
	  given()
	  .when()
	    .get("http://3.13.86.142:3000/contacts/"+_id)
	  .then()
	     .log()
	     .body()
	     .statusCode(200);
	  
	  
  }
 
  @Test(enabled=true, dependsOnMethods="addContact",description="Updating The contacts")
  public void  UpdateContact() {
	  JSONObject loc= new JSONObject();
	  loc.put("city", "Pune");
	  loc.put("country", "India");
	  
	  JSONObject emp= new JSONObject();
	  emp.put("jobTitle", "Automation tester");
	  emp.put("company", "LTI");
	  
	  JSONObject ob= new JSONObject();
	  ob.put("firstName", "Mayank");
	  ob.put("lastName", "Sharma");
	  ob.put("email", "asmith@thinkingtester.com");
	  ob.put("location", loc);
	  ob.put("employer", emp);
	  
	 given()
	    .header("Content-Type", "application/json")
	    .body(ob.toJSONString())
			.when()
			   .put("http://3.13.86.142:3000/contacts/"+_id)
			.then()
			  .log()
			  .body()
			  .statusCode(204);
	  
  }
  
  @Test(enabled=true, dependsOnMethods="UpdateContact",description="Deleting specific contact")
  public void deleteSpecificContact() {
	  
	  given()
	  .when()
	    .delete("http://3.13.86.142:3000/contacts/"+_id)
	  .then()
	     .log()
	     .body()
	     .statusCode(204);
	  
	  
  }
}
