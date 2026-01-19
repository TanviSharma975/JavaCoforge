package Pac1;

import java.io.FileInputStream;
import java.io.IOException;

public class TC__IO {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
FileInputStream fis=new FileInputStream("C:\\Users\\Tanvi.1.Sharma\\Desktop\\sample.txt");
		
		int data;
		while((data=fis.read())!=-1)
		{
			System.out.print((char)data);
		}
		
		fis.close();
		
 
	}
 


}
