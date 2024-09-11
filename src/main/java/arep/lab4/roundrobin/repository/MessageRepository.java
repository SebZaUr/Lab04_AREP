package arep.lab4.roundrobin.repository;

import arep.lab4.roundrobin.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message,Integer> {
}
