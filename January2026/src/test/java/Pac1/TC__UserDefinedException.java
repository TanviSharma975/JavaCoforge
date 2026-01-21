package Pac1;

import java.util.Scanner;

class AgeException extends Exception{
	private int age;
	AgeException(int a){
		this.age=a;
	}public String toString() {
		return age+"is an invalid age";
	}
}
class emp{
	String name;
	int age;
	void getEmpDetails() throws AgeException {
		System.out.println("Enter your name:");
		Scanner sc=new Scanner(System.in);
		name=sc.next();
		System.out.println("Enter age:");
		age=sc.nextInt();
		if(age<16) {
			throw new AgeException(age);
		}
	}
}

public class TC__UserDefinedException {

	public static void main(String[] args) throws AgeException {
		// TODO Auto-generated method stub
		emp e=new emp();
		e.getEmpDetails();
		

	}

}
