package com.sysmap.socialnetwork.services.user;


import com.sysmap.socialnetwork.entities.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface IUserService {
    String createUser(UserRequest request);
    UserResponse findUserByEmail(String email);
    User getUser(String email);
    User getUserById(UUID userId);
    String deleteUser(String userId);

    void uploadPhotoProfile(MultipartFile photo) throws Exception;

}
