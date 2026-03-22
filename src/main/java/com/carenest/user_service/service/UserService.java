package com.carenest.user_service.service;

import com.carenest.user_service.exception.DuplicateFieldException;
import com.carenest.user_service.model.entity.User;
import com.carenest.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User saveUser(User user){
        Map<String, String> errors = new HashMap<>();

        if(userRepository.existsByEmail(user.getEmail())){
            errors.put("email", "email already exists for user");
        }
        if(userRepository.existsByPhone1(user.getPhone1())){
            errors.put("phone1", "mobile number alrady exists for user");
        }
        if(!errors.isEmpty()){
            throw new DuplicateFieldException(errors);
        }
        return userRepository.save(user);

    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
}
