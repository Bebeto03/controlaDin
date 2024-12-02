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
import com.bebeto.controlaDin.repository.DespesaRepository;

import jakarta.validation.Valid;

@Controller
public class EditExpensesController {
    
    @Autowired
    private DespesaRepository despesaRepository;

    @GetMapping("/controlaDin/expenses/edit")
    public String showExpenseEditPage(Model model, @RequestParam long id){
        Despesa despesa = despesaRepository.findById(id);
        if(despesa==null){
            return "redirect:/controlaDin/expenses";
        }
        DespesaDto despesaDto = new DespesaDto();
        despesaDto.setName(despesa.getName());
        despesaDto.setDescription(despesa.getDescription());
        despesaDto.setAmount(despesa.getAmount());
        despesaDto.setDeadline(despesa.getDeadline());
        despesaDto.setStatus(despesa.getStatus());
        model.addAttribute("despesa", despesa);
        model.addAttribute("despesaDto", despesaDto);
        return "editExpense";
    }

    @PostMapping("/controlaDin/expenses/edit")
    public String editExpense(Model model, @RequestParam long id, @Valid @ModelAttribute DespesaDto despesaDto, BindingResult result){
        Despesa despesa = despesaRepository.findById(id);
        if(despesa==null){
            return "redirect:/controlaDin/expenses";
        }
        model.addAttribute("despesa", despesa);
        if(result.hasErrors()){
            return "editExpense";
        }
        despesa.setName(despesaDto.getName());
        despesa.setDescription(despesaDto.getDescription());
        despesa.setAmount(despesaDto.getAmount());
        despesa.setDeadline(despesaDto.getDeadline());
        despesa.setStatus(despesaDto.getStatus());
        despesaRepository.save(despesa);
        return "redirect:/controlaDin/expenses";
    }
}
