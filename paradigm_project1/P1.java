package paradigm_project1;

public class P1 {
	private static void quicksort(int[] arr,int start,int end){
		int key = arr[start];  
		int i = start;    
		int j = end;  
		while (i < j) {  
			while (arr[j] >= key && i < j) {  
				j--;  
			}  
			arr[i] = arr[j];  
			while (arr[i] <= key && i < j) {  
				i++;  
			}  
			arr[j] = arr[i];  
		}  
		arr[i] = key;  
		if (i - 1 > start) {  
			quicksort(arr, start, i - 1);  
		}  
		if (i + 1 < end) {  
			quicksort(arr, i + 1, end);  
		}  
	}  


	public static void main(String args[]){
		int[] data =  new int[1000];
		for (int i = 0; i < data.length; i++) {  
			data[i] = (int) Math.round(Math.random()*10000);
		}  

		long startTime = System.nanoTime();
		quicksort(data,0,data.length - 1);
		long endTime = System.nanoTime();
		long time = endTime - startTime;
		
		for (int i = 0; i < data.length; i++) {  
			System.out.print(data[i] + " ");  
			if (i % 10 == 9){
				System.out.println();
			}
		}  

		System.out.println("========================================");
		System.out.println("Program P1");
		System.out.println("start time in ns:"+startTime);
		System.out.println("end time in ns:"+endTime);
		System.out.println("Elapsed time in ns:"+time);
	}
}

