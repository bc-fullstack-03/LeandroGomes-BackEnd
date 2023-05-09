package com.sysmap.socialnetwork.api;

import com.sysmap.socialnetwork.services.security.IJwtService;
import com.sysmap.socialnetwork.services.user.IUserService;
import com.sysmap.socialnetwork.services.user.UserRequest;
import com.sysmap.socialnetwork.services.user.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserService _userService;

    @Autowired
    private IJwtService _jwtService;

    @PostMapping("create")
    public ResponseEntity<String> createUser(@RequestBody UserRequest request) {
        var response = _userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<UserResponse> getUser(String email) {
        return ResponseEntity.ok().body(_userService.findUserByEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(String userId) {
        var response = _userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PostMapping("/photo/upload")
    public ResponseEntity uploadPhotoProfile(@RequestParam("photo") MultipartFile photo) {
        try {
            _userService.uploadPhotoProfile(photo);

            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}