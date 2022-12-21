package Model;

public class CoworkingManager {
    private int id;
    private Coworking coworking;

    public CoworkingManager(int id, Coworking coworking, User user) {
        this.id = id;
        this.coworking = coworking;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Coworking getCoworking() {
        return coworking;
    }


    public void setCoworking(Coworking coworking) {
        this.coworking = coworking;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    private User user;

}
