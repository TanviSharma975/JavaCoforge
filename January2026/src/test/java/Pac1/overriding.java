package Pac1;
class animal{
	void sound() {
		System.out.println("Animal makes a sound");
	}
}
	class cat  extends animal{
		@Override
		void sound() {
			System.out.println("cat makes a sound");
		}
	
	}

public class overriding {
	public static void main (String[]args) {
	cat a=new cat();
	a.sound();
	

}
}