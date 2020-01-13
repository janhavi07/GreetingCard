package com.myfirstapp;

import com.myfirstapp.model.Greeting;
import com.myfirstapp.model.User;
import com.myfirstapp.repository.GreetingRepository;
import com.myfirstapp.service.GreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.mockito.Mockito.mock;

@SpringBootTest
class MyFirstAppApplicationTests {
    private static String template = "Hello, %s!";
    GreetingService greetingService ;
    @Mock
    private GreetingRepository greetingRepository;

    @BeforeEach
    void setUp() {
        this.greetingRepository=mock(GreetingRepository.class);
    }

    @Test
    void givenFirstNameAndLastName_ThenAddGreeting() {
        User user = new User();
        user.setUserId(1);
        user.setFname("jan");
        user.setLname("pan");
        String message=String.format(template,(user.toString().isEmpty()) ? "HELLO WORLD" :user.toString());
        Greeting expectedGreeting = new Greeting(1, message);
        Greeting actualGreeting = greetingService.addGreeting(user);
        boolean equals = expectedGreeting.equals(actualGreeting);
        Assert.isTrue(equals);
    }

}
