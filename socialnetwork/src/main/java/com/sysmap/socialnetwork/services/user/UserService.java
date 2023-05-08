package com.sysmap.socialnetwork.services.user;

import com.sysmap.socialnetwork.data.IUserRepository;
import com.sysmap.socialnetwork.entities.User;
import com.sysmap.socialnetwork.services.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository _userRepository;
    @Autowired
    private IEventService _eventService;

    public String createUser(CreateUserRequest request) {

        var user = new User(request.name, request.email, request.password);

        _userRepository.save(user);
        _eventService.send(user.getId().toString());

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


