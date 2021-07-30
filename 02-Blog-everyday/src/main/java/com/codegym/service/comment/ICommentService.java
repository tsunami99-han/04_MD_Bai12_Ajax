package com.codegym.service.comment;

import com.codegym.model.Comment;
import com.codegym.model.Post;
import com.codegym.service.IGeneralService;

public interface ICommentService extends IGeneralService<Comment> {
    Iterable<Comment> findAllByPost(Post post);
}
