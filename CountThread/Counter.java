public class Counter implements Runnable{
	private int count=0;
	public void run(){

		try {
			while(true){
				count++;
				System.out.println("The counter now is: " + count);
			
				Thread.sleep(1000);
			} 
		}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	}
	
	public int getCount(){
		return count;
	}
	
	

}
