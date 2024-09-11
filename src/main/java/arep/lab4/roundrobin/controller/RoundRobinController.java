package arep.lab4.roundrobin.controller;

import arep.lab4.roundrobin.model.Message;
import arep.lab4.roundrobin.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1/roundrobin")
public class RoundRobinController{

    private MessageService messageService;

    @Autowired
    public RoundRobinController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String index(){
        return "RoundRobin";
    }

    @PostMapping
    public ResponseEntity<List<Message>> saveAndGetList(@RequestBody String message){
        messageService.createMessage(message);
        List<Message> updatedMessages = messageService.saveMessage();
        return ResponseEntity.ok(updatedMessages);
    }

}
