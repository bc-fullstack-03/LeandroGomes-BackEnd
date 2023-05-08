package com.sysmap.socialnetwork.services.user;

import com.sysmap.socialnetwork.data.IUserRepository;
import com.sysmap.socialnetwork.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository _userRepository;
    @Autowired
    private PasswordEncoder _passwordEncoder;


    public String createUser(CreateUserRequest request) {
        var user = new User(request.name, request.email);

        if(!_userRepository.findUserByEmail(request.email).isEmpty()){
            return null;
        }

        var hash = _passwordEncoder.encode(request.password);
        user.setPassword(hash);
        _userRepository.save(user);
        return user.getId().toString();
    }

    public FindUserResponse findUserByEmail(String email) {
        var user = _userRepository.findUserByEmail(email).get();

        var response = new FindUserResponse(user.getId(), user.getName(), user.getEmail());

        return response;
    }

    public User getUser(String email) {

        return _userRepository.findUserByEmail(email).get();
    }
}


