package Pac1;
class car{
	int noOfCylinders;
	int noOfValves;
	int enginePower;
	boolean isPowerSteering;
	car(){
		noOfCylinders=3;
		noOfValves=4;
		enginePower=46;
		isPowerSteering=false;
	}
	car(boolean isPowerStreering){
		this.isPowerSteering=isPowerSteering;
	}car(int enginePower,int noOfValves,int noOfCylinders){
		this.enginePower=enginePower;
		this.noOfValves=noOfValves;
		this.noOfCylinders=noOfCylinders;
	}
}
public class TC011_overloading {

	public static void main(String[] args) {
             car c=new car(true);
             System.out.println(c.isPowerSteering);
             
             
             car c2=new car();
             System.out.println(c2.noOfValves);
             
             car c3=new car(2,3,4);
             System.out.println(c3.noOfCylinders);
             

	}

}
