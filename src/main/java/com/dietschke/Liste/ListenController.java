package com.dietschke.Liste;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ListenController {

    public ListeRepository listeRepository;

    private static final String template = "%s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/listeKuchen")
    public Liste listeKuchen() {
        return new Liste(1L, "Kuchen", "Schokokuchen von Oma");
    }

    @GetMapping("/listeBurger")
    public Liste listeBurger() {
        return new Liste(2L, "Burger", "Lieblingsburger");
    }


    @GetMapping("/liste")
    public Liste liste(@RequestParam(value = "title", defaultValue = "kein Gericht :(") String title,
                       @RequestParam(value = "description",defaultValue = "keine Description :(") String description) {
        return new Liste(counter.incrementAndGet(), String.format(template,title), String.format(template, description));

    }

    @RequestMapping("/addNewListe")
    public String addNewListePage(Model model) {
        model.addAttribute("liste", new Liste());
        return "NewListe";
    }

    @GetMapping("/getTestListeDetails")
    public List<Liste> getTestListeDetails(){
        List<Liste> tList = new ArrayList<Liste>(){{
            add(new Liste(1L, "Kuchen", "Bester Kuchen der Welt"));
            add(new Liste(2L, "Burger", "Der Burger vom letzten Bday"));
            add(new Liste(3L, "Bouletten", "Bouletten die Vaddern immer gemacht hat"));
            add(new Liste(4L, "Weihnachtsgans", "Weihnachtsgans von Tante Frieda"));
        }};
        System.out.println((tList));
        return tList;
    }
}