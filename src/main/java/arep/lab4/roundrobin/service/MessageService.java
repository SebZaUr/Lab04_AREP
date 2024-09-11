package arep.lab4.roundrobin.service;

import arep.lab4.roundrobin.model.Message;
import arep.lab4.roundrobin.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
        messageRepository.deleteAll();
    }

    public List<Message> saveMessage( ){
        List<Message> list = messageRepository.findAll();
        list.sort((m1, m2) -> m2.getId().compareTo(m1.getId()));
        return list.stream().limit(10).collect(Collectors.toList());
    }

    public void createMessage(String message){
        Message mensaje = new Message(messageRepository.findAll().size()+1,message);
        messageRepository.save(mensaje);
    }
}
