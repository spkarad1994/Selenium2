package files;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
	//Print total courses	
		JsonPath js = new JsonPath(Payload.CourseStats());
	int count = js.getInt("courses.size()");
	System.out.println(count);
	
	int totalAmount =js.getInt("dashboard.purchaseAmount");
	System.out.println(totalAmount);
	
	//print title of first course
	String Firsttitle = js.get("courses.title[0]");
	System.out.println(Firsttitle);
	
	//Print All course titles and their respective Price
	
	for (int i=0; i<count; i++) {
	String coursetitle =( js.get("courses["+i+"].title"));
	System.out.println(coursetitle);
	int courseprices =( js.get("courses["+i+"].price"));
	System.out.println(courseprices);
	
	}
	//print no of copies sold by RPA Course
	
	System.out.println("No.of copies sold by cypress Course");
	
	for (int i=0; i<count; i++) {
		String coursetitle =( js.get("courses["+i+"].title"));
		if(coursetitle.equalsIgnoreCase("cypress")) {
			
		int copies =js.get("courses["+i+"].copies");
		System.out.println(copies);
		break;
		}
		
	
	
	}
	
	}

}
