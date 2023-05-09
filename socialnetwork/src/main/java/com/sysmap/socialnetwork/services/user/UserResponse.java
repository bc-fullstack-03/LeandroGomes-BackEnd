package com.sysmap.socialnetwork.services.user;

import java.util.UUID;

public class UserResponse {
    public UUID id;
    public String name;
    public String email;
    public String photoUri;

    public UserResponse(UUID id, String name, String email, String photoUri) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.photoUri = photoUri;
    }
}
