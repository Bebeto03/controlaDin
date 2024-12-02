package com.bebeto.controlaDin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bebeto.controlaDin.service.DeleteExpensesService;

@Controller
public class DeleteExpensesCintroller {

   @Autowired
   private DeleteExpensesService deleteExpensesService;

    @GetMapping("/controlaDin/expenses/delete")
    public String deleteExpense(@RequestParam long id){
        deleteExpensesService.apagarDespesa(id);
        return "redirect:/controlaDin/expenses";
    }
}
