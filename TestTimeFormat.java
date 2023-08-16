package TimeFormat;

import java.util.Scanner;

public class TestTimeFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter time in 12-hour format (hh:mm:ss AM/PM): ");
        String time12 = scanner.nextLine();
        scanner.close();

        String militaryTime = convertToMilitaryTime(time12);
        System.out.println("Equivalent military time: " + militaryTime);
    }

    public static String convertToMilitaryTime(String time12) {
        String[] parts = time12.split(" ");
        String time = parts[0];
        String period = parts[1];
        String[] timeParts = time.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        int seconds = Integer.parseInt(timeParts[2]);

        if (period.equals("PM") && hours != 12) {
            hours += 12;
        } else if (period.equals("AM") && hours == 12) {
            hours = 0;
        }

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}

