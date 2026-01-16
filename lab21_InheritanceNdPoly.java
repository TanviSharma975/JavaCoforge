package Pac1;


 class Person1 {
	   private String name;
	   private float age;
	   public Person1(String name, float age) {
	       this.name = name;
	       this.age = age;
	   }
	   // Getters and Setters
	   public String getName() {
	       return name;
	   }
	   public void setName(String name) {
	       this.name = name;
	   }
	   public float getAge() {
	       return age;
	   }
	   public void setAge(float age) {
	       this.age = age;
	   }
	   @Override
	   public String toString() {
	       return "Person{name='" + name + "', age=" + age + "}";
	   }
	   public void deposit(int i) {
		// TODO Auto-generated method stub
		
	   }
	}
 
 
  class Account {
	   private static long accCounter = 1000; // auto generation
	   private long accNum;
	   private double balance;
	   private Person1 accHolder;
	   private static final double MIN_BALANCE = 500.0;
	   public Account(Person1 harshi, double balance) {
	       this.accNum = ++accCounter;
	       this.accHolder = harshi;
	       if (balance >= MIN_BALANCE) {
	           this.balance = balance;
	       } else {
	           this.balance = MIN_BALANCE;
	           System.out.println("Minimum balance applied for account " + accNum);
	       }
	   }
	   public void deposit(double amount) {
	       if (amount > 0) {
	           balance += amount;
	       }
	   }
	   public void withdraw(double amount) {
	       if (balance - amount >= MIN_BALANCE) {
	           balance -= amount;
	       } else {
	           System.out.println("Withdrawal denied. Minimum balance must be maintained.");
	       }
	   }
	   public double getBalance() {
	       return balance;
	   }
	   // Getters
	   public long getAccNum() {
	       return accNum;
	   }
	   public Person1 getAccHolder() {
	       return accHolder;
	   }
	   @Override
	   public String toString() {
	       return "Account{" +
	               "accNum=" + accNum +
	               ", balance=" + balance +
	               ", accHolder=" + accHolder +
	               '}';
	   }
	}

public class lab21_InheritanceNdPoly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person1 tanvi=new Person1("tanviii",20);
		Person1 harshi=new Person1("Harshiii",21);
		Account a1 = new Account(tanvi,2000);
		Account a2 = new Account(harshi,5000);
		tanvi.deposit(2000);
		harshi.deposit(4000);
		System.out.println(a1);
		System.out.println(a2);
		
		
		
		

	}

}
