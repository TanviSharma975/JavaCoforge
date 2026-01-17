package Pac1;
import java.util.Scanner;
//User Defined Exception
class InvalidNameException extends Exception {
public InvalidNameException(String message) {
    super(message);
}
}
public class Lab_3_1 {
// Method to validate employee name
static void validateName(String firstName, String lastName)
        throws InvalidNameException {
    if (firstName == null || lastName == null ||
        firstName.trim().isEmpty() || lastName.trim().isEmpty()) {
        throw new InvalidNameException(
            "First Name and Last Name cannot be blank"
        );
    }
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter First Name: ");
    String firstName = sc.nextLine();
    System.out.print("Enter Last Name: ");
    String lastName = sc.nextLine();
    try {
        validateName(firstName, lastName);
        System.out.println("Employee Name is valid");
        System.out.println("Full Name: " + firstName + " " + lastName);
    } catch (InvalidNameException e) {
        System.out.println("Exception Occurred: " + e.getMessage());
    }
    sc.close();
}
}
