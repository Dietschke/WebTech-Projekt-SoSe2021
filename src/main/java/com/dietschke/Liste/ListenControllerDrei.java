package com.dietschke.Liste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
public class ListenControllerDrei {

    @Autowired
    public ListeRepository listeRepository;

    @Autowired
    public ListeService listeService;

    @GetMapping("/all")
    String getAll(Model model){
        List<Liste> meineListen = listeService.getAllListe();
        model.addAttribute("test", meineListen);
        return "listentable";

    }
}