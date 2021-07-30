package com.codegym.service.statuspost;

import com.codegym.model.StatusPost;
import com.codegym.repository.IStatusPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StatusPostService implements IStatusPostService{
    @Autowired
    IStatusPostRepository statusPostRepository;

    @Override
    public Iterable<StatusPost> findAll() {
        return statusPostRepository.findAll();
    }

    @Override
    public Optional<StatusPost> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public StatusPost save(StatusPost statusPost) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
