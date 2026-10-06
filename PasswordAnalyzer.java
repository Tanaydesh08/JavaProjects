import java.util.Scanner;

public class PasswordAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String password;
        char choice;

        // DO-WHILE → Analyze passwords repeatedly
        do {

            System.out.println("\n==============================");
            System.out.println("     🔐 PASSWORD ANALYZER");
            System.out.println("==============================");

            // WHILE → Make sure password isn't empty
            do {
                System.out.print("Enter password: ");
                password = sc.nextLine();

                if (password.isEmpty()) {
                    System.out.println("❌ Password cannot be empty!");
                }

            } while (password.isEmpty());

            int score = 0;
            boolean hasUppercase = false;
            boolean hasLowercase = false;
            boolean hasDigit = false;
            boolean hasSpecial = false;

            // FOR → Check every character
            for (int i = 0; i < password.length(); i++) {

                char ch = password.charAt(i);

                if (Character.isUpperCase(ch)) {
                    hasUppercase = true;
                }

                if (Character.isLowerCase(ch)) {
                    hasLowercase = true;
                }

                if (Character.isDigit(ch)) {
                    hasDigit = true;
                }

                if (!Character.isLetterOrDigit(ch)) {
                    hasSpecial = true;
                }
            }

            // IF-ELSE → Calculate password score

            if (password.length() >= 8) {
                score++;
            }

            if (hasUppercase) {
                score++;
            }

            if (hasLowercase) {
                score++;
            }

            if (hasDigit) {
                score++;
            }

            if (hasSpecial) {
                score++;
            }

            System.out.println("\n------ ANALYSIS ------");

            System.out.println(
                    "Length: " + password.length()
            );

            System.out.println(
                    "Uppercase: " +
                    (hasUppercase ? "✅" : "❌")
            );

            System.out.println(
                    "Lowercase: " +
                    (hasLowercase ? "✅" : "❌")
            );

            System.out.println(
                    "Number: " +
                    (hasDigit ? "✅" : "❌")
            );

            System.out.println(
                    "Special Character: " +
                    (hasSpecial ? "✅" : "❌")
            );

            System.out.println("\nPassword Strength:");

            if (score <= 2) {

                System.out.println("🔴 WEAK");

            } else if (score <= 4) {

                System.out.println("🟡 MEDIUM");

            } else {

                System.out.println("🟢 STRONG");
            }

            System.out.print("\nAnalyze another password? (y/n): ");
            choice = sc.nextLine().charAt(0);

        } while(choice == 'y' || choice == 'Y');
        System.out.println("\n 👋 Analyzer Closed");
        sc.close();
    }
}

