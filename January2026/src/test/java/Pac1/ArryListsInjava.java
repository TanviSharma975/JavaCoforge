package Pac1;
import java.util.ArrayList;

public class ArryListsInjava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer>arr=new ArrayList<Integer>();
		arr.add(0,new Integer(43));
		int total=arr.get(0).intValue();
		System.out.println(total);
		
		ArrayList<String>l1=new ArrayList<String>();
		String str="hi";
		l1.add(str);
		l1.add("Welcome");
		System.out.println(l1.size());
		System.out.println(l1);
		for(String l2:l1) {
			System.out.println(l2);
		}

	}

}
