package project.noteapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import project.noteapp.bean.User;
import project.noteapp.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("api/user/{cod_user}")
    public @ResponseBody ResponseEntity<?> getUser(@PathVariable String cod_user) {
        try {
            return new ResponseEntity<User>(userService.getUser(cod_user), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
