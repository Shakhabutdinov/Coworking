package MainMenu;

import Enums.Role;
import Model.User;
import Service.OpenAdminConsole;
import Service.OpenManagerConsole;
import Service.OpenUserConsole;
import Service.SignInSignUp;

import java.math.BigDecimal;
import java.util.Scanner;

import static Storage.Storage.users;

public class MainMenu {
    public static void start() {
        System.out.println("@@@ Welcome @@@");
        User user = new User("Abdulaziz", "admin", "BMW", 0, Role.ADMIN, BigDecimal.ZERO);
        users.add(user);
        while (true) {
            System.out.println("1.Sign in , 2.Sign up , 0.Exit");
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            if (command == 1) {
                User user1 = SignInSignUp.SignIn();
                if (user1 == null) {
                    System.out.println("Wrong login or password!");
                } else {
                    if (user1.getRole().equals(Role.ADMIN)) {
                        OpenAdminConsole.openAdminConsole();
                    } else if (user1.getRole().equals(Role.MANAGER)) {
                        OpenManagerConsole.openManagerConsole(user1);
                    } else if (user1.getRole().equals(Role.USER)) {
                        OpenUserConsole.openUserConsole(user1);
                    }
                }
            } else if (command == 2) {
                SignInSignUp.SignUp();
            } else if (command == 0) {
                break;
            }
        }
    }
}
