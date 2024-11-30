package com.bebeto.controlaDin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpensesController {

    @GetMapping("/controlaDin/expenses")
    public String showExpensesPage(){
        return "expenses";
    }
}
