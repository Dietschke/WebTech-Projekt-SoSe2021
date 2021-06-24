package com.dietschke.Liste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


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
