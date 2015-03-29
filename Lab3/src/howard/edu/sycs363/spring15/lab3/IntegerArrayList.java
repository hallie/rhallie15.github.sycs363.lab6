package howard.edu.sycs363.spring15.lab3;

public class IntegerArrayList {

	public int len = 0;
	public int[] list;
	
	//If the user passes a specified length.
	public IntegerArrayList(int length) {
		list = new int[length];
	}
	//If the user doesn't pass a specified length.
	public IntegerArrayList() {
		list = new int[100];
	}
	
	//Adds to the end of the array list
	public void add(int addition) {
		if (len < list.length) {
			if (len == 0) {
				list[0] = addition;
			}
			else {
				list[len] = addition;
			}
			len++;
		}
	}
	//Insert an integer value at the specified index
	public void add(int index, int value) {
		if (index <= list.length) {
			list[index] = value;
		}
		if (index == len) {
			len++;
		}
	}
	//Return the integer value at the specified index
	public int get(int index) {
		if (list.length >= index+1) {
			return list[index];
		}
		return -1;
	}
	//Return the index of the specified value in the list/array.  Return -1 if not present.
	public int indexOf(int value) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] == value) {
				return i;
			}
		}
		return -1;
	}
	//Return true if the list/array is empty, else false
	public boolean isEmpty() {
		if (len == 0) {
			return true;
		}
		return false;
	}
	//Removes and returns an item at a given index
	public int remove(int index) {
		int item = list[index];
		for(int i = index; i < (list.length - 1); i++) {
			list[i] = list[i+1];
		}
		return item;
	}
	//Returns the length of the list
	public int getLen() {
		return len;
	}
	
	public void print() {
		for (int i = 0; i < len; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
}
