import java.util.Scanner;

public class HowToCast {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Object [] test = new Object[5];
		for(int i = 0; i < test.length; i++){
			test [i] = true;
		}
		test[1] = 1;
		// this line would cause an issue boolean getBoolean = test[1];
		//should read like this:
		boolean getBoolean = (boolean) test[0];
		//a comparison that uses casting
		if(getBoolean == (boolean) test[0]) System.out.println("They are both true!!!");
		System.out.println("Enter a guess: ");
		int guess = input.nextInt();
		//still need to cast
		//why?
		//because our array is filled with Objects NOT integers...
		if(guess == (int) test[1]) System.out.println("They match!!!");
		else System.out.println("WRONG!!");
		input.close();
	}

}
