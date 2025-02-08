import java.io.Console;
import java.util.Scanner;

public class LoginProcess {
    public static void main(String[] args) {
        // The correct username and password before 3 failed attempts
        String correctUsername = "Collince Korir";
        String correctPassword = "Korir@ZetechUni";
        
        Scanner scanner = new Scanner(System.in);
        Console console = System.console(); // Used for password masking(Print each character password as * while receiving it)
        
        int attempts = 3; // Maximum login attempts
        
        while (attempts > 0) {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            
            String password;
            if (console != null) {
                // Masking password input
                char[] passwordChars = console.readPassword("Enter Password: ");
                password = new String(passwordChars);
            } else {
                // If running in an environment where console is not available
                System.out.print("Enter Password: ");
                password = scanner.nextLine();
            }
            
            // Check if username and password match
            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Login Successful! Welcome, " + username + " \u1F60A");
                scanner.close();
                return; // Exit program after successful login
            } else {
                attempts--; // Reduce remaining attempts
                System.out.println("Incorrect username or password. Attempts left: " + attempts);
            }
        }
        
        System.out.println("Too many failed attempts. Access Denied. \u1F622");
        scanner.close();
    }
}
