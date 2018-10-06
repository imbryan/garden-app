/* 
 *    BetterLib by
 *    Bryan Grigorie
 * 
 *    Here lies any method deemed to be ubiquitous.
 */

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JOptionPane;

public class BetterLib {
	static Date now = new Date();
	static Calendar calendar = GregorianCalendar.getInstance();
	static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
	
	// Display methods
	
	public static void display(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	// Read methods
	
	public static String readString(Component comp, Object message, Object initial) {
		return JOptionPane.showInputDialog(comp, message, initial);
	}
	
	public static String readString(String message) {
		return readString(null, message, null);
	}	
	
	public static int readInteger(String message) {
		return Integer.parseInt(readString(message));
	}
	
	public static long readLong(String message) {
		return Long.parseLong(readString(message));
	}
	
	public static Date readDate(String message) throws ParseException {
		return stringToDate(readString(message));
	}
	
	public static Date readDate(String message, String newPattern) throws ParseException {
		setSDF(newPattern, Locale.ENGLISH);
		return readDate(message);
	}
	
	public static Date readDate(String message, String newPattern, String initial) throws ParseException {
		setSDF(newPattern, Locale.ENGLISH);
		return stringToDate(readString(null,message,initial));
	}
	
	// Convert methods
	
	public static Date stringToDate(String givenDate) throws ParseException {
		return sdf.parse(givenDate);
	}	
	
	public static long calculateHours(Date givenDate) {
		long milli = getNow().getTime() - givenDate.getTime();
		
		return ((milli / (60000)) / 60);
	}
	
	public static long hoursToWeeks(long hours) {
		return hours / 168;
	}
	
	// Accessor methods
	
	// Two-way method for current date
	public static Date getNow() {
		return now = new Date();
	}
	
	public static int getCalendarData(int option) {
		return calendar.get(option);
	}
	
	public static Calendar getCalendar() {
		return calendar;
	}
	
	// Mutator methods
	
	public static void setSDF(String pattern, Locale locale) {
		sdf = new SimpleDateFormat(pattern, locale);
	}
	
	public static void setCalendar() {
		calendar = GregorianCalendar.getInstance();
		
	}
	
	public static void setCalendar(Date date) {
		setCalendar();
		calendar.setTime(date);
	}
}
