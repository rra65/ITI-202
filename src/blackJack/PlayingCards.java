
/*********************************************************************
  _____  _             _                _____              _     
 |  __ \| |           (_)              / ____|            | |    
 | |__) | | __ _ _   _ _ _ __   __ _  | |     __ _ _ __ __| |___ 
 |  ___/| |/ _` | | | | | '_ \ / _` | | |    / _` | '__/ _` / __|
 | |    | | (_| | |_| | | | | | (_| | | |___| (_| | | | (_| \__ \
 |_|    |_|\__,_|\__, |_|_| |_|\__, |  \_____\__,_|_|  \__,_|___/
                  __/ |         __/ |                            
                 |___/         |___/                             

A simple class of playing cards that can be used for any card game...
Here are the suit symbols if you need to copy and paste into another
class when you're creating a card deck:
♣ club
♠︎ space
♥︎︎ heart
♦ diamond
 Please direct any questions about this code to @author Arcadio 
 arodjr@rutgers.edu
 *********************************************************************/
package blackJack;

public class PlayingCards {
	//instance variables
	private String suit; //the suit of the card
	private int value; //the integer value of the card from 2-14... integers make comparisons easier
	
	//constructor
	public PlayingCards(String suit, int value){
		this.suit = suit;
		this.value = value;
	}
	
	//methods
	public int getValue(){
		return this.value;
	}
	//over rode the toString method to print the cards how I wanted
	public String toString(){
		if (value < 10 )return value + " of " + suit; //anything less than 10 can print like this
		else { //everything else is a unique case
			if(value == 10) return "10 of " + suit;
		 	if (value == 11) return "J of " + suit;
		 	else if (value == 12) return "Q of " + suit;
		 	else if (value == 13) return "K of " + suit;
		 	else return "A of " + suit;
		 }
	}
}