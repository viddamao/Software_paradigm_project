import java.util.Scanner;
public class CounterTest {
	
	public static void main (String[] args){
		
		Scanner reader = new Scanner(System.in);
		
		//The object that contains the counter that increase by 1 per second
        Counter counter= new Counter(); 
		
        //Run the counter method as a thread to detach it from the main(). Now main() can do whatever it wants to do.
		Thread countThread= new Thread(counter);
		countThread.start();
		
		while (true){
		
		int choice = reader.nextInt();
			
		if(choice==0){
				int count=counter.getCount();
				countThread.stop();
				System.out.println("\nThe counter is: " + count + " when you exit.");
			}
		}
				
	}

}
