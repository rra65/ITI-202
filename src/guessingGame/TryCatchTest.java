package guessingGame;

import java.util.Scanner;

public class TryCatchTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		while(true){
			try{
				int test = input.nextInt();
				printInt(test);
				break;
			}
			catch(Exception e){
				System.err.println("That wasn't an integer, try again");
				input.next();
			}
		}
		input.close();
	}

	private static void printInt(int x){
		System.out.println(x);
	}
}
