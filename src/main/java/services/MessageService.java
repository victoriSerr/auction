package services;

import models.Message;
import repositories.MessageRepository;

import java.util.List;

public class MessageService {
    private ConnectBd connectBd = new ConnectBd();

    public List<Message> findAll(Long id) {
        return connectBd.messageRepository.findAllMessages(id);
    }

    public void save(Message message) {
        connectBd.messageRepository.save(message);
    }
}
