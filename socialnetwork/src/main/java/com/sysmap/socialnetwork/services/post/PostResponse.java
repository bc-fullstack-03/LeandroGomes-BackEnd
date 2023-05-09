package com.sysmap.socialnetwork.services.post;

import java.util.UUID;

public class PostResponse {

    public UUID id;
    public String content;
    public Integer likes;
    public UUID userId;

    public PostResponse(UUID id, String content, Integer likes, UUID userId) {
        this.id = id;
        this.content = content;
        this.likes = likes;
        this.userId = userId;
    }
}