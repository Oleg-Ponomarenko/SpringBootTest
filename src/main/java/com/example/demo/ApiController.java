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

    @PostMapping("messages")
    public void createMessage(@RequestBody String message) {
        messages.add(message);
    }

    @GetMapping("messages/{index}")
    public String getMessage(@PathVariable("index") Integer i) {
        return messages.get(i);
    }

    @DeleteMapping("messages/{index}")
    public void deleteMessage(@PathVariable("index") Integer i) {
        messages.remove(i);
    }

    @PutMapping("messages/{index}")
    public void updateMessage(@PathVariable("index") Integer i, @RequestBody String message) {
        messages.remove(i);
        messages.add(i, message);
    }
}

