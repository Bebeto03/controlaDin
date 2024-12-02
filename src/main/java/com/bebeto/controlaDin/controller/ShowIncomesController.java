package com.bebeto.controlaDin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bebeto.controlaDin.model.Receita;
import com.bebeto.controlaDin.service.ShowIncomesService;

@Controller
@RequestMapping("/controlaDin/incomes")
public class ShowIncomesController {

    @Autowired
    private ShowIncomesService showIncomesService;
    
    @GetMapping({"", "/"})
    public String showIncomesPage(Model model, @RequestParam(name = "sort", defaultValue = "default") String sort){
        List<Receita> receitas = showIncomesService.receitasUsuarioLogado(sort);
        model.addAttribute("receitas", receitas);
        model.addAttribute("sort", sort);
        return "incomes";
    }

    
}
