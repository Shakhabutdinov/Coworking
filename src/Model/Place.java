package Model;


import java.math.BigDecimal;

public class Place {
    private int id;
    private Room room;
    private BigDecimal price;
    private int placeNumber;

    public Place(int id, Room room, BigDecimal price, int placeNumber, Enum status) {
        this.id = id;
        this.room = room;
        this.price = price;
        this.placeNumber = placeNumber;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    private Enum status;

}
