package pers.machimedes.DataNavi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.machimedes.DataNavi.model.User;
import pers.machimedes.DataNavi.service.UserService;
import pers.machimedes.DataNavi.util.BCryptPasswordEncoderUtil;
import pers.machimedes.DataNavi.util.ResultWrap;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public ResultWrap<User> createUser(@RequestBody User user) throws Exception {
        return userService.createUser(user);

    }

    @DeleteMapping("/id={id}")
    public void deleteUser(@RequestBody String user) throws Exception {
    }

    @PutMapping("/id={id}")
    public void updateUser(@RequestBody String user) throws Exception {
    }

    @GetMapping("/id={id}")
    public void queryUser(@RequestBody String user) throws Exception {
    }

    @GetMapping()
    public void queryUsers(@RequestBody String user) throws Exception {
    }
}
