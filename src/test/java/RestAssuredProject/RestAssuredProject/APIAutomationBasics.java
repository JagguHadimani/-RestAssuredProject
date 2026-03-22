package RestAssuredProject.RestAssuredProject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io. restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Files.payload;
import Files.reusableMethods;

public class APIAutomationBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("API Automation Basics -trying Git Bash");
		
		/* ***Validate if the Add Place API is working as expected** */
		
		//Given - the required inputs are provided to the API 
		// When - User calls the API with a http request {GET/POST/PUT/DELETE operations}
		// Then - Validate the response
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		System.out.println("API Test Started");
		String response = given().log().all() 
		.queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(payload.addPlace())
		.when().post("/maps/api/place/add/json") 
		.then().log().all()	//log().all() will log all the details of response 
		.assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		System.out.println(response);
		
		JsonPath js= new JsonPath(response); //for parsing Json
		String PlaceID = js.getString("place_id");
		System.out.println("PlaceID :" + PlaceID);
		
		/*    ****Update Place using the PUT API***  */
		String newAddress = "70 Winter Frost, USA";
		
		System.out.println("**********Updating Place************");
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+PlaceID+"\",\r\n"
				+ "\"address\":\"70 Winter Frost, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().put("/maps/api/place/update/json")
		.then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"))
		.extract().response().asString();
		System.out.println(response);
		//https://www.udemy.com/course/rest-api-automation-testing-rest-assured/learn/lecture/18167926#overview
		
		/*  *****Get Place API to validate if the address is updated  ******/
		
		
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", PlaceID)
		.when().get("/maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		
		JsonPath js1= reusableMethods.rawToJson(getPlaceResponse);
		String actualAddress = js1.getString("address");
		System.out.println("Actual Address :" + actualAddress);
		Assert.assertEquals(actualAddress,"70 Winter Frost, USA");
		
		
	}

}
