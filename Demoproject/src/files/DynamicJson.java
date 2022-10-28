package files;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {
	
	@Test
	public void Addbook() {
		
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().header("Content-Type","application/json").
		body(Payload.Addbook()).
		when()
		.post("/Library/Addbook.php").
		then().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js = ReusableMethods.rawToJson(response);
		js.get("ID");
		String id  = js.get("ID");
		System.out.println(id);
		
		
		
		
		
		}

}
