package Pac1;
import java.util.Scanner;
//User Defined Exception
class InvalidAgeException extends Exception {
public InvalidAgeException(String message) {
    super(message);
}
}
public class AgeValidation {
// Method to validate age
static void validateAge(int age) throws InvalidAgeException {
    if (age <= 15) {
        throw new InvalidAgeException("Age must be above 15");
    }
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Age: ");
    int age = sc.nextInt();
    try {
        validateAge(age);
        System.out.println("Age is valid");
    } catch (InvalidAgeException e) {
        System.out.println("Exception Occurred: " + e.getMessage());
    }
    sc.close();
}
}