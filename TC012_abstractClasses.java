package Pac1;
abstract class shape{
	abstract void draw();
}
class rectangle extends shape{
	void draw() {
		System.out.println("Drawing the Rectangle");
	}
	
}

public class TC012_abstractClasses {
	public static void main(String[]args) {
		rectangle r=new rectangle();
		r.draw();
	}
	

}
