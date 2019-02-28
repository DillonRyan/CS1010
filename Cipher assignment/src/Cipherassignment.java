/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5: 5 - All variables were well named and in lower camel case

 2. Did I indent the code appropriately?

        Mark out of 5: 5 -code was indented as per coding standard

 3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20: 20 - function was wrote correcty

 4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20: 20 - the function was used correctly to encrypt the input

 5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:  15 - im not sure if the input was decrypted correctly but it did give a return

 6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?

       Mark out of 25 - 20 it repeatedly took a string and encrypted it but it would'nt decrypt it correctly  

 7. How well did I complete this self-assessment?

        Mark out of 5: 5 - completed it honestly

 Total Mark out of 100 (Add all the previous marks): 90

*/ 
import javax.swing.JOptionPane;

import java.util.Random;
import java.util.Scanner;

public class Cipherassignment {
	public static final char[] ALPHABET = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ' };

	public static void main(String[] args) {
		char[] cipher = createCipher();

		String input = JOptionPane.showInputDialog("please state weather youd like to encrypt, decrypt or exit");
		Scanner inputScanner = new Scanner(input);
		{
			if (inputScanner.hasNext("encrypt")) {
				startEncryption(inputScanner, cipher);
			} else if (inputScanner.hasNext("decrypt")) {
				startDecryption(inputScanner, cipher);
			} else if (inputScanner.hasNext("exit")) {
				JOptionPane.showMessageDialog(null, "Thank you, goodbye");
			} else {
				JOptionPane.showMessageDialog(null, "Invaild input, please enter in the correct format");
			}

		}

	}

	public static void startEncryption(Scanner scanner, char[] cipher) {
		boolean endOfEncryption = false;
		while (!endOfEncryption) {
			String input = JOptionPane
					.showInputDialog("Please enter the sentance in lower case that you would like to encrypt");
			 String lowercaseString = input.toLowerCase();
			char[] toBeEncrypted = input.toCharArray();
			char[] toBeDecrypted = input.toCharArray();
			JOptionPane.showMessageDialog(null, "The sentance " + input + " encrypted is "
					+ encrypt(toBeEncrypted, cipher) + " " + " then decrypted is " + decrypt(toBeDecrypted, cipher));
		}
	}

	public static void startDecryption(Scanner scanner, char[] cipher) {
		boolean finishedDecryption = false;
		while (!finishedDecryption) {
			String input = JOptionPane.showInputDialog("Please enter the sentance youd like to decrypt");
			 String lowercaseString = input.toLowerCase();
			char[] toBeDecrypted = input.toCharArray();
			JOptionPane.showMessageDialog(null,
					"The sentance " + input + " decrypted is " + decrypt(toBeDecrypted, cipher));
		}
	}

	public static char[] createCipher() {
		char[] ranAlpha = new char[ALPHABET.length];
		System.arraycopy(ALPHABET, 0, ranAlpha, 0, ALPHABET.length);
		Random generator = new Random();
		for (int index = 0; index < ranAlpha.length; index++) {
			int ranIndex = generator.nextInt(ranAlpha.length);
			char tmp = ranAlpha[index];
			ranAlpha[index] = ranAlpha[ranIndex];
			ranAlpha[ranIndex] = tmp;
		}
		return ranAlpha;
	}

	public static String encrypt(char[] plainTextPhrase, char[] cipher) {
		char encryptedArray[] = new char[(plainTextPhrase.length)];
		for (int encryptIndex = 0; plainTextPhrase.length > encryptIndex; encryptIndex++) {
			for (int alphaIndex = 0; ALPHABET.length > alphaIndex; alphaIndex++) {
				if (plainTextPhrase[encryptIndex] == ALPHABET[alphaIndex]) {
					encryptedArray[encryptIndex] = cipher[alphaIndex];
				}
			}
		}
		String encryptedSentance = new String(encryptedArray);
		return encryptedSentance;

	}

	public static String decrypt(char[] encryptedSentance, char[] cipher) {
		char decryptedArray[] = new char[(encryptedSentance.length)];
		for (int decIndex = 0; encryptedSentance.length > decIndex; decIndex++) {
			for (int cipIndex = 0; cipher.length > cipIndex; cipIndex++) {
				if (encryptedSentance[decIndex] == cipher[cipIndex]) {
					decryptedArray[decIndex] = ALPHABET[cipIndex];
				}
			}
		}
		String decryptedSentance = new String(decryptedArray);
		return decryptedSentance;
	}

}
