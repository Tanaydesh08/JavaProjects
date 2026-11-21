import java.util.Scanner;

public class GameInventory {

    public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);

        // Categories and items
        String[][] inventory = {
                {"Sword", "Bow", "Shield"},
                {"Health Potion", "Mana Potion", "Speed Potion"},
                {"Gold", "Gem", "Key"}
        };

        int choice;

        // DO-WHILE: Keep showing the game menu
        do {

            System.out.println("\n==============================");
            System.out.println("       🎮 GAME INVENTORY");
            System.out.println("==============================");
            System.out.println("1. View Inventory");
            System.out.println("2. Use Item");
            System.out.println("3. Search Item");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = sc.nextInt();
            sc.nextLine();

            // IF-ELSE: Handle menu options
            if (choice == 1) {

                System.out.println("\n------ YOUR INVENTORY ------");

                String[] categories = {
                        "⚔️ Weapons",
                        "🧪 Potions",
                        "💎 Items"
                };

                // NESTED FOR LOOPS
                // Outer loop → Categories
                // Inner loop → Items
                for (int i = 0; i < inventory.length; i++) {

                    System.out.println("\n" + categories[i]);

                    for (int j = 0; j < inventory[i].length; j++) {

                        System.out.println(
                                "  → " + inventory[i][j]
                        );
                    }
                }

            } else if (choice == 2) {

                System.out.print("\nEnter item to use: ");
                String item = sc.nextLine();

                boolean found = false;

                // FOR + nested FOR
                for (int i = 0; i < inventory.length; i++) {

                    for (int j = 0; j < inventory[i].length; j++) {

                        if (inventory[i][j]
                                .equalsIgnoreCase(item)) {

                            found = true;

                            System.out.println(
                                    "✅ You used: "
                                            + inventory[i][j]
                            );

                            break;
                        }
                    }

                    if (found) {
                        break;
                    }
                }

                if (!found) {
                    System.out.println("❌ Item not found!");
                }

            } else if (choice == 3) {

                System.out.print("\nSearch item: ");
                String search = sc.nextLine();

                boolean found = false;

                // WHILE: Search through inventory
                int category = 0;

                while (category < inventory.length) {

                    int item = 0;

                    while (item < inventory[category].length) {

                        if (inventory[category][item]
                                .toLowerCase()
                                .contains(search.toLowerCase())) {

                            System.out.println(
                                    "🔎 Found: "
                                            + inventory[category][item]
                            );

                            found = true;
                        }

                        item++;
                    }

                    category++;
                }

                if (!found) {
                    System.out.println("❌ No matching item found.");
                }

            } else if (choice == 4) {

                System.out.println(
                        "\n👋 Exiting inventory..."
                );

            } else {

                System.out.println(
                        "\n❌ Invalid option!"
                );
            }

        } while (choice != 4);

        sc.close();
    }
}
