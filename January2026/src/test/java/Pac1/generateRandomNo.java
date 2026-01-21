

package Pac1;

import java.util.Random;

class account{
	public static String generateAcc() {
		long time=System.currentTimeMillis();
		int random=new Random().nextInt(900)+100;
		return time+""+random;
	}
}

public class generateRandomNo {
	public static void main(String[]args) {
	account obj=new account();
	System.out.println(obj.generateAcc());
	

}
}
