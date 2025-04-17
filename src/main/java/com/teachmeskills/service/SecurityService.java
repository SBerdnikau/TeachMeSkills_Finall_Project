package com.teachmeskills.service;

import com.teachmeskills.exception.LoginUsedException;
import com.teachmeskills.model.Role;
import com.teachmeskills.model.User;
import com.teachmeskills.model.dto.RegistrationRequestDto;
import com.teachmeskills.repository.SecurityRepository;
import com.teachmeskills.repository.UserRepository;
import com.teachmeskills.model.Security;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityService {

    private final UserRepository userRepository;
    private final SecurityRepository securityRepository;
    private User user;
    private Security security;
    private final Logger logger = LoggerFactory.getLogger(SecurityService.class);

    @Autowired
    public SecurityService(UserRepository userRepository, SecurityRepository securityRepository, User user, Security security) {
        this.userRepository = userRepository;
        this.securityRepository = securityRepository;
        this.user = user;
        this.security = security;
    }

    public Optional<Security> getSecurityById(Long id){
        return securityRepository.findById(id);
    }

    public Optional<User> registration(RegistrationRequestDto registrationRequestDto) throws LoginUsedException {
        if(securityRepository.existsByLogin(registrationRequestDto.getLogin())){
            throw new LoginUsedException(registrationRequestDto.getLogin());
        }

        user.setFirstName(registrationRequestDto.getFirstname());
        user.setLastName(registrationRequestDto.getSecondName());
        user.setTelephoneNumber(registrationRequestDto.getTelephoneNumber());
        user.setEmail(registrationRequestDto.getEmail());
        user.setIsDeleted(false);
        User updatedUser = userRepository.save(user);

        security.setLogin(registrationRequestDto.getLogin());
        security.setPassword(registrationRequestDto.getPassword());
        security.setRole(Role.USER);
        security.setUser(updatedUser);
        securityRepository.save(security);

        return Optional.of(updatedUser);
    }

}
