package com.bebeto.controlaDin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bebeto.controlaDin.service.DeleteIncomesService;

@Controller
public class DeleteIncomesController {

    @Autowired
    private DeleteIncomesService deleteIncomesService;

    @GetMapping("/controlaDin/incomes/delete")
    public String deleteIncome(@RequestParam long id){
        deleteIncomesService.apagarReceita(id);
        return "redirect:/controlaDin/incomes";
    }
}
