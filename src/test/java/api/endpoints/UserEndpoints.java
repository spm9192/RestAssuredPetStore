package api.endpoints;
import static io.restassured.RestAssured.given;

import api.playload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndpoints {
	
	public static Response createUser(User playLoad) {
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(playLoad)
		.when()
		 .post(Routes.post_url);
		return response;
		
	}
	
public static Response readUser(String userName) {
		Response response=given()
				.pathParam("username", userName)
				
		.when()
		 .get(Routes.get_url);
		return response;
		
	}
public static Response updateUser(User playLoad,String userName) {
	Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(playLoad)
			.pathParam("username", userName)
			
	.when()
	 .put(Routes.update_url);
	return response;
	
}

public static Response deleteUser(String userName) {
	Response response=given()
			.pathParam("username", userName)
			
	.when()
	 .delete(Routes.delete_url);
	return response;
	
}

}
