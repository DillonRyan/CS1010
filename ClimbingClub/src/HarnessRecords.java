
/* SELF ASSESSMENT

Harness Class: Member variables (8 marks) 
All my data members are declared, private and the ones that don't change are marked as private. I also have a constant for the maximum number of uses of a harness.
Comment: 8 - All data members are declared and are correct. There is also a max constant for the harnesses

Harness Class: Harness constructor 1 & constructor 2 (6 marks)
I initialise all the variables using the parameters given and set the other members to reasonable default values.
Comment: 6 - All variables were initialized and are reasonable default values

Harness Class: checkHarness method (5 marks)
My method takes an instructor's name as a parameter, and if the harness is not on loan sets the instructor member variable to the given parameter value (assuming the instructor's name is not null/empty). It also resets the number of times the harness was used.
Comment:5 - Takes the name as a parameter and if not on loan it sets the value once its not null. It also resets the harness value.

Harness Class: isHarnessOnLoan method (2 marks)
My method has no parameters and returns the value of the loan status variable.
Comment:2 - has no parameters and the status is a boolean

Harness Class: canHarnessBeLoaned method (4 marks)
My method has no parameters and returns true if the harness is not on loan and if the number of times it was used is less than the maximum allowed number of times.
Comment: 4- checks if the harness is on loan and if its number of times is less than the max amount of times it can be used

Harness Class: loanHarness method (6 marks)
My method has a member name as a parameter and it checks if harness can be loaned by using the canHarnessBeLoaned method. If true, it sets the club member value to the parameter value, sets the on loan status to true and increments the number of times used variable.
Comment:6- tkaes a string member as a parameter and checks the two methods (canHarnessBeLoaned && isHarnessOnLoan) it also sets the status and increments the timesUsed variable
 
Harness Class: returnHarness method (5 marks)
My method has no parameters, checks if the harness is on loan, and if so, changes its on-loan status to false, and resets the club member value.
Comment:5 - has no parameters and checks if it is on loan. resets the club member value

Harness Class: toString method (3 marks)
My method returns a String representation of all the member variables.
Comment: 0 - Was unable to return a String of the member variables

HarnessRecords Class: member variables (3 marks)
I declare the member variable as a private collection of Harnesses 
Comment:3 - member variable is a private collection of Harnesses - arrayList

HarnessRecords Class: HarnessRecords constructor 1 & 2 (9 marks)
In the first constructor, I set the member variable to null [1 mark]. In the second constructor, I use the Java I/O to read data from a text file I created containing sets of Harness characteristics. I use these set of characteristics to create Harness objects and add them to the collection. 
Comment:1- set the member variable to null

HarnessRecords Class: isEmpty method (1 marks)
I return true if the collection is null/empty and, false otherwise.
Comment:1- returns true if the collection is null or empty or if not then its set to false

HarnessRecords Class: addHarness method (5 marks)
My method takes a Harness object as a parameter and adds the harness to the collection.
Comment:5- takes a harness (harness1) as an object as a parameter and adds it to the collection

HarnessRecords Class: findHarness method (6 marks)
My method takes a make and model number as parameters. It checks if a harness with such properties exists and if it does it returns harness object, otherwise returns null.
Comment:6 - takes a make and model as parameters. it checks if it exists and if it does it return harness else returns null

HarnessRecords Class: checkHarness method (6 marks)
must take instructor name, make and model number as parameters and return a Harness. If a harness with the make and model number exists by using the findHarness method and is not on loan, the Harness method checkHarness is called with the instructor name as a parameter and the updated Harness object is returned. If the harness is not available returns null.
Comment: 6 - Takes an instructor, a make and a modelNumber as parameters, if the harness is empty then it returns null. it is then updated Harness object is returned

HarnessRecords Class: loanHarness method (7 marks)
My method takes a club member name as a parameter and looks for an available harness by calling the method canHarnessBeLoaned be loaned. If an available harness is found it is loaned by using the Harness method loanHarness with the club member as a parameter, returning the harness. If there's no available harness null is returned.
Comment: 7 - takes a clubMember as a parameter and looks for available harness calling the method isHarnessOnLoan. if it is found iti is loaned. if no available harness is found then null is returned

HarnessRecords Class: returnHarness method (7 marks)
My method takes a make and model number as parameters. It checks if a harness with those properties exists by using the findHarness method. If the found harness is not null, it returns the harness object by using Harness method returnHarness, otherwise returns null.
Comment: 7 - takes a make and model number as parameters. it then uses the findHarness method. if the found harness is not null it returns the harness object else will return null

HarnessRecords Class: removeHarness method (8 marks)
My method takes a make and model number as parameters and check the collection for a harness with those properties and removes it. It returns the harness object if it is found, otherwise returns null.
Comment: 8 - takes a make and modelNumber as parameter and then checks the collection for a harness with the same properties and removes it. it returns the harness object if it is found else returns null

GUI (Java main line) (5 marks)
My test class has a menu which implements at least the five points specified using the HarnessRecords class methods.
Comment: 0 - I was unable to make a suitable GUI
Total grade - 80/100
 */
import java.util.ArrayList;

public class HarnessRecords {

	public ArrayList<Harness> harnesses;

	public HarnessRecords() {
		harnesses = new ArrayList<Harness>();
	}

	public HarnessRecords(int numHarnesses, String[] make, String[] modelNumber, int[] timesUsed, String[] instructor,
			boolean[] onLoan, String[] clubMember) {
		for (int i = 0; i < numHarnesses; i++) {
			Harness tmp = new Harness(make[i], modelNumber[i], instructor[i]);
			harnesses.add(tmp);
			clubMember = null;
		}
	}

	public boolean isEmpty() {
		if (harnesses.isEmpty() || harnesses == null)
			return true;
		else
			return false;
	}

	public void addHarness(Harness harness1) {
		harnesses.add(harness1);
	}

	public Harness findHarness(String make, String modelNumber) {
		for (int i = 0; i < harnesses.size(); i++) {
			if (harnesses.get(i).make == make && harnesses.get(i).modelNumber == modelNumber) {
				return harnesses.get(i);
			}
		}
		return null;
	}

	public Harness checkHarness(String instructor, String make, String modelNumber) {
		Harness myHarness = findHarness(make, modelNumber);
		if (myHarness == null)
			return null;
		myHarness.checkHarness(instructor);
		return myHarness;
	}

	public Harness loanHarness(String clubMember) {
		for (int i = 0; i < harnesses.size(); i++) {
			if (!harnesses.get(i).isHarnessOnLoan()) {
				harnesses.get(i).loanHarness(clubMember);
				return harnesses.get(i);
			}
		}
		return null;
	}

	public Harness returnHarness(String make, String modelNumber) {
		Harness myHarness = findHarness(make, modelNumber);
		if (myHarness == null || !myHarness.isHarnessOnLoan())
			return null;
		myHarness.returnHarness();
		return myHarness;
	}

	public Harness removeHarness(String make, String modelNumber) {
		Harness myHarness = findHarness(make, modelNumber);
		if (myHarness == null)
			return null;
		harnesses.remove(myHarness);
		return myHarness;
	}
}