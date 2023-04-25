package com.assaf.ChatAppSpring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }


    public UserDto signUp(UserModel userModel){
        String username = userModel.getUsername();
        String email = userModel.getEmail();
        String password = userModel.getPassword();

        checkUsernameExists(username);
        checkEmailAndPasswordExists(email,password);

        Optional<User> optionalUser = userRepository.findUserByEmail(email);
        if(optionalUser.isPresent())
            throw new ResponseStatusException(HttpStatus.IM_USED, "Email already in use.");

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        user = userRepository.save(user);
        return UserDto.toDto(user);
    }

    public UserDto login(UserModel userModel){
        String email = userModel.getEmail();
        String password = userModel.getPassword();

        checkEmailAndPasswordExists(email,password);

        Optional<User> optionalUser = userRepository.findUserByEmail(email);
        if(!optionalUser.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Email not found.");

        User user = optionalUser.get();
        boolean isPasswordRight = passwordEncoder.matches(password,user.getPassword());
        if(!isPasswordRight)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wrong password.");
        
        return UserDto.toDto(user);
    }

    private void checkUsernameExists(String username){
        if(username == null || username.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username can not be empty.");
    }

    private void checkEmailAndPasswordExists(String email,String password){
        if(email == null || email.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email can not be empty.");
        if(password == null || password.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password can not be empty.");
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
