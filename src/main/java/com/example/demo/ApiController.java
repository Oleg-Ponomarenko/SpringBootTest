package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ApiController {

    ArrayList<String> messages = new ArrayList<>();

    ArrayList<User> users = new ArrayList<>();


    //----------------------------------------------------------------------------------------------------------------------------------------------------------------

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

    //curl -X POST http://localhost:8080/messages/1/create -H 'Content-Type:
    //text/plain' -d 'text'
    @PostMapping("messages/{index}/create")
    public void insertMessage(@PathVariable("index") Integer i, @RequestBody String message) {
        messages.add(i, message);
    }

    //curl -X DELETE http://localhost:8080/messages/search/text1
    @DeleteMapping("messages/search/{text}")
    public void deleteMessages(@PathVariable("text") String text) {
        messages.removeIf(t -> t.contains(text));
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping("users")
    public ArrayList<User> getUsers() {
        return users;
    }

    @GetMapping("users/{index}")
    public User getUsers(@PathVariable("index") Integer i) {
        return users.get(i);
    }

    //curl -X POST http://localhost:8080/users -H 'Content-Type:
    //application/json' -d User("Oleg", 17)
    @PostMapping("users")
    public void createUser(@RequestBody User user) {
        users.add(user);
    }

    //curl -X DELETE http://localhost:8080/users/1
    @DeleteMapping("users/{index}")
    public void deleteUser(@PathVariable("index") Integer i) {
        users.remove((int)i);
    }

    //curl -X PUT http://localhost:8080/users/1 -H 'Content-Type:
    //application/json' -d 20
    @PutMapping("users/{index}")
    public void updateMessage(@PathVariable("index") Integer i, @RequestBody Integer newAge) {
        users.get(i).setAge(newAge);
    }
}

