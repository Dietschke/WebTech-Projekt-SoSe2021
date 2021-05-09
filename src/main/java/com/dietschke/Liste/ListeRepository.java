package com.dietschke.Liste;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ListeRepository extends CrudRepository<Liste, Long> {

    List<Liste> findByTitle(String title);
    Liste findById(long id);
}