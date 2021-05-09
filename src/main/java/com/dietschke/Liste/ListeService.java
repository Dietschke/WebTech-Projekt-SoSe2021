package com.dietschke.Liste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ListeService {

    @Autowired
    private ListeRepository listeRepository;



    public Liste save(Liste liste)
    {
        return listeRepository.save(liste);

    }



}
