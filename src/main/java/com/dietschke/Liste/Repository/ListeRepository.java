package com.dietschke.Liste.Repository;

import com.dietschke.Liste.ListenClasses.Liste;
import org.springframework.data.repository.CrudRepository;

public interface ListeRepository extends CrudRepository<Liste, Long> {
}