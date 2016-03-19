/*********************************************************************
 *   ____  _            _           _            _    
 *  |  _ \| |          | |         | |          | |   
 *  | |_) | | __ _  ___| | __      | | __ _  ___| | __
 *  |  _ <| |/ _` |/ __| |/ /  _   | |/ _` |/ __| |/ /
 *  | |_) | | (_| | (__|   <  | |__| | (_| | (__|   < 
 *  |____/|_|\__,_|\___|_|\_\  \____/ \__,_|\___|_|\_\
 *  
 *  This is an extremely simple game of black jack that only has one round
 *  and will automatically skip the player if he or she gets a "black jack"
 *  on the first turn...
 *  
 *  This isn't meant to be a refined game, just wanted to demonstrate a simple
 *  stack implemented into a card game
 *  
 *  Please direct any questions about this code to @author Arcadio
 *  arodjr@rutgers.edu
 *********************************************************************/
package blackJack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {

	public static void main(String[] args) {
		playGame();
	}

	//use this method to play the game
	public static void playGame(){
		ArrayList<PlayingCards> unshuffled_deck = new ArrayList<PlayingCards>();
		int value;//will hold the card value
		String suit;//will hold the card suit 
		int hand_value; //will hold the value of the current hand for the player
		int dealer_value; //will hold the value of the current hand for the dealer
		int ace; //keeps track of the player's aces to allow for use as 1 or 11
		int dealer_ace; //keeps track of the player's aces to allow for use as 1 or 11
		Scanner input = new Scanner(System.in); //used for user input
		System.out.println("Welcome to the Black Jack Table!!!");
		System.out.println("Dealer hits at 16 or lower, stands at 17...");
		System.out.println();

		for(int i = 0; i < 52; i++){//this for loop creates the deck
			value = i%13 + 2;
			if(i <= 0 && i <= 12) suit = "♣";
			if(i <= 13 && i <= 25) suit = "♠︎";
			if(i <= 26 && i <= 36) suit = "♥︎︎";
			else suit = "♦︎";
			unshuffled_deck.add(new PlayingCards(suit, value));
		}//end of the deck creation

		StackOfObjects deck = shuffle(unshuffled_deck);

		while(true){
			hand_value = 0;
			dealer_value = 0;
			ace = 0;
			dealer_ace = 0;
			try{
				//the player first
				System.out.println("The Player:");
				PlayingCards card1 = (PlayingCards) deck.pop();
				if(card1.getValue() < 10) hand_value += card1.getValue();
				else{
					if(card1.getValue() == 10 || card1.getValue() == 11 || card1.getValue() == 12 || card1.getValue() == 13) hand_value += 10;
					else{
						hand_value += 11; //the value needs 11 added on
						ace ++; //keep track of the aces so if the value goes over 21 and an A is in the hand, the value can be reduced
					}
				}
				PlayingCards card2 = (PlayingCards) deck.pop();
				if(card2.getValue() < 10) hand_value += card2.getValue();
				else{
					if(card2.getValue() == 10 || card2.getValue() == 11 || card2.getValue() == 12 || card2.getValue() == 13) hand_value += 10;
					else{
						hand_value += 11; //the value needs 11 added on
						ace ++; //keep track of the aces so if the value goes over 21 and an A is in the hand, the value can be reduced
					}
				}
				if(hand_value == 22){
					hand_value = 12;
					ace--; //remove an ace so that we know it was counted as 1;
				}
				System.out.println("Player's cards: " + card1 + " and " + card2);

				//then the dealer
				System.out.println();
				System.out.println("The Dealer: ");
				PlayingCards dealer1 = (PlayingCards) deck.pop();
				if(dealer1.getValue() < 10) dealer_value += dealer1.getValue();
				else{
					if(dealer1.getValue() == 10 || dealer1.getValue() == 11 || dealer1.getValue() == 12 || dealer1.getValue() == 13) dealer_value += 10;
					else{
						dealer_value += 11; //the value needs 11 added on
						dealer_ace ++; //keep track of the aces so if the value goes over 21 and an A is in the hand, the value can be reduced
					}
				}
				PlayingCards dealer2 = (PlayingCards) deck.pop();
				if(dealer2.getValue() < 10) dealer_value += dealer2.getValue();
				else{
					if(dealer2.getValue() == 10 || dealer2.getValue() == 11 || dealer2.getValue() == 12 || dealer2.getValue() == 13) dealer_value += 10;
					else{
						dealer_value += 11; //the value needs 11 added on
						dealer_ace ++; //keep track of the aces so if the value goes over 21 and an A is in the hand, the value can be reduced
					}
				}
				if(dealer_value == 22){
					dealer_value = 12;
					dealer_ace --; //remove an ace so that we know it was counted as 1;
				}
				System.out.println("The dealer is showing " + dealer1);
				System.out.println("-------------------------------------------------");
				System.out.println();

				//player's turn first...
				while(hand_value < 21){//the player's turn... the player can't hit anymore after 21
					System.out.println("Value of player's cards: " + hand_value);
					String next;
					while(true){
						try{
							System.out.print("Hit or stand? ");
							next = input.nextLine();
							if(next.equalsIgnoreCase("stand")) break; //player stands leave while loop
							else if(next.equalsIgnoreCase("hit")){//player says to hit
								card1 = (PlayingCards) deck.pop();
								System.out.println();
								System.out.println("The player was dealt a " + card1);
								if(card1.getValue() < 10) hand_value += card1.getValue();
								else{
									if(card1.getValue() == 10 || card1.getValue() == 11 || card1.getValue() == 12 || card1.getValue() == 13) hand_value += 10;
									else{
										hand_value += 11; //the value needs 11 added on
										ace ++; //keep track of the aces so if the value goes over 21 and an A is in the hand, the value can be reduced
									}
								}//end of else
								
								if(hand_value > 21){//did the player go over 21?
									if(ace > 0){//if so, do they have an ace?
										ace--; //lower the ace count
										hand_value -= 10; //lower the score by 10 to change the ace value from 11 to 1
									}
									else{
										System.out.println("Value of player's cards: " + hand_value);
										System.out.println("You busted, you lost!");
										return;
									}
								}//end of over 21 check
								System.out.println("Value of player's cards: " + hand_value);
							}//end of the hit command
							else{
								System.out.println("Please enter a valid option");
							}
						}
						catch(Exception e){
							System.out.println("Please enter a valid option");
						}
					}//end of nested while loop
					if(next.equalsIgnoreCase("stand")) break;
				}//end of the player's turn while loop

				//after the player the dealer...
				while(dealer_value < 17){//dealer's turn... dealer hits till 17
					dealer1 = (PlayingCards) deck.pop();
					if(dealer1.getValue() < 10) dealer_value += dealer1.getValue();
					else{
						if(dealer1.getValue() == 10 || dealer1.getValue() == 11 || dealer1.getValue() == 12 || dealer1.getValue() == 13) dealer_value += 10;
						else{
							dealer_value += 11; //the value needs 11 added on
							dealer_ace ++; //keep track of the aces so if the value goes over 21 and an A is in the hand, the value can be reduced
						}
					}
					if(dealer_value > 21){//did the dealer go over 21?
						if(dealer_ace > 0){//if yes does the dealer have an ace?
							dealer_ace --; //if they do, lower the ace counter by one
							dealer_value -= 10; //lower the score by 10 to count the ace as a 1 instead of 11
						}//end of ace check
						else{
							System.out.println("The dealer busted, you win!");
							return;
						}
					}//end of the over 21 check
				}//end of dealer's turn while loop
				break;
			}//end of try

			catch(Exception e){
				break;
			}//end of catch
		}//end of while loop
		System.out.println("");
		System.out.println("The dealer's score was " + dealer_value);
		if(dealer_value == hand_value) System.out.println("It was a tie");
		else if(dealer_value > hand_value && dealer_value <= 21) System.out.println("You lost");
		else System.out.println("You won");
		input.close();
	}//end of playGame()

	//shuffle the deck of cards
	public static StackOfObjects shuffle(ArrayList<PlayingCards> unshuffled){
		Random random = new Random(); //will be used for shuffling
		PlayingCards[] shuffled = new PlayingCards[52];
		for(int i = 0; i < 52; i++){//randomize order AKA shuffle
			int slot = random.nextInt(52-i); //create an integer slot that is equal to any index from 0 through 52-i
			shuffled[i] = unshuffled.get(slot); //set the i value of shuffled to slot
			unshuffled.remove(slot); //remove the index from the ArrayList so it isn't duplicated in the deck
		}//end of shuffle loop

		StackOfObjects deck = new StackOfObjects();
		for(int i = 51; i > 0; i--){
			deck.push(shuffled[i]);
		}
		return deck; //return back the shuffled deck
	}//end of shuffle
}//end of BlackJack