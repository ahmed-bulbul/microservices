package com.lcwd.services.impl;

import com.lcwd.constant.ApplicationConstant;
import com.lcwd.entity.User;
import com.lcwd.exception.ResourceNotFoundException;
import com.lcwd.repositories.UserRepository;
import com.lcwd.services.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User saveUser(User user) {
        // generate unique userid
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(()
                -> new ResourceNotFoundException(ApplicationConstant.USER_NOT_FOUND + userId));
    }

    @Override
    public User updateUser(String userId, User user) {
        User existingUser = userRepository.findById(userId).orElseThrow(()
                -> new ResourceNotFoundException(ApplicationConstant.USER_NOT_FOUND + userId));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAbout(user.getAbout());
        return userRepository.save(existingUser);
    }


    @Override
    public void deleteUser(String userId) {

        User existingUser = userRepository.findById(userId).orElseThrow(()
                -> new ResourceNotFoundException(ApplicationConstant.USER_NOT_FOUND + userId));
        userRepository.delete(existingUser);

    }
}
