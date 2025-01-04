package com.swetha.userregistration.service;

import com.swetha.userregistration.dto.UserRequest;
import com.swetha.userregistration.dto.UserResponse;
import com.swetha.userregistration.model.User;
import com.swetha.userregistration.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public UserResponse registerUser(UserRequest userRequest) {
        User user = User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .build();
        try {
            if(user.getName().length() == 0) throw new NullPointerException("User Name is Null");
            else if(user.getEmail().length() == 0) throw new NullPointerException("User Email is Null");
            else if(user.getPassword().length() == 0) throw new NullPointerException("Password should not be empty");
            else {
                this.userRepository.save(user);
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return this.userRequestToResponse(userRequest);
    }

    private UserResponse userRequestToResponse(UserRequest userRequest) {
        UserResponse userResponse = new UserResponse().builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .success(true)
                .build();
        return userResponse;
    }
}
