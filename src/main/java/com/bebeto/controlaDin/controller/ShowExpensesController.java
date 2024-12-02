package com.bebeto.controlaDin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bebeto.controlaDin.model.Despesa;
import com.bebeto.controlaDin.service.ShowExpensesService;

@Controller
@RequestMapping("/controlaDin/expenses")
public class ShowExpensesController {
    
    @Autowired
    private ShowExpensesService showExpensesService;

    @GetMapping({"", "/"})
    public String showExpensesPage(Model model){
        List<Despesa> despesas = showExpensesService.despesasUsuarioLogado();
        model.addAttribute("despesas", despesas);
        return "expenses";
    }

}
