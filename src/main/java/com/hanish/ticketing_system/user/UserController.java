package com.hanish.ticketing_system.user;

import com.hanish.ticketing_system.user.dto.AddUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("addUser")
    public User createUser(@RequestBody AddUserRequest request){
        return userService.addUser(request);
    }
}
