package RestAssuredProject.RestAssuredProject;

public class Message {

	private String message; 
	private String greet;
	
	public String getMessage()
	{
		return message;
	}
	
	public void setMessage(String message)
	{
		this.message=message;
	}
	
	public String getgreet() 
	{
		return greet;
	}
	
	public void setgreet(String greet)
	{
		this.greet=greet;
	}


/*
 *  In this example we are trying to serialize a json payload with 2 set of key value pair
 *  to do so we first declare two private variables. We can have more variables as per the need. 
 *  Then we create getter and setter method for each variable.
 */

	// Provide a small demonstration main method instead of top-level statements
	public static void main(String[] args) {
		Message m = new Message();
		m.setMessage("This is pojo class");
		m.setgreet("Hello");
		System.out.println("message = " + m.getMessage());
		System.out.println("greet = " + m.getgreet());
	}

}