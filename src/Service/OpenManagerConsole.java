package Service;

import Enums.Status;
import Model.*;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.stream.Stream;

import static Storage.Storage.*;

public class OpenManagerConsole {
    public static void openManagerConsole(User user) {
        Scanner scanner = new Scanner(System.in);
        Coworking coworking = null;
        while (true) {
            System.out.println("================================== \n 1.My coworking Center \n 2.Add rooms to coworking \n 3.Places in the room \n 0.Exit \n==================================");
            int command = scanner.nextInt();
            if (command == 1) {
                SeeMyCoworkingList(user);
                System.out.println("Enter Id: ");
                scanner = new Scanner(System.in);
                int command1 = scanner.nextInt();
                coworking = coworkingList.get(command1);
            } else if (command == 2) {
                AddRoomToCoworking(coworking);
            } else if (command == 3) {
                PlaceInTheRoom(coworking);
            } else if (command == 0) {
                break;
            } else {
                System.err.println("Wrong command!");
            }
        }

    }

    private static void PlaceInTheRoom(Coworking coworking) {
        for (Room room : rooms) {
            if (room.getCoworking().equals(coworking)) {
                System.out.println("ID: " + room.getId() +
                        "\n Name: " + room.getName() +
                        "\n Number of places: " + room.getNumberOfPlaces() +
                        "=============================");
            }
        }
        System.out.print("Enter Id of the room: ");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        Room room = rooms.get(command);
        for (Place place : places) {
            if (place.getRoom().equals(room)) {
                System.out.println("ID: " + place.getId()
                        + "\n Number of the place: " + place.getPlaceNumber() +
                        "\n Status: " + place.getStatus()+
                        "==================================");
            }
        }
    }

    static int id = 0;

    private static void AddRoomToCoworking(Coworking coworking) {
        Scanner scanner = new Scanner(System.in);
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Floor number: ");
            int floorNumber = scanner.nextInt();
            System.out.print("Number of places: ");
            int numberOfPlaces = scanner.nextInt();
            System.out.print("Price per place: ");
            double price = scanner.nextDouble();
            Room room = new Room(id, name, coworking, floorNumber, numberOfPlaces, BigDecimal.valueOf(price));
            rooms.add(room);
            Room room1 = rooms.get(id);
            id++;
            for (int i = 1; i <= numberOfPlaces; i++) {
                Place place = new Place(i - 1, room1, BigDecimal.valueOf(price), i, Status.AVALIABLE);
                places.add(place);
            }
    }

    public static void SeeMyCoworkingList(User user) {
        Stream<Coworking> coworkingStream = coworkingManagerList.stream().filter(coworkingManager -> coworkingManager.getUser().equals(user)).map(CoworkingManager::getCoworking);
        coworkingStream.forEach(coworking -> System.out.println("ID: " + coworking.getId() + "\n Name: " + coworking.getName() + "\nAddress: " + coworking.getAddress()));
    }
}
