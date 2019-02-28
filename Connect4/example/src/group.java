import java.util.ArrayList;

public class group {
	private int group;
	private String groupDescription;
	private ArrayList<members> groupMembers;
	public group(int group, String groupDescription, ArrayList<members> groupMembers) {
		super();
		this.group = group;
		this.groupDescription = groupDescription;
		this.groupMembers = groupMembers;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public String getGroupDescription() {
		return groupDescription;
	}
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}
	public ArrayList<members> getGroupMembers() {
		return groupMembers;
	}
	public void setGroupMembers(ArrayList<members> groupMembers) {
		this.groupMembers = groupMembers;
	}
	@Override
	public String toString() {
		return "group [group=" + group + ", groupDescription=" + groupDescription + ", groupMembers=" + groupMembers
				+ ", getGroup()=" + getGroup() + ", getGroupDescription()=" + getGroupDescription()
				+ ", getGroupMembers()=" + getGroupMembers() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
