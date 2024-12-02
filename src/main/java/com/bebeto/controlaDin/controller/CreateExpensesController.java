package com.bebeto.controlaDin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bebeto.controlaDin.dto.DespesaDto;
import com.bebeto.controlaDin.service.CreateExpensesService;

import jakarta.validation.Valid;

@Controller
public class CreateExpensesController {

    @Autowired
    private CreateExpensesService createExpensesService;

    @GetMapping("/controlaDin/expenses/new")
    public String showNewExpensePage(Model model){
        model.addAttribute("despesaDto", new DespesaDto());
        return "newExpense";
    }

    @PostMapping("/controlaDin/expenses/new")
    public String createNewExpense(Model model, @Valid @ModelAttribute DespesaDto despesaDto, BindingResult result){

        if(!createExpensesService.criarDespesa(despesaDto, result)){
            return "newExpense";
        }
        return "redirect:/controlaDin/expenses";
    }

}
