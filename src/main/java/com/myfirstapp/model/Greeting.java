package com.myfirstapp.model;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "GREETINGS")
public class Greeting {

    @Id
    @Column(name = "greetingCount")
    public long counter;
    private String message;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Greeting() {
    }

    public Greeting(long counter, String message) {
        this.counter = counter;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCounter() {
        return counter;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
