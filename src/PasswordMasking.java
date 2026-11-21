
import java.util.Scanner;

public class PasswordMasking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("      PASSWORD MASKING TOOL");
            System.out.println("================================");
            System.out.println("1. Mask Password");
            System.out.println("2. Show Password Strength");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("\nEnter your password: ");
                String password = sc.nextLine();

                if (password.isEmpty()) {
                    System.out.println("Password cannot be empty!");
                    continue;
                }

                System.out.println("\nChoose masking style:");
                System.out.println("1. Hide everything");
                System.out.println("2. Show last 2 characters");
                System.out.println("3. Show first and last character");
                System.out.print("Your choice: ");

                int style = sc.nextInt();
                sc.nextLine();

                StringBuilder masked = new StringBuilder();

                switch (style) {

                    case 1:
                        // FOR LOOP: Hide every character
                        for (int i = 0; i < password.length(); i++) {
                            masked.append("*");
                        }
                        break;

                    case 2:
                        // Hide all except last 2 characters
                        int visible = Math.min(2, password.length());

                        for (int i = 0; i < password.length() - visible; i++) {
                            masked.append("*");
                        }

                        masked.append(
                            password.substring(password.length() - visible)
                        );
                        break;

                    case 3:
                        // Show first and last character
                        if (password.length() <= 2) {
                            masked.append(password);
                        } else {
                            masked.append(password.charAt(0));

                            for (int i = 1; i < password.length() - 1; i++) {
                                masked.append("*");
                            }

                            masked.append(
                                password.charAt(password.length() - 1)
                            );
                        }
                        break;

                    default:
                        System.out.println("Invalid masking style!");
                        continue;
                }

                System.out.println("\nOriginal Length: " + password.length());
                System.out.println("Masked Password: " + masked);

            } else if (choice == 2) {

                System.out.print("\nEnter password: ");
                String password = sc.nextLine();

                int score = 0;

                if (password.length() >= 8) {
                    score++;
                }

                if (password.matches(".*[A-Z].*")) {
                    score++;
                }

                if (password.matches(".*[a-z].*")) {
                    score++;
                }

                if (password.matches(".*[0-9].*")) {
                    score++;
                }

                if (password.matches(".*[^a-zA-Z0-9].*")) {
                    score++;
                }

                System.out.print("Password Strength: ");

                if (score <= 2) {
                  System.out.println("WEAK");
                }else if (score <= 4) {
                  System.out.println("MEDIUM");
                }else {
                  System.out.println("STRONG");
                }

            } else if (choice == 3) {

                System.out.println("\nExiting Password Masking Tool...");

            } else {

                System.out.println("\nInvalid option!");

            }

        } while (choice != 3);

        sc.close();
    }
}
