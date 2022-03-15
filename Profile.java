import java.util.ArrayList;

public class Profile {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String dateOfBirth;
	private String emailAddress;
	private String phoneNumber;
	private String mobileNumber;
	private String disability;
	private String visa;
	private String occupation;
	
	public Profile(String firstName,String lastName,String address,String city,String state,String zip, String
			dateOfBirth,String emailAddress, String phoneNumber,String mobileNumber,String disability,String visa,String occupation)
	{
		this.firstName = firstName;
		this.lastName= lastName;
		this.address= address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.dateOfBirth=dateOfBirth;
		this.emailAddress=emailAddress;
		this.phoneNumber=phoneNumber;
		this.mobileNumber=mobileNumber;
		this.disability=disability;
		this.visa=visa;
		this.occupation=occupation;
		
	}
	public String getFirst()
	{
		return this.firstName;
	}
	public String getLast()
	{
		return this.lastName;
	}
	public String getVisa()
	{
		return this.visa;
	}
	public String getOccupation()
	{
		return this.occupation;
	}
	public ArrayList<String> accessDiscounts()
	{
		return null;
	}
	
}
