package com.codegym.repository;

import com.codegym.model.Smartphone;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ISmartphoneRepository extends PagingAndSortingRepository<Smartphone,Long> {
}
