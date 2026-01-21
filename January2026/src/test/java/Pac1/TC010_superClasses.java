package Pac1;
class Base{
	public void baseMethod() {
		System.out.println("Base Method");
	}
}
class Derived extends Base{
	public static void derivedMethod() {
		System.out.println("Derived Method");
	}
}

public class TC010_superClasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Derived d=new Derived();
		System.out.println(d instanceof Derived);
		d.baseMethod();
		d.derivedMethod();
		
		
		

	}

}
