import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class HuffmanMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    	Scanner reader=new Scanner(System.in);
	    	System.out.println("Type in how many times you want to run random: ");	
	    	int inputNum=reader.nextInt();
	    	
	    	System.out.println("Type in the max value of the random numbers: ");
	    	int max=reader.nextInt();
	    	
	    	System.out.println("iteration for random generating: " + inputNum + "; Max value of random is: " + max);

	        // Create an int array to store the frequencies
	    	int[] charFreqs = new int[max+1];
	    	//Generating number of inputNum random numbers ranging from 0 to max
	        for (int i = 0; i < inputNum; i++){
	        	// Get a random number from 0 to max
	        	int rand=(int)(Math.random() * (max));
	        	charFreqs[rand]++;
	        }
	        
	        // Create a new list to store a series of symbols
	        ArrayList<Symbol> symbolList=new ArrayList<Symbol>();
	        
	        //  Create new symbols, and add them to the list
	        for ( int i=0; i<charFreqs.length; i++ ){
	        	if ( charFreqs[i] != 0){
	        		//Create a new symbol. i is the value and charFreqs[i] contains the frequency
	        		Symbol symbol=new Symbol( i, charFreqs[i],null,null);
	        		
	        		//Add the new symbol to the ArrayList
	        		symbolList.add(symbol);
	        	}
	        }
	            

	        // The main Huffman coding part begins here	        
	        long beginTime=System.nanoTime();

	        HuffmanCoding coding=new HuffmanCoding();
	        // Huffman encoding
	        coding.Encoding(symbolList);

	        // print out results
	        Iterator<Symbol> symbolIterator= symbolList.iterator();
	        System.out.println("SYMBOL\tWEIGHT\tHUFFMAN CODE");
	        while (symbolIterator.hasNext()){
	        	Symbol symbol=symbolIterator.next();
	        	System.out.println( symbol.value + "\t" + symbol.frequency + "\t" + symbol.huffmanCode );
	        }
	        
	        long endTime=System.nanoTime();
	        long timeElapse=endTime-beginTime;
	        
	        // Display time
	        System.out.println("Time used for Huffman Coding is: " + timeElapse);
	        
	        // The main Huffman coding part ends here
	        
	        // Total characters
	        int numOfChar = coding.countChar(charFreqs);
	        System.out.println("Total number of input characters: " + numOfChar);
	        
	        // Coding length with Huffman coding
	        int countHuff=coding.getHuffBits(); 
	        System.out.println("Total bits needed for Huffman coding: " + countHuff);
	        
	        // Coding length without Huffman coding
	        int bitsNoHuff = coding.bitsForNoHuff(numOfChar); 
	        System.out.println("Total bits needed without huffman coding: " + bitsNoHuff);
	 
	}

}
