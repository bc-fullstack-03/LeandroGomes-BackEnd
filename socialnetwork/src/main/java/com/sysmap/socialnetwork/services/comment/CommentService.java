package com.sysmap.socialnetwork.services.comment;

import com.sysmap.socialnetwork.entities.Comment;
import com.sysmap.socialnetwork.services.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private PostService _postService;

    public String createComment(CreateCommentRequest request) {
        var comment = new Comment(request.postId, request.userId, request.content);
        _postService.addComments(request.postId, comment);

        return comment.getId().toString();
    }
}