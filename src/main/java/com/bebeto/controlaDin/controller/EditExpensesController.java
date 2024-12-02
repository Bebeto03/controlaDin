package com.bebeto.controlaDin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bebeto.controlaDin.dto.DespesaDto;
import com.bebeto.controlaDin.model.Despesa;
import com.bebeto.controlaDin.service.EditExpensesService;

import jakarta.validation.Valid;

@Controller
public class EditExpensesController {
    
    @Autowired
    private EditExpensesService editExpensesService;

    @GetMapping("/controlaDin/expenses/edit")
    public String showExpenseEditPage(Model model, @RequestParam long id){
        Despesa despesa = editExpensesService.carregarDespesa(id);
        if(despesa==null){
            return "redirect:/controlaDin/expenses";
        }
        DespesaDto despesaDto = editExpensesService.mostrarDespesa(despesa);
        model.addAttribute("despesa", despesa);
        model.addAttribute("despesaDto", despesaDto);
        return "editExpense";
    }

    @PostMapping("/controlaDin/expenses/edit")
    public String editExpense(Model model, @RequestParam long id, @Valid @ModelAttribute DespesaDto despesaDto, BindingResult result){
        Despesa despesa = editExpensesService.carregarDespesa(id);
        if(despesa==null){
            return "redirect:/controlaDin/expenses";
        }
        model.addAttribute("despesa", despesa);
        if(result.hasErrors()){
            return "editExpense";
        }
        editExpensesService.atualizarDespesa(despesa, despesaDto);
        return "redirect:/controlaDin/expenses";
    }
}
