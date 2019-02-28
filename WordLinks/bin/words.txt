
/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment: had correct method definition
- My method reads the words from the "words.txt" file. [Mark out of 5:5]
- Comment: it read the correct file
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment: it returns an array list

2. readWordList
- I have the correct method definition [Mark out of 5: 5]
- Comment: it had the correct method definition
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment: Seperated it by commas and saved them appropiately as an array

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment: it is the correct method definition
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment: it compares all the words in the array with the rest in the list
- Exits the loop when a non-unique word is found. [Mark out of 5:5]
- Comment: it exits if a non unique word is found
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment: It returns true or false depending if theyre unique or not

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: yes it was correct
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment: used the binary search
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: it returned it correctly

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: has correct method definition
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: it loops through correctly to compare all the characters in the same position

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment: I have the correct method definition
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment: it calls them all and then prints the appropiate message in the main

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10:8]
- Comment:i used the scanner function to import the file
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: It correctly asks the user for input and calls the isWordChain

 Total Mark out of 100 (Add all the previous marks):98
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.binarySearch;

import java.io.File;
import java.io.FileReader;

public class WordLinks {

	public static void main(String[] args) {
		String[] arrayOfWords = readDictionary();

		boolean exit = false;
		Scanner userInput;
		while (!exit) {
			System.out.println("Enter each word seperated by a comma, if you want to exit hit enter");
			userInput = new Scanner(System.in);

			String input = userInput.hasNextLine() ? userInput.nextLine() : "";
			if (!input.isEmpty()) {

				String[] wordChain = readWordList(input);
				if (isWordChain(wordChain, arrayOfWords)) {
					System.out.println("This is a valid word ladder");
				} else {
					System.out.println("This is not a valid word ladder");
				}
			} else if (input.isEmpty()) {
				exit = true;
				System.out.println("Goodbye.");

			} else {
				System.out.println("Invalid Input. Try again.");
			}
		}
	}

	public static String[] readDictionary() {
		try {
			Scanner scanner = new Scanner(new File("words.txt"));
			List<String> arrayListOfWordText = new ArrayList<String>();
			while (scanner.hasNext()) {
				arrayListOfWordText.add(scanner.next());
			}
			String[] arrayOfWords = arrayListOfWordText.toArray(new String[658964]);
			return arrayOfWords;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public static String[] readWordList(String userInput) {
		{
			String[] output = userInput.split(",");
			return output;
		}
	}

	public static boolean isEnglishWord(String word, String[] arrayOfWords) {
		int dictionary = binarySearch(arrayOfWords, word);
		if (dictionary > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isUniqueList(String[] wordChain) {

		if (wordChain != null) {
			boolean isUnique = true;
			for (int i = 0; i < wordChain.length - 1; i++) {
				for (int x = i + 1; x < wordChain.length; x++) {
					isUnique = !wordChain[i].equals(wordChain[x]);
					if (isUnique == false)
						return false;
				}
			}
			return isUnique;
		}
		return false;
	}

	public static boolean isDifferentByOne(String word1, String word2) {
		char[] first = word1.toLowerCase().toCharArray();
		char[] second = word2.toLowerCase().toCharArray();
		if (first.length != second.length)
			return false;
		int count = 0;
		for (int i = 0; i < first.length; i++) {
			if (first[i] != second[i]) {
				count++;
			}
		}
		if (count == 1)
			return true;
		return false;
	}

	public static boolean isWordChain(String[] wordChain, String[] arrayOfWords) {
		if (isUniqueList(wordChain)) {
			boolean isAnEnglish = true;
			for (int index = 0; index < wordChain.length; index++) {
				isAnEnglish = isEnglishWord(wordChain[index], arrayOfWords);
				if (isAnEnglish == false)
					return false;
			}
			boolean differenceByOne = true;
			for (int index = 0; index < wordChain.length - 1; index++) {
				differenceByOne = isDifferentByOne(wordChain[index], wordChain[index + 1]);
				if (!differenceByOne)
					return false;
			}
			return true;
		}

		return false;
	}
}
