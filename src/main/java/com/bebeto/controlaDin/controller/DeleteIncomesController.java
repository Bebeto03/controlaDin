package com.bebeto.controlaDin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bebeto.controlaDin.model.Receita;
import com.bebeto.controlaDin.repository.ReceitaRepository;

@Controller
public class DeleteIncomesController {

    @Autowired
    private ReceitaRepository receitaRepository;

    @GetMapping("/controlaDin/incomes/delete")
    public String deleteIncome(@RequestParam long id){
        Receita receita = receitaRepository.findById(id);
        if(receita!=null){
            receitaRepository.delete(receita);
        }
        return "redirect:/controlaDin/incomes";
    }
}
