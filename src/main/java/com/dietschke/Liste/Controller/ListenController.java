package com.dietschke.Liste.Controller;

import com.dietschke.Liste.ListenClasses.Liste;
import com.dietschke.Liste.Repository.ListeRepository;
import com.dietschke.Liste.ListenClasses.ListeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ListenController {

    @Autowired
    public ListeRepository listeRepository;

    @Autowired
    public ListeService listeService;

    private static final String template = "%s";
    private final AtomicLong counter = new AtomicLong();


    @GetMapping("/liste")
    public Liste liste(@RequestParam(value = "title", defaultValue = "kein Gericht :(") String title,
                       @RequestParam(value = "description",defaultValue = "keine Description :(") String description) {
        return new Liste(counter.incrementAndGet(), String.format(template,title), String.format(template, description));
    }

    @GetMapping("/alleListen")
    public List<Liste> alleListen(){
        return listeService.getAllListe();
    }

    @PostMapping ("/alleListen")
    public Liste createListe(@RequestBody Liste liste)
    {return listeService.save(liste);
    }

    @RequestMapping("/showListen")
    @GetMapping
    public List<Liste> getListen(){
        return listeService.getAllListe();
    }
}