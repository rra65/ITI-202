import java.text.NumberFormat; //needed for line marked a
import java.util.Locale; //needed for line marked b

public class USD_Tester {

	public static void main(String[] args) {
		// double amount to change
		double amountToTest = 5.0;
		
		//easy way
		System.out.println("$" + String.format("%.2f", amountToTest));
		//calls the format method of the String class with two arguments:
		//the first is a the format
		//the second is the value to apply the format too

		// the more difficult way requires import statements, creating more variables, and more lines of code
		Locale defaultLocale = new Locale("en", "US", "USD"); //line b
		NumberFormat nf = NumberFormat.getCurrencyInstance(defaultLocale); //line a
		String formattedValue = nf.format(amountToTest);
		System.out.println(formattedValue);
	}

}
