import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //boolean array to check if store is closed at a certain day

    private static boolean[] daysClosed = {false, false, false, false, false, false, false};

    //store hours stored as integers between 0 and 2359 (signifying 24 hour time)

    private static int sundayOpen;
    private static int sundayClose;
    private static int mondayOpen;
    private static int mondayClose;
    private static int tuesdayOpen;
    private static int tuesdayClose;
    private static int wednesdayOpen;
    private static int wednesdayClose;
    private static int thursdayOpen;
    private static int thursdayClose;
    private static int fridayOpen;
    private static int fridayClose;
    private static int saturdayOpen;
    private static int saturdayClose;

    public static void main(String[] args) throws Exception {
        generateStoreData();
    }

    //method to fill all of the variables for storeData (exits out of program if store hours are out of bounds of produce an error)

    private static void generateStoreData() {

        File storeData = null;

        URL url = Main.class.getResource("storeData.txt");

        //creation of storeData file
        try {
            storeData = new File(url.toURI());
        }

        catch (URISyntaxException e) {
            clearScreen();
            System.out.print("There was an error locating your file. Exiting program.");
            System.exit(0);
        }

        //putting data into List of Strings
        ArrayList<String> storedDataLines = readFileData(storeData);

        //modifying storedDataLines so we can rip the data from it

        //removes header and spacing

        storedDataLines.remove(0);
        storedDataLines.remove(0);

        String moddedString = "";

        //removing days of week from Strings

        storedDataLines.set(0, storedDataLines.get(0).replace("Sunday: ", ""));
        storedDataLines.set(1, storedDataLines.get(1).replace("Monday: ", ""));
        storedDataLines.set(2, storedDataLines.get(2).replace("Tuesday: ", ""));
        storedDataLines.set(3, storedDataLines.get(3).replace("Wednesday: ", ""));
        storedDataLines.set(4, storedDataLines.get(4).replace("Thursday: ", ""));
        storedDataLines.set(5, storedDataLines.get(5).replace("Friday: ", ""));
        storedDataLines.set(6, storedDataLines.get(6).replace("Saturday: ", ""));

        //removes irrelevant lines from dataLines before trying to store anything from it

        storedDataLines = new ArrayList<>(storedDataLines.subList(0, 7));

        //removing colons from times

        for (int i = 0; i < storedDataLines.size(); i++)
            storedDataLines.set(i, storedDataLines.get(i).replaceAll(":", ""));

        //TODO Setting variables and exiting program if there is any errors

        //Setting boolean[] (for store closure days)
        for (int i = 0; i < 7; i++) {
            if (storedDataLines.get(i).equalsIgnoreCase(("CLOSED")))
                daysClosed[i] = true;
        }

        //trying to set open/close variables (WILL ERROR IF VALUES ARE NOT INTEGERS)

        try {
            if (!daysClosed[0]) {
                sundayOpen = Integer.parseInt((storedDataLines.get(0).split("-"))[0]);
                sundayClose = Integer.parseInt((storedDataLines.get(0).split("-"))[1]);
            }

            if (!daysClosed[1]) {
                mondayOpen = Integer.parseInt((storedDataLines.get(1).split("-"))[0]);
                mondayClose = Integer.parseInt((storedDataLines.get(1).split("-"))[1]);
            }

            if (!daysClosed[2]) {
                tuesdayOpen = Integer.parseInt((storedDataLines.get(2).split("-"))[0]);
                tuesdayClose = Integer.parseInt((storedDataLines.get(2).split("-"))[1]);
            }

            if (!daysClosed[3]) {
                wednesdayOpen = Integer.parseInt((storedDataLines.get(3).split("-"))[0]);
                wednesdayClose = Integer.parseInt((storedDataLines.get(3).split("-"))[1]);
            }

            if (!daysClosed[4]) {
                thursdayOpen = Integer.parseInt((storedDataLines.get(4).split("-"))[0]);
                thursdayClose = Integer.parseInt((storedDataLines.get(4).split("-"))[1]);
            }

            if (!daysClosed[5]) {
                fridayOpen = Integer.parseInt((storedDataLines.get(5).split("-"))[0]);
                fridayClose = Integer.parseInt((storedDataLines.get(5).split("-"))[1]);
            }

            if (!daysClosed[6]) {
                saturdayOpen = Integer.parseInt((storedDataLines.get(6).split("-"))[0]);
                saturdayClose = Integer.parseInt((storedDataLines.get(6).split("-"))[1]);
            }

            //testing if ALL hours variables are within range

            int[] hoursValues = {sundayOpen, sundayClose, mondayOpen, mondayClose, tuesdayOpen, tuesdayClose, wednesdayOpen, wednesdayClose, thursdayOpen, thursdayClose, fridayOpen, fridayClose, saturdayOpen, saturdayClose};
            for (int hoursValue : hoursValues) {
                //checks if hoursValue is within 24 hour time and has a valid minute between 0 and 60
                if (hoursValue < 0 || hoursValue > 2359 || hoursValue % 100 > 60) {
                    clearScreen();
                    System.out.print("Some of your store hours are not valid. Please review them.");
                    System.exit(0);
                }

            }

        }

        catch (Exception e) {
            clearScreen();
            System.out.print("There was an error in reading your store hours. Please review them to make sure they are valid.");
            System.exit(0);
        }

    }

    //method to read a file and return the lines as an ArrayList of Strings

    private static ArrayList<String> readFileData(File fileName) {

        ArrayList<String> lines = new ArrayList<String>();
        try {
            Scanner fileScanner = new Scanner(fileName);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                lines.add(line);
            }

        }

        catch (Exception e) {
            clearScreen();
            System.out.print("There was an error reading from this file.");
            System.exit(0);
        }

        return lines;
    }

    //TODO change return type of this
    public static void generateEmployeeData() {
        
    }

    //method to "clear screen"

    private static void clearScreen() {
        for (int i = 0; i < 3000; i++)
            System.out.print("\n");
    }
}
