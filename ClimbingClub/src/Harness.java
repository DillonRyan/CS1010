import java.util.Scanner;

public class Harness {

	public static final int MAX_NUMBER_OF_USES = 25;

	public static void main(String[] args) {
		HarnessRecords records = new HarnessRecords();
		Scanner input = new Scanner(System.in);

		System.out.println(
				"Please enter weather you want to View Records,Loan/Return,Add/Remove Harness,Update Safety Check");
		input = new Scanner(System.in);
		if (input.hasNext("View Records") || input.hasNext("Loan/Return") || input.hasNext("Add/Remove Harness")
				|| input.hasNext("Update Safety Check")) {
			String userInput = input.next();
			userInput.toLowerCase();

		}
	}

	public String make;
	public String modelNumber;
	private int timesUsed;
	public String instructor;
	public boolean onLoan;
	public String clubMember;

	public Harness(String make, String modelNumber, int timesUsed, String instructor, boolean onLoan,
			String clubMember) {
		this.make = make;
		this.modelNumber = modelNumber;
		this.timesUsed = timesUsed;
		this.instructor = instructor;
		this.onLoan = onLoan;
		this.clubMember = clubMember;
	}

	public Harness(String make, String modelNumber, String instructor) {
		this.make = make;
		this.modelNumber = modelNumber;
		this.timesUsed = 0;
		this.instructor = instructor;
		this.onLoan = false;
		this.clubMember = "";
	}

	public boolean checkHarness(String instructor) {
		this.timesUsed = 0;
		this.instructor = instructor;
		return true;
	}

	public boolean isHarnessOnLoan() {
		if (this.onLoan)
			return true;
		else
			return false;
	}

	public boolean canHarnessBeLoaned() {
		if (this.timesUsed >= MAX_NUMBER_OF_USES)
			return false;
		else
			return true;
	}

	public void loanHarness(String clubMember) {
		if (canHarnessBeLoaned() && !isHarnessOnLoan()) {
			this.clubMember = clubMember;
			this.timesUsed++;
			this.onLoan = true;
		}
	}

	public void returnHarness() {
		if (isHarnessOnLoan()) {
			this.onLoan = false;
			this.clubMember = "";
		}
	}

	public String toString() {
		return clubMember;
	}

}
