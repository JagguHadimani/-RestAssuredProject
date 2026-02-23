package RestAssuredProject.RestAssuredProject;

import io.restassured.path.json.JsonPath;
import Files.payload;

import org.testng.annotations.Test;

public class SumValidation {
	@Test 
	public static void sumofCourses()
	{
		JsonPath js = new JsonPath(payload.CoursePrice());
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		for (int i = 0; i < count; i++) {
			

			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			int amount = js.getInt("Courses["+i+"].amount");
					
		}		
					
					
					
	}

}
