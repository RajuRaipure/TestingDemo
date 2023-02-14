package TestCases;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Challenge2 
{
	public Response res;
	@BeforeTest
	public void baseurl()
	{
	RestAssured.baseURI  = "https://automationexercise.com";
	}
	@Test
	public void getCall()
	{
	res = given().contentType("application/json")  
	    .when()
	    .get("/api/productsList");
	 //String body = res.getBody().asString();
	 System.out.println(res.getBody().asString());
	 System.out.println(res.getStatusCode());
	 Assert.assertEquals(res.getStatusCode(), 200);
	 Assert.assertTrue(res.getStatusLine().contains("200 OK"));    
	}
	@Test
	public void verfiyResponseFirstNode()
	{
	JsonPath jsnPath = new JsonPath(res.asString());
	Assert.assertEquals("blue top", jsnPath.getString("products.name[0]"));

	}

}
