package api.testcases;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Payload.UserPayload;
import api.endPoints.UserEndpoint;

public class UserTest {
	UserPayload	upayload;
	Faker fake;
	public static Logger logger;

	@BeforeTest
	public void generateTestData() {

		upayload=new UserPayload();

		fake= new Faker();

		upayload.setId(fake.idNumber().hashCode()); 
		upayload.setFirstName(fake.name().firstName());
		upayload.setLastName(fake.name().lastName());
		upayload.setUsername(fake.name().username());
		upayload.setEmail(fake.internet().safeEmailAddress());
		upayload.setPassword(fake.internet().password());
		upayload.setPhone(fake.phoneNumber().phoneNumber());
		
		//obtain logger
		logger= LogManager.getLogger("PetStoreRestAssured");


	}


	@Test(priority=1)
	public void testCreateUser() {
		
		System.out.println("create user data ");

		UserEndpoint.createUser(upayload).then().log().all().statusCode(200);
		
		logger.info("Created user executed");
	}

	@Test(priority=2)
	public void testGetUserData() {
		
		System.out.println("get user data ");

		UserEndpoint.GetUser(upayload.getUsername()).
		then().log().all().statusCode(200);
		logger.info("get user executed");
	}
	
	@Test(priority=3)	
	public void testUpdateUser() {
		
		System.out.println("update user data ");

		upayload.setUsername(fake.name().firstName()); //this will update the username generated in @beforetest method 

		UserEndpoint.PutUser(upayload.getUsername(), upayload).then().log().all().statusCode(200);
		
		
		//read user data to check if first name is updated 
		
		UserEndpoint.GetUser(upayload.getUsername()).then().log().all().statusCode(200);
		logger.info("update user executed");
	}
	
	@Test(priority=4)
	public void deleteUser() {

		System.out.println("delete user data ");

		UserEndpoint.deleteUser(upayload.getUsername()).then().log().all().statusCode(200);
		logger.info("delete user executed");
	}

}
