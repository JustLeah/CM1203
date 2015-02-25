import java.util.Scanner;

public class rsaEncrypt{

	public static void main(String args[]){
		//Get the values for p and q
		int p = Input.getInteger("Please enter the value for p : ");
		int q = Input.getInteger("Please enter the value for q : ");

		//Get the value for N by nultiplying p and q
		int n = makeN(p,q);
		//Ask the user for the value r
		int r = Input.makeR(p,q);
		//Ask the user for the message they wish to encrypt
		int m = Input.getInteger("Please enter the number you wish to encrypt : ");
		//Create the cipher text as a double incase we excede the 32 bit value
		double cipher = encryptM(m,r,n);

		System.out.println("Your encrypted message is : " + (int) cipher );

	}

	public static int makeN(int p, int q){
		return p*q;
	}

	public static double encryptM(int m, int r, int n){
		return (Math.pow(m , r)) % n;
	}

}

class Input{

	public static int getInteger(String message){
		Scanner input = new Scanner(System.in);
		System.out.println(message);
		int value = Integer.parseInt(input.next());
		return value;
	}

	public static int makeR(int p, int q){
		int maxNum = (p-1) * (q-1);
		Scanner input = new Scanner(System.in);
		System.out.println("Please a number that is relatively prime to " + maxNum + " : ");
		int value = Integer.parseInt(input.next());
		return value;
	}

}