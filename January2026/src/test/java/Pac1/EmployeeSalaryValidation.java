package Pac1;

import java.util.Scanner;
//User Defined Exception
class EmployeeException extends Exception {
public EmployeeException(String message) {
    super(message);
}
}
public class EmployeeSalaryValidation {
// Method to check salary
static void checkSalary(double salary) throws EmployeeException {
    if (salary < 3000) {
        throw new EmployeeException("Salary is below 3000");
    }
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Employee Salary: ");
    double salary = sc.nextDouble();
    try {
        checkSalary(salary);
        System.out.println("Salary is valid");
    } catch (EmployeeException e) {
        System.out.println("Exception Occurred: " + e.getMessage());
    }
    sc.close();
}
}