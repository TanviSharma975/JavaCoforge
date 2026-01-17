package Pac1;

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		int arr[];
		arr=new int[10];
		int a[]= {1,2,3};
		int twoDim[][]=new int[4][5];
		int[] numbers= {90,20,10,40,50};
		System.out.println(Arrays.sort(numbers));
		System.out.println(numbers[1]);
		System.out.println(numbers.length);
		for(int i=0;i<numbers.length;i++) {
			System.out.println(numbers[i]);
		}
		
		
		int[] num2=new int[5];
		num2[0]=100;
		
		int[][] matrix= {{1,2,3},{4,5,6}};
		System.out.println(matrix[1][2]);
		
		

	}

	private static char[] sort(int[] numbers) {
		// TODO Auto-generated method stub
		return null;
	}

}
