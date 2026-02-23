package RestAssuredProject.RestAssuredProject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.payload;
import Files.reusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
public class DynamicJson {
	
	@Test(dataProvider = "BooksData")
	public void addBook(String isbn, String aisle)
	{
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().header("Content-Type","application/json").
		body(payload.AddBook("isbn", "aisle")).
		when().post("Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).
		extract().response().asString();
		
		JsonPath js = reusableMethods.rawToJson(response);
		String id = js.get("ID");
		System.out.println(id);
		
		}
	
	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
		 return new Object[][] {{"vbnf", "2354"}, {"jksdh","9872"}, {"ghjs", "7687"}};
	}

}
