package com.sysmap.socialnetwork.services.user;


import com.sysmap.socialnetwork.entities.User;

public interface IUserService {
    String createUser(CreateUserRequest request);

    FindUserResponse findUserByEmail(String email);
    User getUser(String email);


}
