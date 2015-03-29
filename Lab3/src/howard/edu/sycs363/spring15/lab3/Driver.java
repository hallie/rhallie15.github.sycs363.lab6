package howard.edu.sycs363.spring15.lab3;

public class Driver {

	public static IntegerArrayList alist;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		alist = new IntegerArrayList(10);
		alist.add(0,5);
		alist.add(10);
		alist.add(20);
		int value = alist.get(0);
		System.out.println( "Value of 0th element = " + value );
		alist.print();
		alist.add(1,72);
		alist.print();
	}

}
