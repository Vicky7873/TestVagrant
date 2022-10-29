package TestVagrant.TestVagrant;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class codingAssignment {
	
	String res;
	JsonPath js;
	@BeforeClass
	public void setup() {
		RestAssured.baseURI="";
		res=given().when().get().then().extract().response().asPrettyString();
		js=new JsonPath(res);
	}
	
	@Test(priority = 0)
	public void findThe4fp() {
		String fp=js.getString("player.country");
		String[] a=fp.split(",");
		for (String string : a) {
			if(string!="India") {
				System.out.println(string);
			}
		}

}
	
	@Test(priority = 1)
	public void GetTheWicketKeeper() {
		String fn=js.getString("player.role");
		String s="";
		for(int i=0;i<fn.length();i++) {
			s=s+fn.charAt(i);
			if(s.contains("Wicket-keeper")) {
				System.out.println(s);
				break;
			}
		}
		}
	

}
