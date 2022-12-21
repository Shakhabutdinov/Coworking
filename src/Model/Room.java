package Model;

import java.math.BigDecimal;

public class Room {
    private int id;
    private String name;

    public Room(int id, String name, Coworking coworking, int floorNumber, int numberOfPlaces, BigDecimal pricePerPlace) {
        this.id = id;
        this.name = name;
        this.coworking = coworking;
        this.floorNumber = floorNumber;
        this.numberOfPlaces = numberOfPlaces;
        this.pricePerPlace = pricePerPlace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coworking getCoworking() {
        return coworking;
    }

    public void setCoworking(Coworking coworking) {
        this.coworking = coworking;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public BigDecimal getPricePerPlace() {
        return pricePerPlace;
    }

    public void setPricePerPlace(BigDecimal pricePerPlace) {
        this.pricePerPlace = pricePerPlace;
    }

    private Coworking coworking;
    private int floorNumber;
    private int numberOfPlaces;
    private BigDecimal pricePerPlace;

}
