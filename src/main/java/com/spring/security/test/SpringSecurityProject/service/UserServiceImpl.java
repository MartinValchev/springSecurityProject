package com.spring.security.test.SpringSecurityProject.service;

import com.spring.security.test.SpringSecurityProject.config.Errors;
import com.spring.security.test.SpringSecurityProject.entities.User;
import com.spring.security.test.SpringSecurityProject.models.RegistrationModel;
import com.spring.security.test.SpringSecurityProject.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(RegistrationModel registrationModel) {
        User user = this.modelMapper.map(registrationModel, User.class);
        String ecryptedPassowrd = this.bCryptPasswordEncoder.encode(registrationModel.getPassword());
        user.setPassword(ecryptedPassowrd);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findOneByUsername(username);
        if(user ==null){
            throw new UsernameNotFoundException(Errors.INVALID_CREDENTIALS);
        }
        return user;
    }
}
