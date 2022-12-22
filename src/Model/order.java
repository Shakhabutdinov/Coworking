package Model;

import java.math.BigDecimal;

public class order {
    private int id;
    private User user;
    private Place place;
    private BigDecimal sum;
    private String dateFrom;
    private String dateTo;

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public order(int id, User user, Place place, BigDecimal sum, String date, String dateTo) {
        this.id = id;
        this.user = user;
        this.place = place;
        this.sum = sum;
        this.dateFrom = date;
        this.dateTo = dateTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }
}
