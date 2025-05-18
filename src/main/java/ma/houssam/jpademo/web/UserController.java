package ma.houssam.jpademo.web;

import ma.houssam.jpademo.entities.User;
import ma.houssam.jpademo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Marks this class as a REST controller, allowing it to handle HTTP requests
@RestController
public class UserController {

    // Injects the UserService dependency
    @Autowired
    UserService userService;

    // Handles GET requests to /users/{username}
    // @param username the username to search for
    // @return the User object matching the given username
    @GetMapping("/users/{username}")
    public User user(@PathVariable String username) {
        return userService.findUserByUserName(username);
    }
}
