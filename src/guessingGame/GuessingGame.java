package guessingGame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/* This will be a guessing game where the user has to properly 
 * guess a randomly generated number
 *  */

public class GuessingGame {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("How many people will be playing? ");
		int numPlayers = input.nextInt();
		playGame(numPlayers);
		input.close();
		System.out.println();
		System.out.println("Thanks for playing, see you again soon");
	}//end of main method

	public static void playGame(int players){
		ArrayList<Player> myPlayers= new ArrayList<Player>();
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		int lowest, highest;
		System.out.println();
		System.out.println("Give me a range of numbers for our guessing game");
		do{
			System.out.print("Enter the lowest number possible: ");
			lowest = input.nextInt();
			System.out.print("Enter the highest number possible: ");
			highest = input.nextInt();
			if(lowest == highest){
				System.out.println();
				System.out.println("Your highest and lowest can't be the same number");
				System.out.println();
			}
			else if(lowest > highest){
				System.out.println();
				System.out.println("Your lowest number must be lower than your highest number");
				System.out.println();
			}
			else break;
		} while(true);
		
		for(int i = 0; i < players; i++){
			myPlayers.add(new Player(rand.nextInt(highest-lowest+1) + lowest));
		}//end of loop that creates players
		System.out.println();
		int rounds = 1;
		
		while(allCorect(myPlayers)){
			System.out.println("Round " + rounds);
			for(int i = 0; i < myPlayers.size(); i++){
				//the following line will check to see if a guess is needed
				if(myPlayers.get(i).getIncorrect() == true){
					System.out.println();
					System.out.print("Player "+ (i+1) + " please enter your guess: ");
					int guess = input.nextInt();
					myPlayers.get(i).counterUp();
					//if a player guesses correctly
					if(guess == myPlayers.get(i).getAnswer()){
						System.out.println("That was correct!");
						myPlayers.get(i).setIncorrect(false);
					}//end of correct guess code
					
					//else they guessed wrong
					else{
						if(guess > myPlayers.get(i).getAnswer()) System.out.println("Too high");
						else System.out.println("Too low");
						myPlayers.get(i).setWrongGuesses(guess);
					}//end of else
				}//end of the check to see if a guess is needed
			}//end of the game round loop
			rounds++;
			System.out.println("-------------------------------------------");
			System.out.println();
		}//end of the game play loop
		
		for(int i = 0; i < myPlayers.size(); i++){
			if(myPlayers.get(i).getCounter() == 1){
				System.out.println("Player " + (i+1) + " took "+ myPlayers.get(i).getCounter() + " guess");
				System.out.println("Player " + (i+1) + " didn't guess wrong");
			}
			else{
				System.out.println("Player " + (i+1) + " took "+ myPlayers.get(i).getCounter() + " guesses");
				System.out.println("Player " + (i+1) + " was wrong with: "+ myPlayers.get(i).getWrongGuesses());
			}
			System.out.println();
		}
		
		System.out.print("Would you like to play again? 1 for yes, 2 for no " );
		int playAgain = input.nextInt();
		if(playAgain == 1){
			System.out.print("How many players? ");
			int newPlayers = input.nextInt();
			playGame(newPlayers);
		}
		input.close();
	}//end of playGame

	/* this method will check to see if all the players have answered correct
	 * the instance it discovers a player who has yet to guess correctly it 
	 * returns true...
	 * 
	 * this loop will allow me to know when to stop the loop in the playGame method*/
	public static boolean allCorect(ArrayList <Player> guesses){
		for(int i = 0; i < guesses.size(); i++){
			if(guesses.get(i).getIncorrect() == true) return true;
		}//end of loop that checks boolean values of players
		return false;
	}//end of all correct

}//end of Guessing Game
