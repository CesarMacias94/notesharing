package project.noteapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import project.noteapp.bean.UserDTO;
import project.noteapp.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("api/user/{cod_user}")
    public @ResponseBody ResponseEntity<?> getUser(@PathVariable String cod_user) {
        try {
            return new ResponseEntity<UserDTO>(userService.getUser(cod_user), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("api/users")
    public @ResponseBody ResponseEntity<?> getUsers() {
        try {
            return new ResponseEntity<List<UserDTO>>(userService.getUsers(), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "api/adduser", method= RequestMethod.POST)
    public @ResponseBody ResponseEntity<?> createUser(@RequestBody UserDTO user) {
        try {
            return new ResponseEntity<Integer>(userService.createUser(user), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
