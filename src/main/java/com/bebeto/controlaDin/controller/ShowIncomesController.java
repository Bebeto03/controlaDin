package com.bebeto.controlaDin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bebeto.controlaDin.model.Receita;
import com.bebeto.controlaDin.service.ShowIncomesService;

@Controller
@RequestMapping("/controlaDin/incomes")
public class ShowIncomesController {

    @Autowired
    private ShowIncomesService showIncomesService;
    
    @GetMapping({"", "/"})
    public String showIncomesPage(Model model){
        List<Receita> receitas = showIncomesService.receitasUsuarioLogado();
        model.addAttribute("receitas", receitas);
        return "incomes";
    }

    
}
