package com.twitterclone;


import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@RestController
public class MessagesResource {

  private MessagesRepository messagesRepository;


    public MessagesResource(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    //get all messages
    @GetMapping("/messages")
    public List<Messages> getAllMessages(){
        return messagesRepository.findAll();
    }

    //get specific message
    @GetMapping(path = "/messages/{identity}")
    public Messages getMessage(@PathVariable("identity") Integer id) {

            return messagesRepository.findById(id).get();
    }

    //post a message
    @PostMapping("/create-messages/")
    public Messages createMessage(@RequestBody Map<String, String> body){
        String content = body.get("content");
        Integer producerID = Integer.parseInt(body.get("producerID"));
        Messages newMessage = new Messages(content, producerID);
        return messagesRepository.save(newMessage);
    }

    //delete message
    @DeleteMapping("/delete/{id}")
    public boolean deleteMesssage(@PathVariable("id") Integer id) {
        if(messagesRepository.findById(id).equals(Optional.empty())) {
            return false;
        }
        messagesRepository.deleteById(id);
        return true;
    }
}
