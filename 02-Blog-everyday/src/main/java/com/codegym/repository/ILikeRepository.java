package com.codegym.repository;

import com.codegym.model.Like;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikeRepository extends CrudRepository<Like,Long> {
}
