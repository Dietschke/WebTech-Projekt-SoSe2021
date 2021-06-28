package com.dietschke.Liste.Controller;

import com.dietschke.Liste.ListenClasses.Liste;
import com.dietschke.Liste.Repository.ListeRepository;
import com.dietschke.Liste.ListenClasses.ListeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ListenControllerZwei
{
    @Autowired
    public ListeRepository listeRepository;

    @Autowired
    public ListeService listeService;

    @GetMapping("/listeerstellen")
    public String listeForm(Model model){
        model.addAttribute("liste", new Liste());
        return "liste";
    }

    @PostMapping("/listeerstellen")
    public String listeSubmit(@ModelAttribute Liste liste, Model model)
    {
        model.addAttribute("liste", liste);
        listeRepository.save(liste);
        return "listeresult";
    }

    @RequestMapping("/vue")
    public String vue(@ModelAttribute Liste liste, Model model)
    {
        model.addAttribute("liste", liste);

        return "vue";
    }
}
