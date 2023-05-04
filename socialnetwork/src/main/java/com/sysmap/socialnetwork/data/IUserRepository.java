package com.sysmap.socialnetwork.data;

import com.sysmap.socialnetwork.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface IUserRepository extends MongoRepository<User, UUID> {

}
