import java.util.Calendar;
import java.util.Date;

public class Plant {
	private String species;		
	private Date planted; // Date that a seed was planted
	private Date lastWatered; // Date that this plant was last watered
	
	private long age; // Weeks that passed since planted
	private long sinceWatered; // Hours that passed since lastWatered


	public Plant(String species, Date planted, Date watered) {
		setPlanted(planted);
		setLastWatered(watered);
		setAge(BetterLib.hoursToWeeks(BetterLib.calculateHours(planted)));
		setSinceWatered(BetterLib.calculateHours(watered));
		setSpecies(species);
	}
	
	public String toString() {
		String generate, plantDate="", waterDate="";
		int count = 0;
		
		// My way of reducing redundancy (I didn't say it was effective)
		while(count<2) {
			if(count==0)
				BetterLib.setCalendar(planted);
			else
				BetterLib.setCalendar(lastWatered);
			
			generate = BetterLib.getCalendarData(Calendar.MONTH)+1 + "/" // Calendar.MONTH starts from 0, HAH!
					+ BetterLib.getCalendarData(Calendar.DAY_OF_MONTH) + "/"
					+ BetterLib.getCalendarData(Calendar.YEAR);
			
			if(count==0)
				plantDate = generate;
			else
				waterDate = generate;
			
			count++;
		}
		
		return species+"\nPlanted: "+plantDate+", "+age+" week(s) old\nLast Watered: "+waterDate+", "+sinceWatered+" hour(s) ago";
	}
	
	// Accessor methods
	
	public Date getPlanted() {
		return planted;
	}
	
	public Date getLastWatered() {
		return lastWatered;
	}
	
	public long getAge() {
		return age;
	}
	
	public String getSpecies() {
		return species;
	}
	
	public long getSinceWatered() {
		return sinceWatered;
	}
	
	// Mutator methods
	
	public void setPlanted(Date planted) {
		this.planted = planted;
	}
	
	public void setLastWatered(Date watered) {
		this.lastWatered = watered;
	}
	
	public void setAge(long age) {
		this.age = age;
	}
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	public void setSinceWatered(long sinceWatered) {
		this.sinceWatered = sinceWatered;
	}
}
