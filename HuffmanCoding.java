import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

class HuffmanNode implements Comparable<HuffmanNode> {
    public int frequency; // the frequency of this tree
    public int value; // Symbols
    public HuffmanNode left, right; // subtrees
    
    public HuffmanNode() {}
    
    public HuffmanNode(int freq, int val, HuffmanNode l, HuffmanNode r) { 
    	frequency = freq; 
    	value=val;
    	left = l;
        right = r;
    	}
 
    // compares on the frequency
    public int compareTo(HuffmanNode tree) {
        return frequency - tree.frequency;
    }
}


public class HuffmanCoding {
	
	public HuffmanCoding(){}
	
	public void Encoding(ArrayList<Symbol> symbolList){
		
		// Sort the symbols according to their frequencies and add the symbols to the priority queue
		PriorityQueue<Symbol> pSymbolQ = new PriorityQueue<Symbol>();
		Iterator<Symbol> symbolIterator=symbolList.iterator();
		while ( symbolIterator.hasNext()){
			pSymbolQ.offer(symbolIterator.next());		
		}
		
		// Build the tree
		assert pSymbolQ.size() > 0;
		while (pSymbolQ.size() > 1) {
	            // two trees with least frequency
	            Symbol a = pSymbolQ.poll(); // Left Child
	            Symbol b = pSymbolQ.poll(); // Right Child

	            // Put the combined node to the queue while maintain the order
	            // The value of the combined node is set to -1 to differ from the value in leaf nodes
	            pSymbolQ.offer(new Symbol(-1,a.frequency+b.frequency,a,b));
	    }
		
		getCode(pSymbolQ.poll(), new StringBuffer());
		
		
	}
	
	private int HuffBitsCount=0;
	public int getHuffBits(){
		return HuffBitsCount;
	}
	
	public void getCode (Symbol finalTree, StringBuffer prefix){
		
		assert finalTree != null;
		if (finalTree .left==null && finalTree.right==null) {

            // print out character, frequency, and code for this leaf (which is just the prefix)
            finalTree.setHuffCode(prefix);
            HuffBitsCount += prefix.length();
            
        } else{

            // traverse left
            prefix.append('0');
            getCode(finalTree.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            // traverse right
            prefix.append('1');
            getCode(finalTree.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
	}
	

    // Count the number of characters in the frequency array
    public int countChar(int[] charFreqs){
    	int numOfChar=0;
        for (int i = 0; i < charFreqs.length; i++ ){
        	if (charFreqs[i] != 0){
        		numOfChar++;
        	}
        }
        return numOfChar;
    }
    
    // Count the bits needed for coding without Huffman
    public int bitsForNoHuff(int numOfChar){
    	assert numOfChar > 1;
        
        int base = 2;
        int bits = 1; // To begin with, one character can be coded with one bit.
        for ( base = 2; base < numOfChar; base *= 2 ){    	       	
        		bits ++;
        }
        return bits * numOfChar;
    }
	

}
