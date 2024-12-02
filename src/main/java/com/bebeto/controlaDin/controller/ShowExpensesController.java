package com.bebeto.controlaDin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bebeto.controlaDin.model.Despesa;
import com.bebeto.controlaDin.service.ShowExpensesService;

@Controller
@RequestMapping("/controlaDin/expenses")
public class ShowExpensesController {
    
    @Autowired
    private ShowExpensesService showExpensesService;

    @GetMapping({"", "/"})
    public String showExpensesPage(Model model, @RequestParam(name = "sort", defaultValue = "default") String sort){
        List<Despesa> despesas = showExpensesService.despesasUsuarioLogado(sort);
        model.addAttribute("despesas", despesas);
        model.addAttribute("sort", sort);
        return "expenses";
    }

}
