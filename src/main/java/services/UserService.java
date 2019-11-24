package services;

import dto.MessageDto;
import models.Message;
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

    public User findUserById (Long id ){
        return connectBd.userRepository.find(id).get();
    }

    public MessageDto from(Message message) {
        return new MessageDto(findUserById(message.getFromUserId()).getLogin(), findUserById(message.getToUserId()).getLogin(), message.getMessage());
    }
}
