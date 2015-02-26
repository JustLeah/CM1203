import java.util.*;
import java.math.*;

public class competition{
	public static void main(String args[]){
		BigInteger minInt = new BigInteger("100000000000");
		BigInteger maxInt = new BigInteger("999999999999");
		BigInteger n = new BigInteger("3134841810700227510209105263606832495831555076672951753523150165560653643538098908946545209139778837553176058762250765563411200247062055969556490970308625438880473881130090800619792477333778727792348085360833042968473325864522196464928790203850407009928412252565703016843414136064726507672002788981895874238388916618960287789549204508020939250620524771710827980049653102158848069597416351904591070177");
		//Just testing to see the function works
		Functions.findPrimes(minInt, maxInt);
		System.out.print("DONE");
	}
}

class Functions{
	//Create a vector which stores all of the prime numbers between the specified range
	//Printing out eachone for debugging 
	public static Vector findPrimes(BigInteger min, BigInteger max){
		Vector<BigInteger> allPrimes = new Vector<>();
		while(min.compareTo(max) == -1){
			BigInteger thisPrime = min.nextProbablePrime();
			System.out.println(thisPrime);
			allPrimes.add(thisPrime);
			min = thisPrime;
		}
		return allPrimes; 
	}
	
	//This function finds a rough sqrt of a big integer
	//Currently not using it but it would be used at a later point
	public static BigInteger sqrt(BigInteger x) {
	    BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
	    BigInteger div2 = div;
	    // Loop until we hit the same value twice in a row, or wind
	    // up alternating.
	    for(;;) {
	        BigInteger y = div.add(x.divide(div)).shiftRight(1);
	        if (y.equals(div) || y.equals(div2))
	            return y;
	        div2 = div;
	        div = y;
	    }
	}
}