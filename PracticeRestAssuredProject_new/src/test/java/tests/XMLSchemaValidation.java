package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class XMLSchemaValidation {
	
	
	
	@Test
	public void SchemaValidation() throws IOException {
		
		File file= new File("./AddNewXML.xml");
		FileInputStream File=new FileInputStream(file);
		 String Request=org.apache.commons.io.IOUtils.toString(File,"utf-8");
		
		
		
		 RestAssured.baseURI="https://ecs.syr.edu/faculty/fawcett/Handouts/cse775/code/calcWebService";
		 RestAssured.given().contentType("text/xml").accept(ContentType.XML).
		 body(Request).when().post("/Calc.asmx").then().statusCode(200).log().all();
		

		
	}
	
}
