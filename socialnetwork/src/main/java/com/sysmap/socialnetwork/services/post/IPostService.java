package com.sysmap.socialnetwork.services.post;

import java.util.UUID;

public interface IPostService {
    String createPost(CreatePostRequest request);
    PostResponse findPostById(UUID id);

}

