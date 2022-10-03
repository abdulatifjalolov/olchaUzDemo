package model;

public class User extends Base {
    private String phoneNumber;
    private String password;
    private String role;

    public User(String role, String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public User() {

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
