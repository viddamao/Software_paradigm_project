package paradigm_project1;

import java.util.Stack;

public class P2 {
	private static void quicksort(int[] arr){
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		s.push(arr.length-1);
		while (!s.isEmpty()){	
			int right = s.pop();
			int left = s.pop();
			if (right<=left){
				continue;
			}
			int i = partition(arr,left,right);
			s.push(left);
			s.push(i-1);

			s.push(i+1);
			s.push(right);
		}
	}

	private static int partition(int[] arr,int left,int right){
		int i = left,j = right,pivot = arr[left];
		while (i<j){
			for(;i<j && arr[j]>=pivot;j--); 
			arr[i] = arr[j];                    
			for(;i<j && arr[i]<=pivot;i++); 
			arr[j] = arr[i];     
		}
		arr[i] = pivot;
		return i;

	}

	public static void main(String args[]){
		int[] data =  new int[1000];
		for (int i = 0; i < data.length; i++) {  
			data[i] = (int) Math.round(Math.random()*10000);
		}  

		long startTime = System.nanoTime();
		quicksort(data);
		long endTime = System.nanoTime();
		long time = endTime - startTime;

		for (int i = 0; i < data.length; i++) {  
			System.out.print(data[i] + " ");  
			if (i % 10 == 9){
				System.out.println();
			}
		}  
		
		System.out.println("========================================");
		System.out.println("start time in ns:"+startTime);
		System.out.println("end time in ns:"+endTime);
		System.out.println("Elapsed time in ns:"+time);

	}
}
