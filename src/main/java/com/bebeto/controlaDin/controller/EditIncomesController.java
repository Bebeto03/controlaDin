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
import com.bebeto.controlaDin.repository.ReceitaRepository;

import jakarta.validation.Valid;

@Controller
public class EditIncomesController {

    @Autowired
    private ReceitaRepository receitaRepository;
    
    @GetMapping("/controlaDin/incomes/edit")
    public String showIncomeEditPage(Model model, @RequestParam long id){
        Receita receita = receitaRepository.findById(id);
        if(receita==null){
            return "redirect:/controlaDin/incomes";
        }
        ReceitaDto receitaDto = new ReceitaDto();
        receitaDto.setName(receita.getName());
        receitaDto.setDescription(receita.getDescription());
        receitaDto.setAmount(receita.getAmount());
        receitaDto.setReceipt(receita.getReceipt());
        receitaDto.setStatus(receita.getStatus());

        model.addAttribute("receita", receita);
        model.addAttribute("receitaDto", receitaDto);

        return "editIncome";
    }

    @PostMapping("/controlaDin/incomes/edit")
    public String editIncome(Model model, @RequestParam long id, @Valid @ModelAttribute ReceitaDto receitaDto, BindingResult result){
        Receita receita = receitaRepository.findById(id);
        if(receita==null){
            return "redirect:/controlaDin/incomes";
        }
        model.addAttribute("receita", receita);
        if(result.hasErrors()){
            return "editIncome";
        }
        receita.setName(receitaDto.getName());
        receita.setDescription(receitaDto.getDescription());
        receita.setAmount(receitaDto.getAmount());
        receita.setReceipt(receitaDto.getReceipt());
        receita.setStatus(receitaDto.getStatus());
        receitaRepository.save(receita);
        return "redirect:/controlaDin/incomes";
    }

}
