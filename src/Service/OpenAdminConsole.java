package Service;

import Enums.Role;
import Model.Coworking;
import Model.CoworkingManager;
import Model.User;

import java.math.BigDecimal;
import java.util.Scanner;

import static Storage.Storage.*;

public class OpenAdminConsole {
    public static void openAdminConsole() {
        System.out.println("Admin Console");
        System.out.println("=========================");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.Add coworking center \n 2.Add manager \n 3.Add manager to center \n 0.Exit \n =========================");
            int command = scanner.nextInt();
            if (command == 1) {
                AddCoworkingCenter();
            } else if (command == 2) {
                AddManager();
            } else if (command == 3) {
                AddManagerToCenter();
            } else if (command == 0) {
                break;
            }
        }


    }

    static int id2 = 0;

    private static void AddManagerToCenter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Center list: ");
        for (int i = 0; i < coworkingList.size(); i++) {
            System.out.println("ID: " + (i + 1) +
                    "\n Name: " + coworkingList.get(i).getName() +
                    "\n Address: " + coworkingList.get(i).getAddress());
        }
        System.out.println("Enter Id of Center");
        int command = scanner.nextInt();
        Coworking coworking = coworkingList.get(command - 1);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getRole().equals(Role.MANAGER)) {
                System.out.println("ID: " + (i + 1) +
                        "\n Name: " + users.get(i).getName());
            }
        }
        System.out.print("Enter Manager id: ");
        int manager = scanner.nextInt();
        User user = users.get(manager - 1);
        CoworkingManager coworkingManager = new CoworkingManager(id2, coworking, user);
        coworkingManagerList.add(coworkingManager);
        id2++;
    }

    static int id1 = 0;

    private static void AddManager() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("name: ");
        String name = scanner.nextLine();
        System.out.println("login: ");
        String login = scanner.nextLine();
        System.out.println("password");
        String password = scanner.nextLine();
        User user = new User(name, login, password, id1, Role.MANAGER, BigDecimal.ZERO);
        users.add(user);
        id1++;
    }

    static int id = 0;

    private static void AddCoworkingCenter() {
        boolean isContinue = true;
        while (isContinue) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Name: ");
            String name = scanner.nextLine();
            System.out.println("Address: ");
            String address = scanner.nextLine();
            Coworking coworking = new Coworking(id, name, address);
            coworkingList.add(coworking);
            id++;
            System.out.println("1.Continue \n 2.Stop");
            int command = scanner.nextInt();
            if (command == 2) {
                isContinue = false;
            }
        }

    }
}
