package api.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Payload.UserPayload;
import api.Utilities.DataProviders;
import api.endPoints.UserEndpoint;

public class UserTestDataDriven {
	UserPayload	upayload;
	
	
	@Test(priority=1,dataProvider="AllData", dataProviderClass= DataProviders.class)
	public void testCreateUser(String userid , String username , String firstname , String lastname,String email, String pwd, String phone) {
		upayload=new UserPayload();
		upayload.setId(Integer.parseInt(userid)); 
		upayload.setFirstName(firstname);
		upayload.setLastName(lastname);
		upayload.setUsername(username);
		upayload.setEmail(email);
		upayload.setPassword(pwd);
		upayload.setPhone(pwd);
		System.out.println("create user data ");

		UserEndpoint.createUser(upayload).then().log().all().statusCode(200);
	}
	
	@Test(priority=2,dataProvider="UserNamesData", dataProviderClass= DataProviders.class)
	public void deleteUser(String username ) {

		System.out.println("delete user data ");

		UserEndpoint.deleteUser(username).then().log().all().statusCode(200);
	}


}
