public class Symbol implements Comparable<Symbol> {
	public int frequency; // the frequency of this tree
    public int value; // Symbols
    public Symbol left, right; // subtrees
    public String huffmanCode=null;
    
    public Symbol() {}
    
    public Symbol( int val, int freq, Symbol l, Symbol r) { 
    	frequency = freq; 
    	value=val;
    	left = l;
        right = r;
    }
    
    public void setHuffCode(StringBuffer huffCode){
    	this.huffmanCode=huffCode.toString();
    }
 
    // compares on the frequency
    public int compareTo(Symbol symbol) {
        return frequency - symbol.frequency;
    }
}
