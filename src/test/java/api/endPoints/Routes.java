package api.endPoints;

public class Routes {
	
	
	/*post : https://petstore.swagger.io/v2/user
	 * Get : https://petstore.swagger.io/v2/user/user1
	 *put: https://petstore.swagger.io/v2/user/user1
      delete : https://petstore.swagger.io/v2/user/user1
	 */
	
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//user modules URL
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String put_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";

	
	//pet modules URL 

}
