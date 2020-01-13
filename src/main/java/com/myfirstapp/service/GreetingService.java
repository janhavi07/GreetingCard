package com.myfirstapp.service;

import com.myfirstapp.model.Greeting;
import com.myfirstapp.model.User;
import com.myfirstapp.repository.GreetingRepository;
import com.myfirstapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    private static String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message=String.format(template,(user.toString().isEmpty()) ? "HELLO WORLD" :user.toString());
        long l = counter.incrementAndGet();
        Greeting greeting = new Greeting(l, message);
        user.setUserId(l);
        user.addGreetings(greeting);
        userRepository.save(user);
        return greetingRepository.save(greeting);
    }

    @Override
    public Greeting getById(long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public List<Greeting> getList() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting getEditMessage(long id, String fname, String lname) {
        User user=new User();
        user.setFname(fname);
        user.setLname(lname);
        Optional<Greeting> greeting = greetingRepository.findById(id);
        if (greeting.isPresent()) {
            String message=String.format(template,user.toString());
            greeting.get().setMessage(message);
            greetingRepository.save(greeting.get());
            return greeting.get();
        }
        return null;
    }

    @Override
    public List<Greeting> getUpdatedList(long id) {
        greetingRepository.deleteById(id);
        return greetingRepository.findAll();
    }

    @Override
    public List<Greeting> getUpdatedList(String fname) {
        List<Greeting> all = greetingRepository.findAll();
        Greeting greeting1 = all.stream()
                .filter(greeting -> greeting.getMessage().contains(fname))
                .findFirst()
                .get();
        greetingRepository.delete(greeting1);
        return greetingRepository.findAll();
    }
}
