package inc.crimezero;

import java.util.ArrayList;

public class Keypad {
	private ArrayList<String> keys;
	private int[] reverseTable;

	public Keypad() {
		keys = new ArrayList<String>();
		reverseTable = new int[Character.MAX_VALUE];
		assignKey(0, "Zero");
		assignKey(1, "@.?");
		assignKey(2, "ABC");
		assignKey(3, "DEF");
		assignKey(4, "GHI");
		assignKey(5, "JKL");
		assignKey(6, "MNO");
		assignKey(7, "PQRS");
		assignKey(8, "TUV");
		assignKey(9, "WXYZ");
	}

	public void assignKey(int key, String value) {
		if (key < keys.size())
			keys.set(key, value);
		else {
			keys.add(value);
		}
		for (int index = 0; index < value.length(); index++)
			reverseTable[value.charAt(index)] = key;
	}

	public String getValue(int key) {
		if (key < keys.size())
			return keys.get(key);
		return null;
	}

	public int getKey(char value) {
		return reverseTable[value];
	}

	public void removeKey(int key) {
		String value = keys.get(key);
		for (int index = 0; index < value.length(); index++)
			reverseTable[value.charAt(index)] = 0;
		keys.remove(key);
	}
}