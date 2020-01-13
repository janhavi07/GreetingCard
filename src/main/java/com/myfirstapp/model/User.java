package com.myfirstapp.model;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class User {

    @Id
    @Column(name = "userId")
    public long userId;
    private String fname;
    private String lname;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @Column(name = "greet")
    private Set<Greeting> greetingSet;

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLastName() {
        return lname;
    }

    public void addGreetings(Greeting... greetings) {
        this.greetingSet = Stream.of(greetings).collect(Collectors.toSet());
        this.greetingSet.forEach(x -> x.setUser(this));
    }

    @Override
    public String toString() {
        return "" + fname + '\'' + lname + '\'';
    }
}
