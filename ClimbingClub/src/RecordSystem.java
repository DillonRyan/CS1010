import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class RecordSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner(System.in);
		System.out.println(" Welcome to the program! ");
		ArrayList<String> registry = readRegistry();
		boolean inputing = true;
		while (inputing)
		{
			inputScanner.next();
			System.out.println("Enter a command ( add , remove, record, loan, return, quit):");
			String enteredString =  inputScanner.next();
			enteredString = enteredString.toUpperCase();
			if ( enteredString.equals("ADD" ) /* || enteredString.equals("REMOVE") || enteredString.equals("RECORD") || enteredString.equals("LOAN") */ ) 
			{
				
			}
			else if ( enteredString.equals("Q") || enteredString.equals("QUIT") )
			{
				 inputing = false;
			}
		}
	}
	public static ArrayList<String> readRegistry()
	{
		In page = new In("registry.txt"); // change parameter here to read a different file
		String temp = page.readAll();
		String[] tempRegistry = temp.split("\n");
		ArrayList<String> registry = new ArrayList<String>(Arrays.asList(tempRegistry));
		return registry;
	}

}