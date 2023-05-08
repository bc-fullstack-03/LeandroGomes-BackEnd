package com.sysmap.socialnetwork.services.authentication;


public interface IAuthenticationService {
    AuthenticateResponse authenticate(AuthenticateRequest request) throws Exception;
}
