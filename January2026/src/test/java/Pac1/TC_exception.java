package Pac1;

public class TC_exception {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		try {
		String str=null;
		str.equals("hello");//error that's y it will not move forward
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Welcome");
		Thread.sleep(1000);
				

	}

}
