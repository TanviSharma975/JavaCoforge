package Pac1;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class lab9 {
	
	public static String removeDuplicates(String s) {
		StringBuilder ss=new StringBuilder();
		Set<Character> set = new HashSet<>();
		
		for(char ch : s.toCharArray()) {
			if(!set.contains(ch)) {
				ss.append(s.charAt(ch));
				set.add(ch);
			}
			return ss.toString();
		}
		
//		boolean[] seen=new boolean[256];
//		
//		
//		for(int i=0;i<s.length();i++) {
//			char ch=s.charAt(i);
//			if(!seen[ch]) {
//				seen[ch]=true;
//				ss.append(ch);
//				
//				
//			}
//		}return ss.toString();
		return s;
	}
	public static String changeOdd(String s) {
		StringBuilder sb=new StringBuilder();
		char[] arr=s.toCharArray();
		for(int i=1;i<s.length();i++) {
			if(i%2!=0) {
				sb.append(Character.toUpperCase(s.charAt(i)));
				
			}else {
				sb.append(s.charAt(i));
			}
		}return sb.toString();
	}
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		String a=sc.nextLine();
		System.out.println(a.concat(a));
//		char[] b=a.toCharArray();
		for(int i=1;i<a.length();i++) {
			if(i%2!=0) {
				sb.append("#");
				
			}else {
				sb.append(a.charAt(i));
			}
		}
		System.out.println(sb.toString());
		System.out.println(removeDuplicates(a));
//        System.out.println(removeDuplicates("Tannna"));
		System.out.println(changeOdd("Tanna"));
		
		
	}

}
