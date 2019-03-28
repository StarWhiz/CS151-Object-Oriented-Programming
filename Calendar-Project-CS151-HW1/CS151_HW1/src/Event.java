import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;

public class Event implements Comparable<Event> {
    
    private String title;
    private String date;
    private int startTime;
    private int endTime;
    private GregorianCalendar c;
    
    /**
     * This is the Constructor for Event to put into calendar 
     * @param theTitle the title of the event
     * @param theDate the date of the event in MM/DD/YYYY
     * @param theStart the start time of the event
     * @param theEnd the end time of the event
     */
    public Event(String eTitle, String eDate, int eStartTime, int eEndTime){
        title = eTitle;
        date = eDate;
        startTime = eStartTime;
        endTime = eEndTime;
        GregorianCalendar c = new GregorianCalendar(this.getYear(), this.getMonth()-1, this.getDay());
        this.c = c;
    }
    
    /**
     *This returns the calendar with events included
     * @return c GregorianCalendar
     */
    public GregorianCalendar getCalendar(){
        return c;
    }   
    /**
     *This returns the title of the event
     * @return title String
     */
    public String getTitle(){
        return title;    
    }

    /**
     *This returns the date of the event
     * @return date String
     */
    public String getDate(){
        return date;
    }
    
    /**
     *This returns the year of the event
     * @return year Int
     */
    public int getYear(){
        String year = date.substring(6,10);
        return Integer.parseInt(year);
    }

    /**
     *This returns the month of the event
     * @return month Int
     */
    public int getMonth(){
        String month = date.substring(0,2);
        if(month.substring(0,1).equals("0")){
            month = date.substring(1,2);
        }
        int x = Integer.parseInt(month);
        return x;
    }
    
    /**
     *This returns the day of the event
     * @return day Int
     */
    public int getDay(){
        
        String day = date.substring(3,5);
        if(day.substring(0,1).equals("0")){
            day = date.substring(4,5);
        }
        int x = Integer.parseInt(day);
        return x;
    }
    
    /**
     *This returns the day of the week of the event
     * @return dayWeek Int
     */
    public int getDayOfWeek(){
        return this.getCalendar().get(Calendar.DAY_OF_WEEK);
    }
    
    /**
     *This returns the start time of the event
     * @return startTime Int
     */
    public int getStartTime(){
        return startTime;
    }
    
    /**
     *This returns the end time of the event
     * @return endTime Int
     */
    public int getEndTime(){
        return endTime;
    }
    
    /**
     * Function to sort all event in list
     * @param args
     */
    public static void main(String[] args){
        ArrayList<Event> list = new ArrayList<>();
        Collections.sort(list);
        for(Event e: list){
             System.out.println(e.getDayOfWeek() + " " + e.getMonth() + " " + e.getDay() + " " + e.getYear() + " " + e.getTitle() + " " + e.getStartTime() + " " + e.getEndTime());
        }       
    }

    // This method is used to sort the events
    public int compareTo(Event that) {
        int num = 0;
        if(this.getYear() != that.getYear()){
            num = this.getYear()-that.getYear();
        }
        
        else if(this.getMonth() != that.getMonth()){
            num = this.getMonth()-that.getMonth();
        }
        
        else if(this.getDay() != that.getDay()){
            num = this.getDay()-that.getDay();
        }
        
        else{
            num = this.getStartTime()-that.getStartTime();
        }
    return num;
    }
}
