package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.playload.User;
import io.restassured.response.Response;

public class UserTests {
	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setupData(){
		faker = new Faker();
		userPayload = new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setPassword(faker.internet().password());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
	}

	
	@Test(priority=1)
   public void testPostUser() {
		Response res=UserEndpoints.createUser(userPayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	@Test(priority=2)
	public void testGetUserByName() {
		Response res=UserEndpoints.readUser(this.userPayload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		}
	@Test(priority=3)
	   public void testUpdateUser() {
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		Response res=UserEndpoints.updateUser(userPayload, this.userPayload.getUsername());
           res.then().log().all();
			Assert.assertEquals(res.getStatusCode(), 200);
			Response respostupdate=UserEndpoints.readUser(this.userPayload.getUsername());
			respostupdate.then().log().all();
			Assert.assertEquals(respostupdate.getStatusCode(), 200);
			
		}
	@Test(priority=4)
	   public void testDeleteUser() {
	   Response res=UserEndpoints.deleteUser(this.userPayload.getUsername());
        res.then().log().all();
			Assert.assertEquals(res.getStatusCode(), 200);
			
		}
}
