package Parse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class parseFile {

	public static String COMMA_DELIMITER = ",";

	public static void main(String[] args) {

		List<List<String>> records = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("sample (3).csv"));) {
			while (scanner.hasNextLine()) {
				records.add(getRecordFromLine(scanner.nextLine()));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// skapa en lista för personer med a
		List<String> personsWithA = new ArrayList<String>();

		// loopa genom records och börja med 1 för att hoppa över första raden.
		for (int i = 1; i < records.size(); i++) {
			// loopa genom values inne i records
			List<String> localValues = records.get(i);

			// kolla kolumn 1/Name group member #1
			if (localValues.get(1).toLowerCase().contains("a")) {
				// adda personsWithA den personen
				personsWithA.add(localValues.get(1));
			}
			// kolla kolumn 2/Name group member #2
			if (localValues.get(2).toLowerCase().contains("a")) {
				// adda personsWithA den personen
				personsWithA.add(localValues.get(2));
			}

		}

		// print personsWithA
		for (String b : personsWithA) {
			// System.out.println(b);

		}
		System.out.println("there are : " + personsWithA.size() + " names with a in it");

		// List<String> android = new ArrayList<String>();

		// använder add för att räkna hur många som använder "android app"
		// men gångar det med 2 eftersom det är 2 namn i varje rad.

		int add = 0;

		for (int s = 1; s < records.size(); s++) {

			List<String> localValues = records.get(s);

			if (localValues.get(6).contains("Android App"))
				add++;
		}

		System.out.println(add * 2 + " people are using Android apps");

		// loopar igenom datan och gör en array för att samla data om hur många raden
		// som upprepar sig och sedan lägger in det i en variabel
		// använder size för o få ut antal.
		// och printar namnen med en ny int som är gjord i sista for loopen

		List<Integer> Data = new ArrayList<>();

		for (int t = 1; t < records.size(); t++) {

			List<String> TimeEqualsStamp = records.get(t);

			for (List<String> col : records) {
				int SameStamp = 0;
				if ((!col.equals(TimeEqualsStamp)) && (col.get(SameStamp).equals(TimeEqualsStamp.get(SameStamp)))) {

					Data.add(t);
				}

			}

		}

		System.out.println("There are " + Data.size() + " Groups with 2 people in each, who has the same timestample");

		for (int n : Data) {
			// printing out the names
			System.out.println(records.get(n));

		}

	}

	private static List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
		}

		return values;
	}

}
