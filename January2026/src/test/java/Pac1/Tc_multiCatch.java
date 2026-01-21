package Pac1;

public class Tc_multiCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try {
	
	
		String str="Hello";
		int a=str.length();
		int b=42/a;
		int c[]= {1};
		c[42]=99;
	}catch(ArithmeticException e) {
		System.out.println(e.getMessage());
	}catch(ArrayIndexOutOfBoundsException e) {
		System.out.println("ArrayIndexOutofBound"+e.getMessage());;
	}finally {
		System.out.println("Executed successfully");
	}
	}

}
