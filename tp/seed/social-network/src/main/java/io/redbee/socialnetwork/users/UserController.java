package io.redbee.socialnetwork.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * @author Joaco Campero
 * <p>
 * created at 6/9/21
 */
@RestController

@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> findAllUsers() {
        return userService.get();

    }

    @PostMapping()
    public void createUser(@RequestBody User user) {
        userService.createUser(user);

    }

    @GetMapping("/{id}")
    public User getById(@RequestBody User user, @PathVariable Integer id){
        userService.findById(id);
        return user;
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody User user) {

        userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        this.userService.deleteUser(id);


    }



}
