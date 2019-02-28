import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ClubManager {
	
	public static final int NAME_INDEX = 0;
	public static final int ADDRESS_INDEX = 1;	
	public static final int YEAR_OF_REG_INDEX = 2;
	public static final int EMAIL_INDEX = 3;
	
	
	
	public static void main(String args[]) {
		try {
		ArrayList<ClubMember> clubMembers = new ArrayList<>();
		FileReader fileReader = new FileReader("members.txt");
		BufferedReader bufferReader = new BufferedReader(fileReader);
		boolean endOfFile = false;
		while (!endOfFile) {
			String members = br.readLine();
			if(members != null) {
				String[] membersList = members.split(" ,");
				String name = membersList(NAME_INDEX);
				String address = membersList(ADDRESS_INDEX);
			}
		}
	}
		catch(FileNotFoundException e)
}
	public void printMembers(ArrayList<ClubManager>clubMembersList) {
		String clubMembersNames = "Names of members of the club are";
		for(int i = 0; i < clubMembersList.size(); i++) {
			clubMembersNames += clubMembersList.get(i).getName() + " ,";
		}
		System.out.println((clubMembersNames.substring(0, clubMembers));

	}
	public ClubManager getMember(ArrayList<ClubManager>clubMemberList, String name) {
		boolean memberFound = false;
		int counter = 0;
		ClubManager = null;
		while(!memberFound && counter < clubMemberList.size()) {
			member = clubMemberList.get(counter);
			if(name.equals(clubMemberList.get(counter).getName())) {
				memberFound = true;
			} else
				counter++;
				member = null;
		}
		return member;
		
	}
	
	public void updateMember(ClubManager member, String address, String email) {
		if(member != null ) { 
			if(address != null) {
				member.setAddress(address);
			}
			if(email != null) {
				member.setEmail(email);	
			}
		}
	}
	public Group CreateGroup(int grouId, String groupDescription) {
		Group clubGroup = new Group(groupId, groupDescription, new ArrayList<ClubMember>());
		return clubGroup;
	}
	
	public void addMemfberToGroup(Group group, ClubMember member) {
		ArrayList<ClubMember>groupMembers = group.getGroupMember();
		boolean memberFound = false;
		int counter = 0;
		while(!memberFoundd && counter < groupMembers.size()) {
			if(groupMembers.get(counter).getName().equals(member)
		}
	}



	private static String membersList(int nameIndex) {
		// TODO Auto-generated method stub
		return null;
	}		
}