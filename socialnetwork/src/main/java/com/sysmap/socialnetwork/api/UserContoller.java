package com.sysmap.socialnetwork.api;

import com.sysmap.socialnetwork.services.user.CreateUserRequest;
import com.sysmap.socialnetwork.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserContoller {
    @Autowired
    private IUserService _userService;
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest request){
        if (request.name.length() < 3){
            return ResponseEntity.unprocessableEntity().body("Invalid user");
        }
        var response = _userService.createUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
