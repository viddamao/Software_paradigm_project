
public class MyNode{
	private String str;
	private int priority;
	
	public void setPrioty(int priority){
		this.priority=priority;
	}
	public int getPriority(){
		return priority;
	}
	public String getStr(){
		return str;
	}
	
	public MyNode(){};
	public MyNode(String str, int priority){
		this.str=str;
		this.priority=priority;
	}
	
}