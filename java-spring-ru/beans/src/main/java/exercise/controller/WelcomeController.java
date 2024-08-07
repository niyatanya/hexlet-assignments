package exercise.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

// BEGIN
import org.springframework.beans.factory.annotation.Autowired;
import exercise.daytime.Daytime;

@RestController
public class WelcomeController {

    @Autowired
    private Daytime dayTime;

    @GetMapping(path = "/welcome")
    public String welcome() {
        return "It is " + dayTime.getName() + "now! Welcome to Spring!";
    }
}
// END
