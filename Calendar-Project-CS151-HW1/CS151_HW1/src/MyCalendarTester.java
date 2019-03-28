// Tai Dao's HW 1
// Class: CS151
// Program: Google Calendar Clone

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Collections;

enum MONTHS {
	Jan, Feb, March, Apr, May, June, July, Aug, Sep, Oct, Nov, Dec;
}
enum DAYS {
	Sun, Mon, Tue, Wed, Thur, Fri, Sat ;
}
public class MyCalendarTester {
    public static Scanner scanner;
    public static String[] arrayMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public static String[] arrayDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    
	public static void main(String[] args) {
		GregorianCalendar c = new GregorianCalendar(); //for capturing today
		EventManager e = new EventManager();
		Scanner sc = new Scanner (System.in);
		scanner = sc;
	
		printCurrentMonthCalendar(c);
		showMainMenu(c, e);
	
		System.out.println("Bye!");
	}
	/**
	 	Shows the main menu to the user. 
	 	The user gets to type in L, V, C, G, E, D, or Q and press enter
	 	to choose their menu options.
	 */
	public static void showMainMenu (Calendar c, EventManager e) {
		System.out.print("\nSelect one of the following menu options by typing in the one of boxed letters and pressing enter: \n");
		System.out.print("[L]oad [V]iew by  [C]reate [G]o to [E]vent list [D]elete  [Q]uit \n");
		
		char menuOption = scanner.next().charAt(0);

	    if (Character.toString(menuOption).matches("^[l,v,c,g,e,d,q,L,V,C,G,E,D,Q]*$")) {
	         switch (menuOption){
	         	case 'L':
	         	case 'l': menuLoad(c, e);
	         		break;
	         	case 'V': 
	         	case 'v': System.out.println("This function is incomplete. Try a different option.");
	         			  showMainMenu(c, e);//menuView(); // Incomplete
	         		break;
	         	case 'C':
	         	case 'c': menuCreate(c, e);
	         		break;
	         	case 'G':
	         	case 'g': System.out.println("This function has not been implemented. Try a different option.");
	         			  showMainMenu(c, e); // Not implemented
	         		break;
	         	case 'E':
	         	case 'e': menuEventList(c, e);
	         		break;
	         	case 'D': 
	         	case 'd': System.out.println("This function has not been implemented. Try a different option.");
   			  			  showMainMenu(c, e); // Not implemented
	         		break;
	         	case 'Q': 
	         	case 'q': menuQuit(c, e);
	         		break;
	         }
	    }
	    else{
	         System.out.println("Invalid input please try again. Type in either L, V, C, G, E, D, or Q and press Enter.");
	         showMainMenu (c, e);
	    }
	}
	/**
	 * This function prints the calendar of the current month with the current day highlighted in brackets {}.
	 */
	public static void printCurrentMonthCalendar(Calendar c) {  
		MONTHS[] arrayOfMonths = MONTHS.values();
	    
	    GregorianCalendar tempTodaysCalendar = new GregorianCalendar(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1);
		int firstDayOfMonth = tempTodaysCalendar.get(Calendar.DAY_OF_WEEK);
		int totalDaysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH); 
		int today = c.get(Calendar.DAY_OF_MONTH);
		String monthToPrint = String.format("%6s",arrayOfMonths[c.get(Calendar.MONTH)]);
		String yearToPrint =  String.format("%29d", c.get(Calendar.YEAR));

		// Printing title of Month and Year
		System.out.println(monthToPrint + yearToPrint);
		// Printing titles of Days
		System.out.println("   Su   Mo   Tu   We   Th   Fr   Sa");
		// Printing spaces for the first week
		int countFirstDayOfMonth = 1;
		while (countFirstDayOfMonth != firstDayOfMonth){
			System.out.print("     ");
			countFirstDayOfMonth++;
		}
		//Start of day of week count until the final day of the week...
		int dayOfWeekCount = firstDayOfMonth;
		
		for (int i = 1; i <= totalDaysInMonth; i++){
			dayOfWeekCount++;
			// Reached end of week. Print final day of week and create new line.
			if ((dayOfWeekCount % 8) == 0){
				if (i == today){
					System.out.print( String.format("%7s", "{" + i + "}\n"));
					dayOfWeekCount = 1;
				}
				else{
					System.out.print(String.format("%5d", i) + "\n");
					dayOfWeekCount = 1;
				}
			}
			// Keep printing Days.
			else{
				if (i == today){
					System.out.print( String.format("%5s", "{" + i + "}"));
				}
				else{
					System.out.print(String.format("%5d", i));
				}
			}
		}
	}
    /**
     * Function for loading events.txt parses out data
     *
     * @param c Calendar
     * @param e EventManager
     */
    public static void menuLoad(Calendar c, EventManager e) {

        try {
            FileReader fr = new FileReader("events.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String title, date;
            int start, end;
            while ((line = br.readLine()) != null) {
                String[] array = line.split("\\,");
                title = array[0];
                date = array[1];
                start = Integer.parseInt(array[2]);
                end = Integer.parseInt(array[3]);
                EventManager.addNewEvent(title, date, start, end);
            }

            br.close();
            fr.close();
            System.out.println("Saved events have loaded.");
            showMainMenu(c, e);
        } catch (IOException x) {
            System.out.println("There are no events to load. Please create some events, quit, save, and then try again.");
            showMainMenu(c, e);
        }
    }
    
	/**
	 * Incomplete... Allows us to see if events are on a certain day or certain month..
	 */
	public static void menuView(){
		System.out.print("[D]ay view or [M]view ?");
		char menuOption = scanner.next().charAt(0);
		
		 if (Character.toString(menuOption).matches("^[d,D,m,M]*$")) {
	         switch (menuOption){
	         	case 'd':
	         	case 'D': System.out.println("valid input");
	         		break;
	         	case 'm':
	         	case 'M': System.out.println("valid input");
	         		break;
	         }
	    }
		 else{
		        System.out.println("Invalid input please try again. Type in either D or M and press enter");
		        menuView();
		 }
	}
	/**
	 * This function creates asks the users for input and creates an event.
	 * 
	 * @param c Calendar
	 * @param e EventManager
	 */
	public static void menuCreate(Calendar c, EventManager e){
		String strDate = "";
		int timeStart = 0;
		int timeEnd = 0;
		
		System.out.print("Enter event name in camelCaseFormat no Spaces!: ");
		String eventName = scanner.next();
		System.out.println(eventName);

		boolean validDate = false;
        while (!validDate) {
            System.out.println("\nEnter the date of the event in MM/DD/YYYY Format: ");
            strDate = scanner.next();
   
            int month = Integer.parseInt(strDate.substring(0, 2));
            int day = Integer.parseInt(strDate.substring(3, 5));
            if (strDate.length() == 10 && month <= 12 && day <= 31) {
                validDate = true;
            }
            else{
            	System.out.print("Invalid date please try again: \n");
            }
        }
        boolean validStartTime = false;
        boolean validTimes = false;

		while (!validStartTime){
			System.out.print("Enter start time in 24 hour format. \nExample: 600 represents 6AM. 1715 represents 5:15 PM: ");
			String strTimeStart = scanner.next();
			timeStart = Integer.parseInt(strTimeStart);
			if (timeStart < 2400){
				validStartTime = true;
				while(!validTimes){
					System.out.print("Enter end time in the same format as previously stated: ");
					String strTimeEnd = scanner.next();
					timeEnd = Integer.parseInt(strTimeEnd);
					if (timeStart > timeEnd){
						System.out.print("Start time is greater than end time. Please try again...\n\n");			
						
						
					}
					else{
						validTimes = true;	
						//break;
					}
				}
	
			}
			else{
				System.out.println("Start time is greater than 2400. Please try again...\n\n");	
			}
		}
		
        EventManager.addNewEvent(eventName, strDate, timeStart, timeEnd);
        System.out.println("Event Created.");
        showMainMenu(c, e);
	}
	
    /**
     * This function lists all events that exist on the calendar
     * 
     * @param c Calendar
     * @param e EventManager
     */
    public static void menuEventList(Calendar c, EventManager e) {
        System.out.println("\nYour scheduled events:");
        if (!e.events.isEmpty()) {
            Collections.sort(e.events);
            for (Event x : e.events) {
                try {
                    if (x != null) {
                        printEventInfo(x);
                    }
                } catch (Exception error) {
                    System.out.println("null");
                }
            }
        }
        System.out.println("****** End of Event List ******");
        showMainMenu(c, e);
    }
    

	/**
	 * This function quits the program and saves the events created in menuCreate to an events.txt file
	 * 
	 * @param c Calendar
	 * @param e EventManager
	 */
    public static void menuQuit(Calendar c, EventManager e) {
        try {
            FileWriter fw = new FileWriter("events.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Event newEvent : e.events) {
                bw.write(writeEventInfo(newEvent));
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException noIdeaITookThisFromStackExchange) {
            System.out.println("problems w/ file...");
        }
        System.out.println("Events have been saved to events.txt. Quit? [Y]es or [N]o");
        String input = scanner.next();
        input = input.toUpperCase();
        if (input.equals("Y")) {
        	System.out.println("\nBye!");
            System.exit(0);
        } else {
            showMainMenu(c, e);
        }
    }
    
    /**
     * Prints the event information... like the Day (Name), Day (#), Month, Year, TimeStart, TimeEnd, EventName
     * @param x Event
     */
    public static void printEventInfo(Event x) {
        printInfo(x.getCalendar());
        if (x.getEndTime() != 0) {
            System.out.print(" " + x.getStartTime() + " - " + x.getEndTime() + " " + x.getTitle() + "\n");
        } else {
            System.out.print(" " + x.getStartTime() + " " + x.getTitle() + "\n");
        }
    }
    
    /**
     * Prints date information... like the Day (Name), Day (#), Month, and Year
     *
     * @param c Calendar
     */
    public static void printInfo(Calendar c) {
        System.out.print(arrayDays[c.get(Calendar.DAY_OF_WEEK) - 1] + " ");
        System.out.print(c.get(Calendar.DAY_OF_MONTH) + " ");
        System.out.print(arrayMonths[c.get(Calendar.MONTH)] + " ");
        System.out.print(c.get(Calendar.YEAR));
    }
    
    /**
     * This functions returns the event to be saved into save file
     *
     * @param e Event
     * @return eventInfo String
     */
    public static String writeEventInfo(Event e) {
        String eventInfo = (e.getTitle() + "," + e.getDate() + "," + e.getStartTime() + "," + e.getEndTime());
        return eventInfo;
    }
}
