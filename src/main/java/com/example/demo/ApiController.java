package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ApiController {

    ArrayList<String> messages = new ArrayList<>();

    @GetMapping("messages")
    public ArrayList<String> getMessage() {
        return messages;
    }

    //curl -X POST http://localhost:8080/messages -H 'Content-Type:
    //text/plain' -d 'text'
    @PostMapping("messages")
    public void createMessage(@RequestBody String message) {
        messages.add(message);
    }

    @GetMapping("messages/{index}")
    public String getMessage(@PathVariable("index") Integer i) {
        return messages.get(i);
    }

    //curl -X DELETE http://localhost:8080/messages/1
    @DeleteMapping("messages/{index}")
    public void deleteMessage(@PathVariable("index") Integer i) {
        messages.remove((int)i);
    }

    //curl -X PUT http://localhost:8080/messages/1 -H 'Content-Type:
    //text/plain' -d 'text'
    @PutMapping("messages/{index}")
    public void updateMessage(@PathVariable("index") Integer i, @RequestBody String message) {
        messages.remove((int)i);
        messages.add(i, message);
    }

    @GetMapping("messages/search/{index}")
    public int findMessage(@PathVariable("index") String i) {
        return messages.indexOf(i);
    }

    @GetMapping("messages/count")
    public int countMessages() {
        return messages.toArray().length;
    }

    /* @PostMapping("messages/{index}/create")
    public void insertMessage(@PathVariable("index") String i, @RequestBody String message) {
        messages.ins(message);
    } */
}

