package com.myfirstapp.controller;

import com.myfirstapp.model.Greeting;
import com.myfirstapp.model.User;
import com.myfirstapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Welcome")
public class GreetingController {

    @Autowired
    IGreetingService greetingService;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name,@RequestParam(value = "lname") String lname) {
        User user=new User();
        user.setFname(name);
        user.setLname(lname);
        return greetingService.addGreeting(user);
    }

    @GetMapping("/find")
    public Greeting getByIdGreeting(@RequestParam(value = "id") long id){
        return greetingService.getById(id);
    }

    @GetMapping("/list")
    public List<Greeting> getGreetingList(){
        return greetingService.getList();
    }

    @PutMapping("/edit/{id}")
    public Greeting getEditedMessage(@PathVariable long id,@RequestParam(value = "fname") String fname,@RequestParam(value = "lname") String lname){
        return greetingService.getEditMessage(id,fname,lname);
    }

    @DeleteMapping("/delete/{id}")
    public List<Greeting> getUpdatedList(@PathVariable long id){
        return greetingService.getUpdatedList(id);
    }

    @DeleteMapping("/deleteMessage/{fname}")
    public List<Greeting> getUpdatedList(@PathVariable String fname){
        return greetingService.getUpdatedList(fname);
    }

}
