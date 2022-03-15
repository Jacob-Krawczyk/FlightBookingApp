import java.util.*;
public class Hotel {
	private String name;
	private String location;
	private int numberOfBeds;
	private String roomType;
	private ArrayList<Amenities> amentities;
	private ArrayList<Accessibility> accessibility;
	
	public Hotel(String name, String checkInDay, String checkOutDay, String location,
			int numberOfBeds, String roomType)
	{
		this.name=name;
		
	}
	public void addAmenities(Amenities amenitie)
	{
		amentities.add(amenitie);
	}
	public void removeAmenities(Amenities amenitie)
	{
		amentities.remove(amenitie);
	}
	public void addAccessibility(Accessibility accessibility1)
	{
		accessibility.add(accessibility1);
	}
	public void removeAccessibility(Accessibility accessibility1)
	{
		accessibility.remove(accessibility1);
	}
}
