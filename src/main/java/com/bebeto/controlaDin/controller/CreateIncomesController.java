package com.bebeto.controlaDin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bebeto.controlaDin.dto.ReceitaDto;
import com.bebeto.controlaDin.service.CreateIncomesService;

import jakarta.validation.Valid;

@Controller
public class CreateIncomesController {

    @Autowired
    private CreateIncomesService createIncomesService;

    @GetMapping("/controlaDin/incomes/new")
    public String showNewIncomePage(Model model){
        model.addAttribute("receitaDto", new ReceitaDto());
        return "newIncome";
    }

    @PostMapping("controlaDin/incomes/new")
    public String createNewIncome(Model model, @Valid @ModelAttribute ReceitaDto receitaDto, BindingResult result){
        if(!createIncomesService.criarReceita(receitaDto, result)){
            return "newExpense";
        }
        return "redirect:/controlaDin/incomes";
    }

}
