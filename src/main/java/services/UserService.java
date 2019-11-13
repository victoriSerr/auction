package services;

import models.User;

import java.util.List;

public class UserService {
    private ConnectBd connectBd = new ConnectBd();

    public void saveUser(User user) {
        connectBd.userRepository.save(user);
    }

    public boolean checkLogin(String login) {
        List<User> list = connectBd.userRepository.findAll();
        for(User user : list) {
            if (user.getLogin().equals(login))
                return true;
        }
        return false;
    }

    public User findUserByLogin (String login) {
        return connectBd.userRepository.findByLogin(login);
    }

}
