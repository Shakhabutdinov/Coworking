package Service;

import Enums.Status;
import Model.*;

import java.math.BigDecimal;
import java.util.Scanner;

import static Storage.Storage.*;

public class OpenUserConsole {
    public static void openUserConsole(User user) {
        while (true) {
            System.out.println("============================");
            System.out.println("1.Book place \n 2.My booked places \n 3.My Balance \n 0.exit");
            System.out.println("============================");
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            if (command == 1) {
                BookPlace(user);
            } else if (command == 2) {
                MyBookedPlaces(user);
            } else if (command==3) {
                System.out.println(user.getBalance());
            } else if (command == 0) {
                break;
            }
        }
    }

    private static void MyBookedPlaces(User user) {
        for (Model.order order : orders) {
            if (order.getUser().equals(user)) {
                System.out.println("Place: " + order.getPlace() + "\n Price: " + order.getSum() + "\n From: " + order.getDateFrom() + "\n To : " + order.getDateTo());
            }
        }
    }
static int id=0;
    private static void BookPlace(User user) {
        System.out.println("Coworking list: ");
        System.out.println("================================");
        for (Model.Coworking coworking : coworkingList) {
            System.out.println("ID: " + coworking.getId() + "\n Name: " + coworking.getName() + "\n Address: " + coworking.getAddress());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID: ");
        int command = scanner.nextInt();
        Coworking coworking = coworkingList.get(command);
        for (Model.Room room : rooms) {
            if (room.getCoworking().equals(coworking)) {
                System.out.println("ID: " + room.getId() + "\n Name: " + room.getName() + "\n Floor: " + room.getFloorNumber() + "\n Number of places : " + room.getNumberOfPlaces()+"===============================");
            }
        }
        System.out.print("Enter ID of the room: ");
        int idOfTheRoom = scanner.nextInt();
        Room room = rooms.get(idOfTheRoom);
        for (Model.Place place : places) {
            if (place.getRoom().equals(room) && place.getStatus().equals(Status.AVALIABLE)) {
                System.out.println("ID: " + place.getId() + "\n Number: " + place.getPlaceNumber() + "\n Price: " + place.getPrice()+"=================================");
            }
        }
        System.out.print("Enter id: ");
        int idOfThePlace = scanner.nextInt();
        Place place = places.get(idOfThePlace);
        System.out.println("Date from: ");
        scanner = new Scanner(System.in);
        String dateFrom = scanner.nextLine();
        System.out.println("Date to: ");
        String dateTo = scanner.nextLine();
        place.setStatus(Status.BOOKED);
        order order = new order(id,user,place,place.getPrice(),dateFrom,dateTo);
        orders.add(order);
        BigDecimal balance = user.getBalance();
        BigDecimal a;
        a = balance.subtract(place.getPrice());
        user.setBalance(a);
        id++;
    }
}
