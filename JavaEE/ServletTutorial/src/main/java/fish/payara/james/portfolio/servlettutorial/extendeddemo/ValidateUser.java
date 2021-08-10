package fish.payara.james.portfolio.servlettutorial.extendeddemo;

/**
 * A simple Java class which takes the entered username and password, checks it against static values and returns
 * true or false, depending if they are valid.
 */
public class ValidateUser {

	public static boolean validateUser(String username, String password) {
		if((username.equals("James") || username.equals("Josh") || username.equals("James1")) && password.equals("Password")){
			return true;
		}
		return false;
	}
}
