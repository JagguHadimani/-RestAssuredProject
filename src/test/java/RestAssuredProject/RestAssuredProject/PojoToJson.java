package RestAssuredProject.RestAssuredProject;



import Files.pojoMakeSeleniumEasycom;
import io.restassured.internal.mapping.ObjectMapping;

public class PojoToJson {

	/*
	 * To convert any object of the above Pojo class to a JSON object, we need to
	 * perform the below steps:-
	 * 
	 * Create an object of POJO class. Set values of properties of Pojo class Create
	 * an object of ObjectMapper class provided by Jackson. Use overloaded
	 * writeXXXXXX() method as per need. I will convert POJO object to JSON string.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create object of Pojo and set values
		pojoMakeSeleniumEasycom person = new pojoMakeSeleniumEasycom();
        person.setName("Amod");
        person.setAge(30);
        // ObjectMapper class to serialize Pojo object to JSON
        ObjectMapping objectMapper = new ObjectMapping();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        System.out.println("Json Object is :-");
        System.out.println(json);

	}

}
