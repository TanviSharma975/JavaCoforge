package Pac1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employeee  implements Serializable{
	int empId;
	String empName;
	double salary;
	public Employeee(int i, String string, int j) {
		// TODO Auto-generated constructor stub
	}
	Employeee(int empId,String empName,double salary){
		this.empId=empId;
        this.empName=empName;
        this.salary=salary;
        
	}public String toString() {
		return "Employee ID"+empId+
				",Name"+empName+
				",Salary:"+salary;
	}
}
class EmployeeService1{
	void writeEmployee(Employeee emp) {
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("employee.txt"));
			oos.writeObject(emp);
			oos.close();
			System.out.println("Employee Data Written to file");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	void readEmployee() {
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("employee.txt"));
			Employee emp=(Employee)ois.readObject();
			ois.close();
			System.out.println("Employee Data read from file");
			System.out.println(emp);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

public class Lab2_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employeee emp=new Employeee(101,"Tanna",45000);
		EmployeeService1 service=new EmployeeService1();
		service.writeEmployee(emp);
		service.readEmployee();

	}

}
