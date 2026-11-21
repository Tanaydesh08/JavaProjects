
import java.util.Scanner;

public class LogAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] logs = new String[100];
        int count = 0;

        int infoCount = 0;
        int warningCount = 0;
        int errorCount = 0;

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("         LOG ANALYZER");
            System.out.println("================================");
            System.out.println("1. Add Log");
            System.out.println("2. View All Logs");
            System.out.println("3. Analyze Logs");
            System.out.println("4. Search Logs");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                if (count < logs.length) {
                    System.out.print("Enter log message: ");
                    logs[count] = sc.nextLine();
                    count++;

                    System.out.println("Log added successfully!");
                } else {
                    System.out.println("Log storage is full!");
                }

            } else if (choice == 2) {

                if (count == 0) {
                    System.out.println("No logs available.");
                } else {
                    System.out.println("\n------ ALL LOGS ------");

                    for (int i = 0; i < count; i++) {
                        System.out.println((i + 1) + ". " + logs[i]);
                    }
                }

            } else if (choice == 3) {

                infoCount = 0;
                warningCount = 0;
                errorCount = 0;

                System.out.println("\n------ ANALYZING LOGS ------");

                for (int i = 0; i < count; i++) {

                    String log = logs[i].toUpperCase();

                    if (log.contains("ERROR")) {
                        errorCount++;
                        System.out.println("[🔴 ERROR] " + logs[i]);

                    } else if (log.contains("WARNING")
                            || log.contains("WARN")) {
                        warningCount++;
                        System.out.println("[🟡 WARNING] " + logs[i]);

                    } else if (log.contains("INFO")) {
                        infoCount++;
                        System.out.println("[🟢 INFO] " + logs[i]);

                    } else {
                        System.out.println("[⚪ UNKNOWN] " + logs[i]);
                    }
                }

                System.out.println("\n------ SUMMARY ------");
                System.out.println("Total Logs: " + count);
                System.out.println("INFO: " + infoCount);
                System.out.println("WARNING: " + warningCount);
                System.out.println("ERROR: " + errorCount);

                if (errorCount > 0) {
                    System.out.println(
                            "⚠️ Attention: Errors detected!"
                    );
                } else {
                    System.out.println(
                            "✅ No errors detected!"
                    );
                }

            } else if (choice == 4) {

                System.out.print("Enter keyword to search: ");
                String keyword = sc.nextLine();

                boolean found = false;

                for (int i = 0; i < count; i++) {

                    if (logs[i].toLowerCase()
                            .contains(keyword.toLowerCase())) {

                        System.out.println("Found: " + logs[i]);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("No matching logs found.");
                }

            } else if (choice == 5) {

                System.out.println("Closing Log Analyzer...");

            } else {

                System.out.println("Invalid option!");
            }

        } while (choice != 5);

        sc.close();
    }
}
