package com.sysmap.socialnetwork.api;

import com.sysmap.socialnetwork.services.authentication.AuthenticateRequest;
import com.sysmap.socialnetwork.services.authentication.AuthenticateResponse;
import com.sysmap.socialnetwork.services.authentication.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/authentication")
public class AuthenticationController {

    @Autowired
    private IAuthenticationService _autheticationService;
    @PostMapping
    public ResponseEntity<AuthenticateResponse> authenticate(@RequestBody AuthenticateRequest request) {

        try {
            return ResponseEntity.ok().body(_autheticationService.authenticate(request));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}