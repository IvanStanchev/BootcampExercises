package com.example.springsecuritytutorial.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable("id") int id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getById(id));
    }

    @GetMapping("/{email}")
    public ResponseEntity getUser(@PathVariable("email") String email) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.getByEmail(email));
    }

    @PostMapping
    public ResponseEntity<AddUserResponse> addUser(@RequestBody AddUserRequest request) {
        AddUserResponse userResponse = userService.addUser(request);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

}
