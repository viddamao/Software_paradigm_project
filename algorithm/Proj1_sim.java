package algorithm;


public class Proj1_sim {
	public static void main(String args[]){
	long n = 5000000;
	float j = 2;
	
	long startTime = System.nanoTime();
	while (j < n) {
	 long k = 2;
	 while (k < n) {
	 k = k * k;
	 }
	 j += j/2;
	}

	long endTime = System.nanoTime();
	long time = endTime - startTime;
	System.out.println(time);
	
	}
}

