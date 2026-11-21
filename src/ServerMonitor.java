import java.util.Scanner;

public class ServerMonitor{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    String[][] servers = {
      {"API Server", "Database", "Redis"},
      {"Auth Server", "Payment Server", "Email Server"},
      {"Storage Server", "Backup Server ", "Log Server"}
    };
    boolean[][] status = {
      {true, true, false},
      {true, false, true},
      {true, true, true}
    };
    int choice;

        // DO-WHILE → Keep monitoring until user exits
        do {

            System.out.println("\n================================");
            System.out.println("       🌐 SERVER MONITOR");
            System.out.println("================================");
            System.out.println("1. View Server Status");
            System.out.println("2. Check Server");
            System.out.println("3. Restart Server");
            System.out.println("4. Search Server");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            choice = sc.nextInt();
            sc.nextLine();

            // IF-ELSE → Handle menu
            if (choice == 1) {

                System.out.println("\n------ SERVER STATUS ------");

                // NESTED FOR
                // Outer loop → Server groups
                // Inner loop → Servers
                for (int i = 0; i < servers.length; i++) {

                    System.out.println("\nServer Group " + (i + 1));

                    for (int j = 0; j < servers[i].length; j++) {

                        if (status[i][j]) {
                            System.out.println(
                                    "🟢 " + servers[i][j] + " → ONLINE"
                            );
                        } else {
                            System.out.println(
                                    "🔴 " + servers[i][j] + " → OFFLINE"
                            );
                        }
                    }
                }

            } else if (choice == 2) {

                System.out.print("\nEnter server name: ");
                String search = sc.nextLine();

                boolean found = false;

                // FOR → Search servers
                for (int i = 0; i < servers.length; i++) {

                    for (int j = 0; j < servers[i].length; j++) {

                        if (servers[i][j].equalsIgnoreCase(search)) {

                            found = true;

                            System.out.println(
                                    "\nServer: " + servers[i][j]
                            );

                            if (status[i][j]) {
                                System.out.println("Status: 🟢 ONLINE");
                                System.out.println("Response: 42ms");
                            } else {
                                System.out.println("Status: 🔴 OFFLINE");
                                System.out.println(
                                        "Response: No response"
                                );
                            }

                            break;
                        }
                    }

                    if (found) {
                        break;
                    }
                }

                if (!found) {
                    System.out.println("❌ Server not found!");
                }

            } else if (choice == 3) {

                System.out.print("\nEnter server name to restart: ");
                String serverName = sc.nextLine();

                boolean found = false;

                for (int i = 0; i < servers.length; i++) {

                    for (int j = 0; j < servers[i].length; j++) {

                        if (servers[i][j]
                                .equalsIgnoreCase(serverName)) {

                            found = true;

                            if (!status[i][j]) {

                                System.out.println(
                                        "\n🔄 Restarting "
                                                + servers[i][j] + "..."
                                );

                                status[i][j] = true;

                                System.out.println(
                                        "✅ Server is back ONLINE!"
                                );

                            } else {

                                System.out.println(
                                        "🟢 Server is already ONLINE."
                                );
                            }

                            break;
                        }
                    }

                    if (found) {
                        break;
                    }
                }

                if (!found) {
                    System.out.println("❌ Server not found!");
                }

            } else if (choice == 4) {

                System.out.print("\nSearch keyword: ");
                String keyword = sc.nextLine();

                boolean found = false;

                // WHILE → Search through server groups
                int group = 0;

                while (group < servers.length) {

                    int server = 0;

                    while (server < servers[group].length) {

                        if (servers[group][server].toLowerCase().contains(keyword.toLowerCase())){
                          System.out.println("🔎 Found: " + servers[group][server]);
                          found = true;
                        }

                        server++;
                    }

                    group++;
                }

                if (!found) {
                    System.out.println(
                            "❌ No matching server found."
                    );
                }

            } else if (choice == 5) {

                System.out.println(
                        "\n👋 Monitoring stopped."
                );

            } else {

                System.out.println(
                        "\n❌ Invalid option!"
                );
            }

        } while (choice != 5);

        sc.close();
    }
}
