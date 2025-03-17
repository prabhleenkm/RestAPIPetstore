package api.endPoints;
import static io.restassured.RestAssured.*;

import api.Payload.UserPayload;
import api.Utilities.ConfigReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserEndpointUsingRoutesProp {
	
	
	public static Response createUser(UserPayload payload) {
		
	Response response= given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).
	when().post(ConfigReader.getProperty("post_url"));
		return response;
	}
	
	
	public static Response GetUser(String userName) { //here we have added pathparam as url has {}.
		
		Response response= 	 given().accept(ContentType.JSON).pathParam("username", userName).
		when().get(ConfigReader.getProperty("get_url"));
			return response;
		}
	
	
public static Response PutUser(String userName, UserPayload payload) { 
		
		Response response= 	 given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("username", userName).body(payload).
		when().put(ConfigReader.getProperty("put_url"));
			return response;
		}



public static Response deleteUser(String userName) { 
	
	Response response= 	 given().accept(ContentType.JSON).pathParam("username", userName).
	when().delete(ConfigReader.getProperty("delete_url"));
		return response;
	}
 

}
