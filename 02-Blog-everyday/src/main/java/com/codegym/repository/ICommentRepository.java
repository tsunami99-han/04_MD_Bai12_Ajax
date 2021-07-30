package com.codegym.repository;

import com.codegym.model.Comment;
import com.codegym.model.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends PagingAndSortingRepository<Comment,Long> {
    Iterable<Comment> findAllByPost(Post post);
}
