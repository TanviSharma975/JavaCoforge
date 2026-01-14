package Pac1;

import java.util.Scanner;

public class Lab10 {

public static boolean isLexicographicallySorted(String s) {
    if (s == null || s.length() <= 1) return true;
    for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) < s.charAt(i - 1)) {
            return false;
        }
    }
    return true;
}

	public static void main(String[]args) {
		System.out.println(isLexicographicallySorted("ddabcde"));
		
		
	}

}
