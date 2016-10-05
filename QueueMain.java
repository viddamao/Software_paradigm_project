import java.util.Scanner;

public class QueueMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choiceQ = 1;
		Scanner reader=new Scanner(System.in);
		System.out.println("Do you want to create a new queue? \r 1:yes \r 0:No ");	
    	choiceQ=reader.nextInt();
    	
    	int choiceNode=1;
		while ( choiceQ == 1){
			System.out.println("Create a new Node. Type in the string:");
			String str=reader.nextLine();
			System.out.println("Type in the priority:");
			int priority = reader.nextInt();
			
			MyNode node = new MyNode(str,priority);
			MyQueue queue1=new MyQueue(node);
			
			System.out.println("Do you want to add more nodes? \r 1:Yes \r 0:no");
			choiceNode=reader.nextInt();
			while(choiceNode == 1){
				System.out.println("Create a new Node. Type in the string:");
				str=reader.nextLine();
				System.out.println("Type in the priority:");
				priority = reader.nextInt();
				node=new MyNode(str,priority);
				queue1.enQueue(node);
			}
					
			System.out.println("Do you want to create a new queue? \r 1:Yes \r 0:No ");	
	    	choiceQ=reader.nextInt();
		}
		

	}

}
