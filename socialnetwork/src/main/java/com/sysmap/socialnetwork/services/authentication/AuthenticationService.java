package com.sysmap.socialnetwork.services.authentication;

import com.sysmap.socialnetwork.services.security.IJwtService;
import com.sysmap.socialnetwork.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    private IUserService _userService;
    @Autowired
    private IJwtService _jwtService;


    public AuthenticateResponse authenticate(AuthenticateRequest request) throws Exception {
        var user = _userService.getUser(request.email);

        if(user == null){
            return null;
        }

        if(user.getPassword().equals(request.password)){
            throw new Exception("Senha inválida!");
        }

        var token =  _jwtService.generateToken(user.getId());
        var response = new AuthenticateResponse();

        response.setUserId(user.getId());
        response.setToken(token);

        return response;
    }
}
