package Restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;




public class Basics {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String Response =given().log().all().queryParam("key","quaclick123").header("Content-Type","application/json").body(Load.Data())
		.when().post("maps/api/place/add/json").then().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().response().asString();
		System.out.println(Response);
		
		JsonPath js = new JsonPath(Response);  //for json parsing
	String Placeid =js.get("place_id");
		System.out.println(Placeid);
		
		//Update place
		String newAddress = "Near Ram mandir, Mannur";
		 given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+Placeid+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200)
		.body("msg", equalTo ("Address successfully updated"));
		 
		 //Get Place
		 String getplaceresponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id",Placeid)
		 .when().get("maps/api/place/get/json").then().assertThat().statusCode(200).extract().response().asString();
		 
		 //This one or below one both are same
		 
		 JsonPath js1 = new JsonPath(getplaceresponse);
		String actualaddress = js1.get("address");
		System.out.println(actualaddress);
		Assert.assertEquals(actualaddress, newAddress);
		 
//		 JsonPath js1 = Reusablemethod.rawtojson(getplaceresponse);
//		 String actualaddress = js1.getString("address");
//		 System.out.println(actualaddress);
//		 Assert.assertEquals(actualaddress, newAddress);
		 
	}				 

}
