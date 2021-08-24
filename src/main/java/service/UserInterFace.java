package service;

import model.User;

import java.util.List;

public interface UserInterFace {
    List<User> showAll();

    List<User> showAllAscName();

    void create(User user);

    void update(int id,User user);

    void remove(int id);

    User findById(int id);

    User findByCountry(String country);

}