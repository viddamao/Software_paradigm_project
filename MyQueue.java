import java.util.ArrayList;
import java.util.Iterator;


public class MyQueue {
	
	private ArrayList<MyNode> queueRef;
	
	public MyQueue(){}
	public MyQueue(MyNode node){
		
		queueRef=new ArrayList<MyNode>();
	}
	
	public void enQueue(MyNode node){
		queueRef.add(node);
	}
	
	public MyNode deQueue(){
		Iterator<MyNode> qIterator=queueRef.iterator();		
		MyNode nodePoll;
		MyNode resultNode = new MyNode();
		resultNode.setPrioty(0);
		
		while ( qIterator.hasNext() ){
			nodePoll=qIterator.next();
			if ( nodePoll.getPriority() > resultNode.getPriority() )
				resultNode=nodePoll;
		}
		queueRef.remove(resultNode);
		return resultNode;
	}
	
	public boolean equals(MyQueue queue1, MyQueue queue2){
		Iterator<MyNode> qIterator1=queue1.queueRef.iterator();
		Iterator<MyNode> qIterator2=queue2.queueRef.iterator();
		MyNode node1;
		MyNode node2;
		if (queue1.queueRef.size() != queue2.queueRef.size() )
			return false;
		else{
			while ( qIterator1.hasNext()){
				node1=qIterator1.next();
				node2=qIterator2.next();
				if ( node1.getStr() != node2.getStr() || node1.getPriority() != node2.getPriority())
					return false;
			}
			return true;
		}	
	
	}
	
	public MyQueue clone(MyQueue originalQ){
		MyQueue clonedQ=new MyQueue();
		clonedQ.queueRef=originalQ.queueRef;
		return clonedQ;
		
	}
	
	public void toString(MyQueue queue){
		Iterator<MyNode> qIterator=queue.queueRef.iterator();
		MyNode node = new MyNode();
		while ( qIterator.hasNext()){
			node=qIterator.next();
			System.out.println("node: " + node.getStr() + ", priority: " + node.getPriority());
			
		}
		
	}
	
	public void hashCode(MyQueue queue){
		Iterator<MyNode> qIterator=queue.queueRef.iterator();
		MyNode node=new MyNode();
		while(qIterator.hasNext()){
			node=qIterator.next();
			System.out.println("node: " + node.getStr() + ", Hash Code: " + node.hashCode());
		}
	}
	

}
