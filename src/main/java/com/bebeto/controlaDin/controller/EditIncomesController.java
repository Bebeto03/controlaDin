package com.bebeto.controlaDin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bebeto.controlaDin.dto.ReceitaDto;
import com.bebeto.controlaDin.model.Receita;
import com.bebeto.controlaDin.service.EditIncomesService;

import jakarta.validation.Valid;

@Controller
public class EditIncomesController {

    @Autowired
    private EditIncomesService editIncomesService;
    
    @GetMapping("/controlaDin/incomes/edit")
    public String showIncomeEditPage(Model model, @RequestParam long id){
        Receita receita = editIncomesService.carregarReceita(id);
        if(receita==null){
            return "redirect:/controlaDin/incomes";
        }
        ReceitaDto receitaDto = editIncomesService.mostrarReceita(receita);
        model.addAttribute("receita", receita);
        model.addAttribute("receitaDto", receitaDto);

        return "editIncome";
    }

    @PostMapping("/controlaDin/incomes/edit")
    public String editIncome(Model model, @RequestParam long id, @Valid @ModelAttribute ReceitaDto receitaDto, BindingResult result){
        Receita receita = editIncomesService.carregarReceita(id);
        if(receita==null){
            return "redirect:/controlaDin/incomes";
        }
        model.addAttribute("receita", receita);
        if(result.hasErrors()){
            return "editIncome";
        }
        editIncomesService.atualizarReceita(receita, receitaDto);
        return "redirect:/controlaDin/incomes";
    }

}
