package ie.ul.cs4227.Bass.Service.RentalCommand;
import java.util.Random;

public class Receiver {

	public void create() {
		Random num = new Random();
		int bill = num.nextInt(100);
		System.out.println("create " + bill);
	}
	public void finish(int billNum) {
		System.out.println("finish " + billNum);
	}
	public void modify(int billNum){
		System.out.println("modify " + billNum);
	}
	public void delete(int num) {
		System.out.println("No more " + num);
	}
	public void cancel(int num) {
		System.out.println("cancel" + num);
	}
	public void reject(int num) {
		System.out.println("reject" + num);
	}
	
}
