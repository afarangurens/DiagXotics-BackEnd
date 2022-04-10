package com.afas.diagxotics.API;
import com.afas.diagxotics.model.User;
import com.afas.diagxotics.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @PostMapping
    public void AddPerson(@RequestBody User user){
        userService.addUser(user);
    }   

    @GetMapping
    public List<User> getAllPeople(){
        return userService.getAllPeople();
    }
}
