/* SELF ASSESSMENT 
   1. createSequence:
Did I use the correct method definition?
Mark out of 5:5
Comment: correct method definition used
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5:5
Comment: yes was used
Did I return the correct item?
Mark out of 5: 5
Comment: right returned 
   2. crossOutMultiples
Did I use the correct method definition?
Mark out of 5:5
Comment: yes was correct
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2: 1
Comment: made sure it wasnt null, didnt know how to make sure it was valid
Did I loop through the array using the correct multiple?
Mark out of 5: 5
Comment: the correct array was used
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3: 3
Comment: yes they were crossed out
   3. sieve   
Did I have the correct function definition?
Mark out of 5: 5
Comment: was correct
Did I make calls to other methods?
Mark out of 5: 5
Comment:     yes i did
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2: 2
Comment: yes i did
   4. sequenceTostring  
Did I have the correct function definition?
Mark out of 5: 5
Comment: it was correct
Did I ensure the parameter to be used is not null?
Mark out of 3: 3 
Comment: made sure it wasnt null
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10: 10
Comment:    updated it correctly
   5. nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5: 5
Comment:       yes i did
Did I ensure the parameter to be used is not null?  
Mark out of 3:3
Comment: made sure it wasnt null
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5: 5
Comment: yes i did
   6. main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5: 5
Comments: yes and i handled invalid input correctly
Did I make calls to other methods (at least one)?
Mark out of 5: 5
Comment:  yes i called
Did I print the output as shown in the question?  
Mark out of 5: 5
Comment:  printed as shown in question
   7. Overall
Is my code indented correctly?
Mark out of 4: 4
Comments: indented correctly
Do my variable names make sense?
Mark out of 4: 4
Comments: they were all good
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4: 4
Comments: yes they d0
      Total Mark out of 100 (Add all the previous marks): 99
*/

import java.util.Scanner;

public class siveofE {
	public static final int START_NUMBER = 2;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter int >=2 : ");
		if (input.hasNextInt()) {
			int rangeOfNumbers = input.nextInt();
			int[] sequence = new int[rangeOfNumbers + 1];
			if (rangeOfNumbers < START_NUMBER) {
				System.out.println("Input invalid, enter a positive whole number greater than or equal to 2");
			} else {
				int[] sievedSequence = sieve(rangeOfNumbers, sequence);
				String printSeq = notCrossedOutSubSeqToString(sievedSequence);
				System.out.println(printSeq);

			}
		}

	}

	public static int[] createSequence(int rangeOfNumbers, int[] sequence) {
		for (int i = START_NUMBER; i <= rangeOfNumbers; i++) {
			sequence[i] = START_NUMBER + i;
		}
		return sequence;
	}

	public static String sequenceToString(int[] sequenceOfNumbers) {
		String sequence = "";
		if (sequenceOfNumbers != null) {
			boolean firstStringNumber = true;
			for (int i = 0; i <= sequenceOfNumbers.length - 1; i++) {
				int n = sequenceOfNumbers[i];
				if (sequenceOfNumbers[i] != 0) {
					if (firstStringNumber) {
						sequence += i;
						firstStringNumber = false;
					} else if (n > 0) {
						sequence += ", " + i;
					} else {
						sequence += ", [" + i + "]";
					}
				}
			}
		}

		return sequence;
	}

	public static int[] crossOutHigherMultiples(int[] sequenceOfNumbers, int n) {
		if (sequenceOfNumbers != null) {
			for (int i = n; n * i <= sequenceOfNumbers.length - 1; i++) {
				if (sequenceOfNumbers[n * i] > 0)
					sequenceOfNumbers[n * i] *= -1;
			}
		}
		return sequenceOfNumbers;
	}

	public static String notCrossedOutSubSeqToString(int[] sequenceOfNumbers) {
		String sequence = "";
		if (sequenceOfNumbers != null) {
			boolean firstStringNumber = true;
			if (sequenceOfNumbers != null) {

				for (int i = 0; i <= sequenceOfNumbers.length - 1; i++) {
					int number = sequenceOfNumbers[i];
					if (sequenceOfNumbers[i] != 0)
						if (firstStringNumber) {
							sequence += i;
							firstStringNumber = false;
						} else if (number > 0) {
							sequence += ", " + i;
						}
				}
			}
		}
		return sequence;
	}

	public static int[] sieve(int rangeOfNumbers, int[] sequence) {
		int[] sequenceOfNumbers = createSequence(rangeOfNumbers, sequence);
		String printSequenceOfNumbers = sequenceToString(sequenceOfNumbers);
		System.out.println(printSequenceOfNumbers);
		for (int number = 2; number * number <= rangeOfNumbers; number++) {
			if (sequenceOfNumbers[number] > 0) {
				sequenceOfNumbers = crossOutHigherMultiples(sequenceOfNumbers, number);
				printSequenceOfNumbers = sequenceToString(sequenceOfNumbers);
				System.out.println(printSequenceOfNumbers);
			}
		}
		return sequenceOfNumbers;
	}
}