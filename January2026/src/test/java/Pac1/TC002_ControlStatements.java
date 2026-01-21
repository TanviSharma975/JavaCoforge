package Pac1;

public class TC002_ControlStatements {
	 public int num=20000;
	public static void main(String[] args) {
		int marks = 70;
		if (marks%2==0 ) {
			System.out.println("Even marks");
		}
		else {
			System.out.println("odd no.");
		}	
		if (marks >= 80) {
			System.out.println("Grade A");}
		else if( marks >= 60 & marks < 80) {
			System.out.println("Grade B");
		}else {
			System.out.println( "Grade c");
		}
		int day=3;
		switch(day) {
		
		case 1:
			System.out.println("Monday");
			break;
		case 2 :
			System.out.println("Tuesday");
			break;
			
		case 3:
			System.out.println("Wednesday");
			break;
					
			}
				
				
			for(int i=1; i<=5;i++)
				{
					System.out.println(i);
				}
				
			int j=1;
			while(j<=2)
				{
					System.out.println(j);
					j++;
				}
				
			int k=1;
			do
				{
					System.out.println(k);
					k++;
				}while(k<=5);
				
							
			
		}

}
