package Pac1;

public class StaticModifiers {
      static int intNum1=3;
      static int intNum2;
      static {
    	  System.out.println("Static block initialized");
    	  int intNum2=intNum1*4;
      }
      static void myMethod(int intNum3) {
    	  System.out.println(intNum3);
    	  System.out.println(intNum2);
    	  System.out.println(intNum1);
    	  
      }
	public static void main(String[] args) {
		myMethod(42);
		

	}

}
