package com.teachmeskills.service;

import com.teachmeskills.model.User;
import com.teachmeskills.model.dto.UserRequestDto;
import com.teachmeskills.repository.SecurityRepository;
import com.teachmeskills.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final SecurityRepository securityRepository;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository, SecurityRepository securityRepository) {
        this.userRepository = userRepository;
        this.securityRepository = securityRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public Boolean deleteUser(Long id){
        if (securityRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        logger.info("User is not deleted with ID -> {}", id);
        return false;
    }

    public Optional<User> updateUser(User user){
        return Optional.of(userRepository.save(user));
    }

    public Boolean createUser(User user){
        user.setIsDeleted(false);
        try {
            userRepository.save(user);
        }catch (Exception e){
            logger.error("User is not created -> {}", e.getMessage());
            return false;
        }
        return true;
    }

}
