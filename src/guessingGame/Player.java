package guessingGame;

/* This is a Player object class that will be used for a guessing number game
 * 
 * incorrect will be used determine if the player answered correctly, it 
 * defaults to false because till a player guesses they can't be correct
 * 
 * answer will store the randomly generated number
 * 
 * wrongGuesses will hold all the values the player has guessed incorrectly
 * 
 * counter will start at zero and increment up by one each time a player guesses
 * */

public class Player {
	//instance variables
	private boolean incorrect;
	private int answer;
	private String wrongGuesses;
	private int counter;
	
	//Constructors
	public Player(int answer){
		this.incorrect = true;
		this.answer = answer;
		this.wrongGuesses = "";
		this.counter = 0;
	}
	
	//setters
	public void setIncorrect(boolean incorrect){
		this.incorrect = incorrect;
	}//end of setIncorrect
	
	public void setAnswer(int answer){
		this.answer = answer;
	}//end of setAnswer
	
	public void setWrongGuesses(int wrongGuess){
		this.wrongGuesses += wrongGuess + " ";
	}//end of setWrongGuess
	
	public void counterUp(){
		this.counter++;
	}//end of counterUp
	/* end of setters */
	
	//getters
	public boolean getIncorrect(){
		return this.incorrect;
	}//end of getIncorrect
	
	public int getAnswer(){
		return this.answer;
	}//end of getAnswer
	
	public String getWrongGuesses(){
		return this.wrongGuesses;
	}//end of getWrongGuesses
	
	public int getCounter(){
		return this.counter;
	}//end of getCounter()
}
