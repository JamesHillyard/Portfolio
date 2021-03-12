package extendedDemo;

/**
 * A simple class to check if the username ends with a number, if it does the user is an admin
 */
public class IsAdmin {
    public static boolean checkAdmin(String username) {
        if (username.matches(".*\\d")) {
            return true;
        }
        return false;
    }
}
