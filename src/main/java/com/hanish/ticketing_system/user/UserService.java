package com.hanish.ticketing_system.user;

import com.hanish.ticketing_system.user.dto.AddUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User addUser(AddUserRequest request){
        User user = User.builder()
                .name(request.name())
                .email(request.email())
                .build();

        return userRepository.save(user);
    }
}
