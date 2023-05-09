package com.sysmap.socialnetwork.services.post;

import com.sysmap.socialnetwork.entities.Comment;
import lombok.Data;

import java.util.UUID;

@Data
public class AddCommentRequest {
    public UUID postId;
    public Comment comment;
}
