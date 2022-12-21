package Model;

import java.math.BigDecimal;

public class User {
    private String name;
    private String login;
    private String password;
    private int id;
    private Enum role;
    private BigDecimal balance;

    public User(String name, String login, String password, int id, Enum role, BigDecimal balance) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.id = id;
        this.role = role;
        this.balance = balance;
    }

    public Enum getRole() {
        return role;
    }

    public void setRole(Enum role) {
        this.role = role;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
