public class Employee {
    //maximum hours that can be entered under max hours (due to labor laws)
    private static final int MAXIMUM_LEGAL_HOURS = 40;

    //boolean[] to check if employee can work on certain day of week (default as true, changed to false if text file reads NONE in availability)
    private boolean[] canWorkOnDay = {true, true, true, true, true, true, true};

    private String name;

    //variables for start and end times for every day of the week (stored as integers between 0 and 2359 for 24 hour time)
    private int sundayStartTime;
    private int sundayEndTime;
    private int mondayStartTime;
    private int mondayEndTime;
    private int tuesdayStartTime;
    private int tuesdayEndTime;
    private int wednesdayStartTime;
    private int wednesdayEndTime;
    private int thursdayStartTime;
    private int thursdayEndTime;
    private int fridayStartTime;
    private int fridayEndTime;
    private int saturdayStartTime;
    private int saturdayEndTime;

    public Employee(boolean[] canWorkOnDay, String name, int sundayStartTime, int sundayEndTime, int mondayStartTime, int mondayEndTime, int tuesdayStartTime, int tuesdayEndTime, int wednesdayStartTime, int wednesdayEndTime, int thursdayStartTime, int thursdayEndTime, int fridayStartTime, int fridayEndTime, int saturdayStartTime, int saturdayEndTime) {
        this.canWorkOnDay = canWorkOnDay;
        this.name = name;
        this.sundayStartTime = sundayStartTime;
        this.sundayEndTime = sundayEndTime;
        this.mondayStartTime = mondayStartTime;
        this.mondayEndTime = mondayEndTime;
        this.tuesdayStartTime = tuesdayStartTime;
        this.tuesdayEndTime = tuesdayEndTime;
        this.wednesdayStartTime = wednesdayStartTime;
        this.wednesdayEndTime = wednesdayEndTime;
        this.thursdayStartTime = thursdayStartTime;
        this.thursdayEndTime = thursdayEndTime;
        this.fridayStartTime = fridayStartTime;
        this.fridayEndTime = fridayEndTime;
        this.saturdayStartTime = saturdayStartTime;
        this.saturdayEndTime = saturdayEndTime;
    }

    public boolean[] getCanWorkOnDay() {
        return canWorkOnDay;
    }

    public int getStartTime(String day) {
        if (day.equalsIgnoreCase("Sunday"))
            return sundayStartTime;
        else if (day.equalsIgnoreCase("Monday"))
            return mondayStartTime;
        else if (day.equalsIgnoreCase("Tuesday"))
            return tuesdayStartTime;
        else if (day.equalsIgnoreCase("Wednesday"))
            return wednesdayStartTime;
        else if (day.equalsIgnoreCase("Thursday"))
            return thursdayStartTime;
        else if (day.equalsIgnoreCase("Friday"))
            return fridayStartTime;
        else if (day.equalsIgnoreCase("Saturday"))
            return saturdayStartTime;
        //should never reach this 0 if day is valid
        return 0;
    }

    public int getEndTime(String day) {
        if (day.equalsIgnoreCase("Sunday"))
            return sundayEndTime;
        else if (day.equalsIgnoreCase("Monday"))
            return mondayEndTime;
        else if (day.equalsIgnoreCase("Tuesday"))
            return tuesdayEndTime;
        else if (day.equalsIgnoreCase("Wednesday"))
            return wednesdayEndTime;
        else if (day.equalsIgnoreCase("Thursday"))
            return thursdayEndTime;
        else if (day.equalsIgnoreCase("Friday"))
            return fridayEndTime;
        else if (day.equalsIgnoreCase("Saturday"))
            return saturdayEndTime;
        //should never reach this 0 if day is valid
        return 0;
    }

    public String getName() {
        return name;
    }

}
