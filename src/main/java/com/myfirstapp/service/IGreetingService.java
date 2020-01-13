package com.myfirstapp.service;

import com.myfirstapp.model.Greeting;
import com.myfirstapp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IGreetingService {
    Greeting addGreeting(User user);

    Greeting getById(long id);

    List<Greeting> getList();

    Greeting getEditMessage(long id, String fname, String lname);

    List<Greeting> getUpdatedList(long id);

    List<Greeting> getUpdatedList(String fname);
}
