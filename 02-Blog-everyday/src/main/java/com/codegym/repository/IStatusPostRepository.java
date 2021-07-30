package com.codegym.repository;

import com.codegym.model.StatusPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusPostRepository extends CrudRepository<StatusPost,Long>{
}
