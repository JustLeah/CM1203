import java.util.Scanner;

public class ClassTest{

	public static void main(String args[]){

		User user = new User();
		String username = user.GetUsername();
		System.out.println("Hello there " +  username);
		String usernameReverse = new StringBuilder(username).reverse().toString();
		System.out.println("The password is - " + usernameReverse);
		String password = user.Password();
		
		if(password.equals(usernameReverse)){
			System.out.println("Your password is correct");
		}
		else{
			System.out.println("Your password is wrong!");
		}
	}
}

class User{

	String GetUsername(){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your username: ");
		return (String) input.next();
	}

	String Password(){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your password: ");
		return (String) input.next();
	}
}