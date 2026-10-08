import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCodeTranslator{
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    //Morse code Dictionary
    Map<Character, String> morse = new HashMap<>();
    morse.put('A',".-");
     morse.put('B', "-...");
        morse.put('C', "-.-.");
        morse.put('D', "-..");
        morse.put('E', ".");
        morse.put('F', "..-.");
        morse.put('G', "--.");
        morse.put('H', "....");
        morse.put('I', "..");
        morse.put('J', ".---");
        morse.put('K', "-.-");
        morse.put('L', ".-..");
        morse.put('M', "--");
        morse.put('N', "-.");
        morse.put('O', "---");
        morse.put('P', ".--.");
        morse.put('Q', "--.-");
        morse.put('R', ".-.");
        morse.put('S', "...");
        morse.put('T', "-");
        morse.put('U', "..-");
        morse.put('V', "...-");
        morse.put('W', ".--");
        morse.put('X', "-..-");
        morse.put('Y', "-.--");
        morse.put('Z', "--..");

        // Reverse dictionary: Morse -> Character
        Map<String, Character> reverseMorse = new HashMap<>();

        for (Map.Entry<Character, String> entry : morse.entrySet()) {
            reverseMorse.put(entry.getValue(), entry.getKey());
        }

        int choice;
        do {

            System.out.println("\n==============================");
            System.out.println("      📡 MORSE TRANSLATOR");
            System.out.println("==============================");
            System.out.println("1. Text -> Morse");
            System.out.println("2. Morse -> Text");
            System.out.println("3. Exit");
            System.out.println("Choose an option :");
        choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                // TEXT → MORSE

                System.out.print("\nEnter text: ");
                String text = sc.nextLine().toUpperCase();

                StringBuilder result = new StringBuilder();

                for (int i = 0; i < text.length(); i++) {

                    char ch = text.charAt(i);

                    if (ch == ' ') {

                        result.append(" / ");

                    } else if (morse.containsKey(ch)) {

                        result.append(morse.get(ch)).append(" ");

                    } else {

                        result.append("? ");
                    }
                }

                System.out.println("\nMorse Code:");
                System.out.println(result);

            } else if (choice == 2) {

                // MORSE → TEXT

                System.out.print("\nEnter Morse code: ");

                String input = sc.nextLine().trim();

                String[] words = input.split(" / ");

                StringBuilder result = new StringBuilder();

                for (String word : words) {

                    String[] letters = word.trim().split("\\s+");

                    for (String letter : letters) {

                        if (reverseMorse.containsKey(letter)) {

                            result.append(reverseMorse.get(letter));

                        } else {

                            result.append("?");
                        }
                    }

                    result.append(" ");
                }

                System.out.println("\nDecoded Text:");
                System.out.println(result.toString().trim());

            } else if (choice == 3) {

                System.out.println("\n👋 Translator closed.");

            } else {

                System.out.println("\n❌ Invalid option!");

            }

        } while (choice != 3);

        sc.close();
  }
}
