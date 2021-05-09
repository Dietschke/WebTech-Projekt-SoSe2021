package com.dietschke.Liste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ListenControllerZwei
{
    @Autowired
    public ListeRepository listeRepository;

    @GetMapping("/listeerstellen")
    public String listeForm(Model model){
        model.addAttribute("liste", new Liste());
        return "liste";
    }

    @PostMapping("/listeerstellen")
    public String listeSubmit(@ModelAttribute Liste liste, Model model)
    {
       listeRepository.save(liste);
        model.addAttribute("liste", liste);
        return "listeresult";
    }
}
