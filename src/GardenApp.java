/* 
 *    GardenApp by
 *    Bryan Grigorie
 * 
 *    Welcome to my first ever open-source project.
 *    I created this application to assist with my gardening.
 *    What can I say? I'm a fan of practicality.
 *
 *    * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 *    Short-Term Issue List
 *    
 *    -Add Garden class
 *    -Entry saving, modifying, and deleting (such as updating last watered date)
 *    -View plants/garden
 *    
 *    * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *    
 *    Long-Term Objective List
 *    
 *    -Expand Plant class
 *    -Make input more user-friendly
 *    -Create a proper GUI on a JFrame
 *
 */

public class GardenApp {

	public static void main(String[] args) {
		
		// Primitive control structure below
		boolean loop = true;
		String choice;
		
		while(loop) {
			choice = BetterLib.readString("Type an option to proceed\n1 - "
					+ "Create a plant\n"
					+ "exit - Exit");
			
			switch(choice) {
			case "1": 
				
				try {
				    Plant p = new Plant(BetterLib.readString("Enter species name"), 
						BetterLib.readDate("Enter date seed was planted", "MM/dd/yyyy", "MM/dd/yyyy"), 
						BetterLib.readDate("Enter last time watered", "MM/dd/yyyy h:mm a", "MM/dd/yyyy h:mm AM"),
						BetterLib.readInteger("Enter the frequency of this plant's required watering in days"));
				
				    BetterLib.display(p.toString());
				}
				catch(Exception e) {
					BetterLib.display(e.toString());
				}
				
				break;
			case "exit":
				loop = false;
				break;
		    default:
		    	BetterLib.display("Invalid option!");
		    	break;
			}
		}
		
	}
	
}
