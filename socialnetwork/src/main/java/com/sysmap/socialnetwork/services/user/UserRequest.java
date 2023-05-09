package com.sysmap.socialnetwork.services.user;

import lombok.Data;

@Data
public class UserRequest {
    public String name;
    public String email;
    public String password;
}
