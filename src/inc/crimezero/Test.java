package inc.crimezero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		String dialedNumber;
		String[] superHeroesList = { "SUPERMAN", "THOR", "ROBIN", "IRONMAN",
				"GHOSTRIDER", "CAPTAINAMERICA", "FLASH", "WOLVERINE", "BATMAN",
				"HULK", "BLADE", "PHANTOM", "SPIDERMAN", "BLACKWIDOW",
				"HELLBOY", "PUNISHER" };
		SuperHeroManager superHeroManager = new SuperHeroManager(
				superHeroesList);
		while (!(dialedNumber = input.readLine()).equals("exit")) {
			String name = superHeroManager.decodeDialedNumber(dialedNumber);
			if (name != null)
				System.out.println(name);
			else
				System.out.println("Invalid number!");
		}
		input.close();
	}
}