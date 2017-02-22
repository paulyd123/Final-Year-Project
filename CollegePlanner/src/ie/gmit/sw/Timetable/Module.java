package ie.gmit.sw.Timetable;

public class Module {
	
	//private variables
	private String uniIns;
	private String title;
	private int timeStart;
	private int timeEnd;
	private int day;
	private int room;
	
	
	/**
	 * Module is a constructor that takes in the four parameters and sets the class variables
	 * 
	 * @param title
	 * @param timeStart
	 * @param timeEnd
	 * @param day
	 * 
	 */
	public Module(String uniIns, String title, int timeStart, int timeEnd, int day, int room){
		this.uniIns=uniIns;
		this.title=title;
		this.timeStart=timeStart;
		this.timeEnd=timeEnd;
		this.day=day;
		this.room=room;
	}
	
	/**
	 * Getter for uniIns in order to access the objects information
	 * @return
	 */
	public String getUniIns() {
		return uniIns;
	}
	
	/**
	 * Getter for title in order to access the objects information
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Getter for timeStart in order to access the objects information
	 * @return
	 */
	public int getTimeStart() {
		return timeStart;
	}

	/**
	 * Getter for timeEnd in order to access the objects information
	 * @return
	 */
	public int getTimeEnd() {
		return timeEnd;
	}	

	/**
	 * Getter for day in order to access the objects information
	 * @return
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * Getter for room in order to access the objects information
	 * @return
	 */
	public int getRoom(){
		return room;
	}

	/**
	 * This returns a custom toString of the title, timeStart, timeEnd, day and room.
	 * @return
	 */
	public String toString() {
		return uniIns+" "+title+" "+timeStart+" "+timeEnd+" "+day+" "+room;
	}
}
