package Pac1;

class Balance 
	{
		String name;
		double bal;
		public Balance (String n,double b)
		{
			name=n;
			bal=b;
		}
		public void show() {
			if(bal>0) {
				System.out.println(bal);
			}
		}
	}

public class TC005_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Balance obj = new Balance(" Rajat", 5768764.00);
		obj.show();

	}

}
