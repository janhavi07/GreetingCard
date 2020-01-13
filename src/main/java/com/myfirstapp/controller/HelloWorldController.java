package com.myfirstapp.controller;

import com.myfirstapp.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    @RequestMapping(value = {"", "/", "/home"})
    public String sayHello() {
        return "Hello World!! :)";
    }

    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name") String name) {
        return "Hello" + name + "!";
    }

    @RequestMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name) {
        return "Hey" + name + ":)";
    }

    @PostMapping("/post")
    public String sayHello(@RequestBody User user) {
        return "Hey " + user.getFirstName() + " " + user.getLastName() + "!";
    }

    @PutMapping("/put/{firstName}")
    public String sayHello(@PathVariable String firstName, @RequestParam(value = "lastname") String lastName) {
        return "HeyHi" + firstName + " " + lastName + "!";
    }
}
