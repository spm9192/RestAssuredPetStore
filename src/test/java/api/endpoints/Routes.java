package api.endpoints;

//createuser(post):https://petstore.swagger.io/v2/user
//get:https://petstore.swagger.io/v2/user/{username}
//update put:https://petstore.swagger.io/v2/user/{username}
//delete:https://petstore.swagger.io/v2/user/{username}
public class Routes {
	
public static String base_url ="https://petstore.swagger.io/v2" ;
public static String post_url = base_url+"/user" ;
public static String get_url = base_url+"/user/{username}" ;
public static String update_url = base_url+"/user/{username}" ;
public static String delete_url = base_url+"/user/{username}" ;
}
