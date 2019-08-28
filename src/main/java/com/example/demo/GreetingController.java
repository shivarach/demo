package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greetings/2")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/greetings")
    public List<Greeting> greetings(@RequestParam(value="name", defaultValue="World") String name) {
        Greeting greeting = new Greeting(counter.incrementAndGet(),
                String.format(template, name));
        Greeting secondGreeting = new Greeting(counter.incrementAndGet(),
                String.format(template, "World Again"));
        return Arrays.asList(greeting, secondGreeting);
    }
}
