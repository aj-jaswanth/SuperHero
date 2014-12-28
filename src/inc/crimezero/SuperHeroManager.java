package inc.crimezero;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class that decodes the number into a superhero name
 * 
 * @author Venkata Jaswanth
 *
 */
public class SuperHeroManager {
	private ArrayList<String> superHeroesList;
	private Keypad keypad;
	private HashMap<String, String> hashTable;

	/**
	 * Constructor takes an array of names as initial list of SuperHeroes	
	 */
	public SuperHeroManager(String[] superHeroes) {
		keypad = new Keypad();
		hashTable = new HashMap<>();
		superHeroesList = new ArrayList<String>();
		for (String name : superHeroes)
			addSuperHero(name);
	}

	public void addSuperHero(String name) {
		superHeroesList.add(name);
		String encodededName = getEncodedNumber(name);
		hashTable.put(encodededName, name);
	}

	private String getEncodedNumber(String name) {
		StringBuffer encodedName = new StringBuffer();
		for (int x = 0; x < name.length(); x++) {
			encodedName.append(keypad.getKey(name.charAt(x)));
		}
		return encodedName.toString();
	}

	public boolean isValidSuperHeroName(String name) {
		return superHeroesList.contains(name);
	}

	public void removeSuperHero(String name) {
		superHeroesList.remove(name);
	}

	public String decodeDialedNumber(String dialedNumber) {
		String[] array = dialedNumber.split(" ");
		String encodedNumber = array[1];
		return hashTable.get(encodedNumber);
	}
}
