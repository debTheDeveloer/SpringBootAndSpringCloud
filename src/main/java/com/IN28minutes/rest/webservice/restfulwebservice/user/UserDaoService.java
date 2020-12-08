package com.IN28minutes.rest.webservice.restfulwebservice.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private int userID = 3;

    static {
        users.add(new User("Arka", 1, new Date()));
        users.add(new User("Debajyoti", 2, new Date()));
        users.add(new User("Sayan", 3, new Date()));
    }

    public List<User> findAllUsers() {
        return users;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    public User saveUser(User user) {
        if (user.getId() == null) {
            userID++;
            user.setId(userID);
        }
        users.add(user);
        return user;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
