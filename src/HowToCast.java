
public class HowToCast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object [] test = new Object[5];
		for(int i = 0; i < test.length; i++){
			test [i] = true;
		}
		test[0] = 1;
		// this line would cause an issue boolean getBoolean = test[1];
		//should read like this:
		boolean getBoolean = (boolean) test[1];
		//a comparison that uses casting
		if(getBoolean == (boolean) test[1]) System.out.println("They are both true!!!");
	}

}
