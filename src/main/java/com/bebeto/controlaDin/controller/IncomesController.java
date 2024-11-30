package com.bebeto.controlaDin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IncomesController {
    
    @GetMapping("/controlaDin/incomes")
    public String showIncomesPage(){
        return "incomes";
    }

    
}
