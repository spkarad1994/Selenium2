package LibraryApi;

import io.restassured.RestAssured;
import static io.restassured.RestAssured .*;


public class Practice {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "http://216.10.245.166";
	    String Addbook =given().log().all().body("{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\"bcd\",\r\n"
				+ "\"aisle\":\"227\",\r\n"
				+ "\"author\":\"Shubham\"\r\n"
				+ "}").when().post("Library/Addbook.php").then().assertThat().extract().response().asString();
	    System.out.println(Addbook);

	}

}
