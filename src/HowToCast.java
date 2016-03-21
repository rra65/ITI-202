
public class HowToCast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object [] test = new Object[5];
		for(int i = 0; i < test.length; i++){
			test [i] = true;
		}
		test[0] = 1;
		boolean getBoolean = test[1];
	}

}
