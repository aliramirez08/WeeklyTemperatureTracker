import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperatureTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();

        // Initialize the days of the week
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        // Collect temperatures for each day
        System.out.println("Enter the average temperatures for each day of the week:");
        for (String day : days) {
            System.out.print("Enter temperature for " + day + ": ");
            double temp = scanner.nextDouble();
            temperatures.add(temp);
        }

        // User interaction loop
        while (true) {
            System.out.println("\nEnter a day to get the temperature (or type 'week' for weekly summary, 'exit' to quit): ");
            String userInput = scanner.next();

            if (userInput.equalsIgnoreCase("week")) {
                System.out.println("\nWeekly Temperatures:");
                double sum = 0;
                for (int i = 0; i < days.size(); i++) {
                    System.out.println(days.get(i) + ": " + temperatures.get(i) + "°F");
                    sum += temperatures.get(i);
                }
                double average = sum / days.size();
                System.out.println("Weekly average temperature: " + String.format("%.2f", average) + "°F");
            } 
            else if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            } 
            else if (days.contains(userInput)) {
                int index = days.indexOf(userInput);
                System.out.println(userInput + ": " + temperatures.get(index) + "°F");
            } 
            else {
                System.out.println("Invalid input. Please enter a valid day or 'week'.");
            }
        }

        scanner.close();
    }
}
