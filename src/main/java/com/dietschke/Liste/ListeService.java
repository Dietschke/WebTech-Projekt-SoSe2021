package com.dietschke.Liste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ListeService {


    @Autowired
    private ListeRepository listeRepository;


    @Autowired
    public ListeService(ListeRepository listeRepository)
    {
        this.listeRepository = listeRepository;
    }

    public List<Liste> getAllListe() {
        return (List<Liste>) listeRepository.findAll();
    }

    public Liste save(Liste liste) {
        return listeRepository.save(liste);}

}
