package service;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService implements BaseService {
    static List<User> users = new ArrayList<>();

    public User login(String phoneNumber, String password) {
        for (User user : users) {
            if (user != null) {
                if (user.getPhoneNumber().equals(phoneNumber) && user.getPassword().equals(password)) {
                    return user;
                }
            }
        }
        System.out.println("---INCORRECT PASSWORD OR NUMBER---");
        return null;
    }

    public void add(User user) {
        for (User user1 : users) {
            if (user1.getPhoneNumber().equals(user.getPhoneNumber())) {
                System.out.println("---THIS NUMBER ALREADY REGISTERED---");
                return;
            }
        }
        users.add(user);
        System.out.println("---SUCCESSFULLY REGISTERED---");
    }

    public String getNameById(int userId) {
        for (User user : users) {
            if (user != null) {
                if (user.getId() == userId) {
                    return user.getName();
                }
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        for (User user : users) {
            if (user != null) {
                if (user.getId() == id) {
                    users.remove(user);
                    System.out.println("---SUCCESSFULLY DELETED---");
                    return;
                }
            }
        }
        System.out.println("---SMTH FALSE NOT DELETED---");
    }

    @Override
    public Object getById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
