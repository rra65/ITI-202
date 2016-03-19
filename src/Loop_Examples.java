/* Please use these sample loops with comments as a guideline
 * for what is going inside various types of loops */

public class Loop_Examples {

	public static void main(String[] args) {
		// for loop
		for(int i = 0; i < 5; i++){
			/* What is this line saying?
			 * Create an integer called i and initialize it to 0
			 * i will be used as our counter
			 * 
			 * Next it is saying that this look will go on as long as i < 5
			 * 
			 * The last part is how the counter will change each iteration of the loop
			 * 
			 * i++ means that at the end of the loop i will go up by one, so after the 
			 * loop runs once i will equal 1
			 * */
			
			System.out.println("The i in my for loop is up to " + i);
			//look at the output...
			/* Why does it start with 0 and end with 4 if we put < 5? 
			 * Because once i reaches 5 --> i < 5 is no longer true 
			 * and the loop will not execute */
		}
		
		int some_counter = 5;
		
		//while loop
		while (some_counter < 5){
			System.out.println("some_counter in my while loop is up to " + some_counter);
			some_counter++;
		}
		/* Why didn't the loop run?
		 * 
		 * a while loop check the condition first, then runs the code
		 * what if we wanted to ensure the code would run?
		 * 
		 * We'd have to use a do while loop... */
		
		System.out.println("-------------------------------------------");
		
		//do while loop
		do{
			System.out.println("some_counter in my do while loop is up to " + some_counter);
		} while(some_counter < 5);
		/* Because the code executes before the condition is checked we know the code
		 * will execute at least once */
	}

}
